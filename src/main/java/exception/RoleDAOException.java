package exception;

public class RoleDAOException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleDAOException() {
		}
	
	public RoleDAOException(String message) {
		super(message);
	}
	
	public RoleDAOException(Throwable cause) {
		super(cause);
	}
	
	public RoleDAOException(String message, Throwable cause) {
		super(message, cause);
	}
}
	
