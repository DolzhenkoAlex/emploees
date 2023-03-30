package business;

import java.util.List;

import dao.RoleDAO;
import dao.RoleDAOFactory;
import domain.Role;
import exception.RoleBusinessException;
import exception.RoleDAOException;

public class RoleManager {
	// TODO Auto-generated constructor stub
	private final RoleDAO dao;
	
	public RoleManager () {
		dao = RoleDAOFactory.getRoleDAO();
	}
	
	// Добавление должности - возвращает ID добавленной должности
    public Long addRole(Role role) throws RoleBusinessException {
        try {
            return dao.addRole(role);
        } catch (RoleDAOException ex) {
            throw new RoleBusinessException(ex);
        }
    }
    
	// Редактирование должности
	public void updateRole(Role role) throws RoleBusinessException {
		try {
			dao.updateRole(role);
		} catch (RoleDAOException ex) {
			throw new RoleBusinessException(ex);
		}
	}

	// Удаление должности по её Id
	public void deleteRole(Long Id) throws RoleBusinessException {
		try {
			dao.deleteRole(Id);
		} catch (RoleDAOException ex) {
			throw new RoleBusinessException(ex);
		}
	}

	// Получение одной должности по Id
	public Role findByIdRole(Long Id) throws RoleBusinessException {
		try {
			return dao.findByIdRole(Id) ;
		} catch (RoleDAOException ex) {
			throw new RoleBusinessException(ex);
		}
	}

	// Получение списка должностей
	public List<Role> findAllRoles() throws RoleBusinessException {
		try {
			return dao.findAllRole();
		} catch (RoleDAOException ex) {
			throw new RoleBusinessException(ex);
		}
	}
}
