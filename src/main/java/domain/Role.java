package domain;


public class Role {
	
	// Идентификатор должности
	private Long id;
	
	// Наименование должности
	private String namerole;

	public Role() {
	}
	
	public Role(String namerole) {
		this.namerole = namerole;
	}


	public Long getId() {
		return id;
	}

	public String getNamerole() {
		return namerole;
	}

	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}
	
	@Override
	public String toString() {
		return "Role {" + "Id = " + id + ", NameRole = " + namerole + "}";
	}
}
