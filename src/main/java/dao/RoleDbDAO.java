package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Role;
import exception.RoleDAOException;

public class RoleDbDAO implements RoleDAO{
	
	private static final String SELECT = "SELECT id, rolename FROM persons ORDER BY rolename";
	private static final String SELECT_ONE = "SELECT id, rolename FROM persons WHERE id=?";
	private static final String INSERT = "INSERT INTO persons (rolename) VALUES (?)";
	private static final String UPDATE = "UPDATE persons SET rolename=? WHERE id=?";
	private static final String DELETE = "DELETE FROM persons WHERE id=?";
	
	private ConnectionBuilder builder = new SimpleConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }


	@Override
	public Long addRole(Role role) throws RoleDAOException {
		try (Connection con = getConnection();
				PreparedStatement pst = con.prepareStatement(INSERT, new String[] { "id" })) {
			Long Id = -1L;
			pst.setString(1, role.getNamerole());
			pst.executeUpdate();
			ResultSet gk = pst.getGeneratedKeys();
			if (gk.next()) {
				Id = gk.getLong("id");
			}
			gk.close();
			return Id;
		} catch (Exception e) {
			throw new RoleDAOException(e);
		}
	}

	@Override
	public void updateRole(Role role) throws RoleDAOException {
		try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(UPDATE)) {
            pst.setString(1, role.getNamerole());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RoleDAOException(e);
        }
		
	}

	@Override
	public void deleteRole(Long Id) throws RoleDAOException {
		try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(DELETE)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RoleDAOException(e);
        }
	}

	@Override
	public Role findByIdRole(Long Id) throws RoleDAOException {
		Role role = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(SELECT_ONE);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                role = fillRole(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new RoleDAOException(e);
        }
        return role;
	}

	@Override
	public List<Role> findAllRole() throws RoleDAOException {
		List<Role> list = new LinkedList<>();
        try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(SELECT);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(fillRole(rs));
            }
            rs.close();
        } catch (Exception e) {
            throw new RoleDAOException(e);
        }
        return list;
	}
	
	private Role fillRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getLong("id"));
        role.setNamerole(rs.getString("namerole"));
                return role;
    }

}
