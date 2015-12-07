public class ReturnObjectImpl implements ReturnObject {
	private Object obj;
	private ErrorMessage em;

	public ReturnObjectImpl(Object obj) {
		this.obj = obj;
		this.em = ErrorMessage.NO_ERROR;
	}

	public (ErrorMessage em) {
		this.em = em;
		this.obj = null;
	}

	@Override
	public boolean hasError() {
		return em != ErrorMesage.NO_ERROR;
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