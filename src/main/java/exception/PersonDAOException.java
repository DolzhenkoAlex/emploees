package exception;

public class PersonDAOException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonDAOException() {
	}
	
	public PersonDAOException(String message) {
		super(message);
	}
	
	public PersonDAOException(Throwable cause) {
		super(cause);
	}
	
	public PersonDAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
