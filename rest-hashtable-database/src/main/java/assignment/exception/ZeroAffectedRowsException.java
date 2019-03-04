package assignment.exception;

/**
 * Own exception class for implementation purpose
 * @author Doric
 *
 */
public class ZeroAffectedRowsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZeroAffectedRowsException(String errorMsg) {
		super(errorMsg);
	}

}
