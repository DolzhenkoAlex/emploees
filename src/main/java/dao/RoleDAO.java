package dao;

import java.util.List;

import domain.Role;
import exception.RoleException;

/**
 * Интерфейс для определения функций хранлища данных о должностях
 */
public interface RoleDAO {
	
	// Добавление должности - возвращает ID добавленного должности
    public Long addRole(Role role) throws RoleException;
    
    // Редактирование должности
    public void updateRole(Role role) throws RoleException;
    
    // Удаление должности
    public void deleteRole(Long Id) throws RoleException;
    
    // Поиск должности по Id
    public Role findByIdRole(Long Id) throws RoleException;
    
    // Получение списка должностей
    public List<Role> findAllRole() throws RoleException;
    
    // Сохранение должности 
    // public Role save(Role role); 
}
