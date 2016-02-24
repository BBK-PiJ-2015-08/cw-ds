/**
 * @author Jade Dickinson jdicki04
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	public FunctionalArrayList() {
	}
	/**
	 * @see FunctionalList
	 */
	@Override
	public ReturnObject head () {
		ReturnObject objectToReturn;
		if (size() == 0) {
			objectToReturn = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			objectToReturn = new ReturnObjectImpl(this.get(0).getReturnValue());
		}
		return objectToReturn;
	}

	/**
	 * @see FunctionalList
	 */
	@Override
	public FunctionalList rest() {
		FunctionalArrayList storageFAL = new FunctionalArrayList();
		if (!isEmpty()) {
			for (int i = 1; i<size(); i++) {
				storageFAL.add(this.get(i).getReturnValue());
			}
		}
		return storageFAL;
	}
}