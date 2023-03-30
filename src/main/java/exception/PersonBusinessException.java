package exception;

public class PersonBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonBusinessException() {
		// TODO Auto-generated constructor stub
	}
	
	public PersonBusinessException(String message) {
        super(message);
    }

    public PersonBusinessException(Throwable cause) {
        super(cause);
    }

    public PersonBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
