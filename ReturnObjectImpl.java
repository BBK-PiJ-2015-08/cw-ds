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
	 * @see ReturnObject
	 */
	@Override
	public boolean hasError() {
		return err != ErrorMessage.NO_ERROR;
	}

	/**
	 * @see ReturnObject
	 */
	@Override
	public ErrorMessage getError() {
		return err;
	}

	/**
	 * @see ReturnObject
	 */
	@Override
	public Object getReturnValue() {
		return obj;
	}
}