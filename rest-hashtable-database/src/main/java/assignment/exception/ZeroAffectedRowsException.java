package assignment.exception;

public class ZeroAffectedRowsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZeroAffectedRowsException(String errorMsg) {
		super(errorMsg);
	}

}
