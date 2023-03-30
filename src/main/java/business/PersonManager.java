package business;

import java.util.List;

import dao.PersonDAOFactory;
import dao.PersonsDAO;
import dao.RoleDAOFactory;
import domain.Person;
import domain.Role;
import exception.PersonBusinessException;
import exception.PersonDAOException;
import exception.RoleBusinessException;
import exception.RoleDAOException;

public class PersonManager {

	private final PersonsDAO dao;
	
	public PersonManager () {
		dao = PersonDAOFactory.getPersonsDAO();
	}
	
	// Добавление сотрудника - возвращает ID добавленного сотрудника
    public Long addPerson(Person person) throws PersonBusinessException {
        try {
            return dao.addPerson(person);
        } catch (PersonDAOException ex) {
            throw new PersonBusinessException(ex);
        }
    }
    
	// Редактирование данных по сотруднику
	public void updatePerson(Person person) throws PersonBusinessException {
		try {
			dao.updatePerson(person);
		} catch (PersonDAOException ex) {
			throw new PersonBusinessException(ex);
		}
	}

	// Удаление сотрудника по его Id
	public void deletePerson(Long Id) throws PersonBusinessException {
		try {
			dao.deletePerson(Id);
		} catch (PersonDAOException ex) {
			throw new PersonBusinessException(ex);
		}
	}

	// Получение одного сотрудника по Id
	public Person findByIdPerson(Long Id) throws RoleBusinessException {
		try {
			return dao.findByIdPerson(Id) ;
		} catch (PersonDAOException ex) {
			throw new RoleBusinessException(ex);
		}
	}

	// Получение списка сотрудников
	public List<Person> findAllRoles() throws PersonBusinessException {
		try {
			return dao.findAllPerson();
		} catch (PersonDAOException ex) {
			throw new PersonBusinessException(ex);
		}
	}

}
