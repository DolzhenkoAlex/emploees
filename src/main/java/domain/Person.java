package domain;

import domain.Role;

/**
 *   Класс для хранения данных сотрудника
 */
public class Person {
	
	// Идентификатор сотрудника
    private Long id;
    
      // Имя
    private String firstName;
    
    // Фамилия
    private String lastName;
    
    // Телефон
    private String phone;
    
    // email
    private String email;
    
    // Должность
	private Role role;

    public Person() {
	}
    
    public Person(String firstName, String lastName, String phone,  String email, Role role) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.phone = phone;
    	this.role = role;
    }
    
    public Person(Long id, String firstName, String lastName, String phone,  String email, Role role) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.phone = phone;
    	this.role = role;
    }
    
        
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role role () {
		return role;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role.getNamerole();
	}
		
	@Override
	public String toString() {
		return "Role {" + "Id = " + id + 
				", firstName = " + firstName + 
				", lastName = " + lastName + 
				", phone = " + phone + 
				", email = " + email +
				", namerole = " + getRole() + 
				"}";
	}
}
