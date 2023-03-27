package dao;

import java.util.List;

import domain.Role;
import exception.RoleDAOException;

/**
 * Интерфейс для определения функций хранлища данных о должностях
 */
public interface RoleDAO {
	
	// Добавление должности - возвращает ID добавленного должности
    public Long addRole(Role role) throws RoleDAOException;
    
    // Редактирование должности
    public void updateRole(Role role) throws RoleDAOException;
    
    // Удаление должности
    public void deleteRole(Long Id) throws RoleDAOException;
    
    // Поиск должности по Id
    public Role findByIdRole(Long Id) throws RoleDAOException;
    
    // Получение списка должностей
    public List<Role> findAllRole() throws RoleDAOException;
}
