public class ReturnObjectImpl implements ReturnObject {
	/**
	 * This class must have two constructors, each of them with only 1
	 * parameter. The constructor used for successful operations must
	 * receive an Object (java.lang.object) and the constructor used
	 * for failed operations must receive an ErrorMessage as its only
	 * parameter
	 */
	private Object obj;
	private ErrorMessage em;

	public ReturnObjectImpl(Object obj) {
		this.obj = obj;
		this.em = ErrorMessage.NO_ERROR;
	}

	public (ErrorMessage em) {
		this.obj = em;
		this.obj = null;
	}

	@Override
	public boolean hasError() {
		return em != ErrorMessage.NO_ERROR;
	}

	@Override
	public ErrorMessage getError() {
		return em;
	}

	@Override
	public Object getReturnValue() {
		return obj;
	}
}