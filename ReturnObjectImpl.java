public class ReturnObjectImpl implements ReturnObject {
	/**
	 * This class must have two constructors, each of them with only 1
	 * parameter. The constructor used for successful operations must
	 * receive an Object (java.lang.object) and the constructor used
	 * for failed operations must receive an ErrorMessage as its only
	 * parameter
	 */
	private Object obj;
	private ErrorMessage err;

	public ReturnObjectImpl(Object obj) {
		this.obj = obj;
		//this.em = ErrorMessage.NO_ERROR;
	}

	public ReturnObjectImpl(ErrorMessage err) {
		this.err = err;
	}

	//public (ErrorMessage em) {
	//	this.obj = em;
	//	this.obj = null;
	//}

	@Override
	public boolean hasError() {
		return false;
	}

	@Override
	public ErrorMessage getError() {
		return null;
	}

	@Override
	public Object getReturnValue() {
		return null;
	}
}