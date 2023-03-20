package dao;

import domain.Role;

import java.util.List;

import domain.Person;
import exception.RoleException;

/**
 * Интерфейс для определения функций хранлища данных о сотрудниках
 */

public interface PersonsDAO {
	
	// Добавление сотрудника - возвращает ID добавленного сотрудника
    public Long addPerson(Person person) throws RoleException;
    
    // Редактирование данных по сотруднику
    public void updatePerson(Person person) throws RoleException;
    
    // Удаление данных по сотруднику
    public void deletePerson(Long Id) throws RoleException;
    
    // Поиск сотрудника по Id
    public Person findByIdPerson(Long Id) throws RoleException;
    
    // Получение списка сотрудников
    public List<Person> findAllPerson() throws RoleException;
}
