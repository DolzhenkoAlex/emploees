package exception;

public class RoleException extends Exception{
	
	public RoleException() {
		}
	
	public RoleException(String message) {
		super(message);
	}
	
	public RoleException(Throwable cause) {
		super(cause);
	}
	
	public RoleException(String message, Throwable cause) {
		super(message, cause);
	}
}
	
