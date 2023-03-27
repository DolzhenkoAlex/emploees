package dao;

import domain.Person;
import exception.PersonDAOException;
import java.util.List;

/**
 * Интерфейс для определения функций хранилища данных о сотрудниках
 */

public interface PersonsDAO {
	
	// Добавление сотрудника - возвращает ID добавленного сотрудника
    public Long addPerson(Person person) throws PersonDAOException;
    
    // Редактирование данных по сотруднику
    public void updatePerson(Person person) throws PersonDAOException;
    
    // Удаление данных по сотруднику
    public void deletePerson(Long Id) throws PersonDAOException;
    
    // Поиск сотрудника по Id
    public Person findByIdPerson(Long Id) throws PersonDAOException;
    
    // Получение списка сотрудников
    public List<Person> findAllPerson() throws PersonDAOException;
}
