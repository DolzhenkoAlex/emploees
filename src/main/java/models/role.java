package models;

public class role {
	
	private Long id;
	
	private String namerole;

	public role() {
	}
	
	public role(String namerole) {
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
}
