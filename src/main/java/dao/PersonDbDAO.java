package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Person;
import domain.Role;
import exception.PersonDAOException;

public class PersonDbDAO implements PersonsDAO {

	private static final String SELECT = "SELECT id, "
			+ "firstname, lastname, role.rolename, phone, email FROM persons ORDER BY lastname, firstname";
	private static final String SELECT_ONE = "SELECT id, "
			+ "firstname, lastname, role.rolename, phone, email FROM persons WHERE id=?";
	private static final String INSERT = "INSERT INTO persons (firstname, "
			+ "lastname, role.rolename, phone, email) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE persons SET firstname=?,"
			+ "lastname=?, role.rolename=?, phone=?, email=? WHERE id=?";
	private static final String DELETE = "DELETE FROM persons WHERE id=?";
	
	private ConnectionBuilder builder = new SimpleConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }
	
	
	public PersonDbDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long addPerson(Person person) throws PersonDAOException {
		try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(INSERT, new String[]{"id"})) {
            Long Id = -1L;
            pst.setString(1, person.getFirstName());
            pst.setString(2, person.getLastName());
            pst.setString(3, person.getRole());
            pst.setString(4, person.getPhone());
            pst.setString(4, person.getEmail());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                Id = gk.getLong("id");
            }
            gk.close();
            return Id;
        } catch (Exception e) {
            throw new PersonDAOException(e);
        }
	}

	@Override
	public void updatePerson(Person person) throws PersonDAOException {
		try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(UPDATE)) {
			pst.setString(1, person.getFirstName());
            pst.setString(2, person.getLastName());
            pst.setString(3, person.getRole());
            pst.setString(4, person.getPhone());
            pst.setString(4, person.getEmail());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new PersonDAOException(e);
        }
		
	}

	@Override
	public void deletePerson(Long Id) throws PersonDAOException {
		try (Connection con = getConnection();
                PreparedStatement pst = con.prepareStatement(DELETE)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new PersonDAOException(e);
        }
		
	}

	@Override
	public Person findByIdPerson(Long Id) throws PersonDAOException {
		Person person = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(SELECT_ONE);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                person = fillPerson(rs);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw new PersonDAOException(e);
        }
        return person;
	}

	@Override
	public List<Person> findAllPerson() throws PersonDAOException {
		 List<Person> list = new LinkedList<>();
	        try (Connection con = getConnection();
	                PreparedStatement pst = con.prepareStatement(SELECT);
	                ResultSet rs = pst.executeQuery()) {
	            while (rs.next()) {
	                list.add(fillPerson(rs));
	            }
	            rs.close();
	        } catch (Exception e) {
	            throw new PersonDAOException(e);
	        }
	        return list;
	}
	
	private Person fillPerson(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong("id"));
		person.setFirstName(rs.getString("firstname"));
		person.setLastName(rs.getString("last_name"));
		person.setRole((Role) (rs.getObject("role")));
		person.setPhone(rs.getString("phone"));
		person.setEmail(rs.getString("email"));
		return person;
	}

}
