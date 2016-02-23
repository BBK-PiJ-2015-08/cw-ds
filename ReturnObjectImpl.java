/**
 * This class must have two constructors, each of them with only 1
 * parameter. The constructor used for successful operations must
 * receive an Object (java.lang.object) and the constructor used
 * for failed operations must receive an ErrorMessage as its only
 * parameter
 */

/**
 * @author Jade Dickinson jdicki04
 */
public class ReturnObjectImpl implements ReturnObject {
	private Object obj;
	private ErrorMessage err;

	public ReturnObjectImpl(Object obj) {
		this.obj = obj;
		this.err = ErrorMessage.NO_ERROR;
	}

	public ReturnObjectImpl(ErrorMessage err) {
		this.obj = null;
		this.err = err;
	}

	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	@Override
	public boolean hasError() {
		return err != ErrorMessage.NO_ERROR;
	}
	/**
	 * Returns the error message.
	 *
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 *
	 * @return the error message
	 */
	@Override
	public ErrorMessage getError() {
		return err;
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 *
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 *
	 * @return the return value from the method or null if there has been an error
	 */
	@Override
	public Object getReturnValue() {
		return obj;
	}
}