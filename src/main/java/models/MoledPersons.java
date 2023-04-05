package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Person;

public class MoledPersons {

	private static MoledPersons instance = new MoledPersons();

	private List<Person> modelPersons;

	public static MoledPersons getInstance() {
		return instance;
	}

	private MoledPersons() {
		modelPersons = new ArrayList<>();
    }

	public void addPerson(Person person) {
		modelPersons.add(person);
	}

	public List<String> list() {
		return modelPersons.stream()
				.map(Person::getFirstName)
				.collect(Collectors.toList());
	}

}
