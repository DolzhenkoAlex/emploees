package exception;

public class RoleBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleBusinessException() {
		// TODO Auto-generated constructor stub
	}
	
	public RoleBusinessException(String message) {
        super(message);
    }

    public RoleBusinessException(Throwable cause) {
        super(cause);
    }

    public RoleBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
