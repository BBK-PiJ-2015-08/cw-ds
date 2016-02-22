public class FunctionalArrayList extends ArrayList implements FunctionalList {
	public FunctionalArrayList() {
		super();
	}
	/**
	 * Returns the element at the beginning of the list.
	 *
	 * If the list is empty, an appropriate error is returned.
	 *
	 * @return a copy of the element at the beginning of the list or
	 *         an error if the list is empty.
	 */
	@Override
	public ReturnObject head () {
		if (numberOfItems == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			return new ReturnObjectImpl(this.get(0).getReturnValue());
		}
	}
	/**
	 * Returns a list with the elements in this list except the
	 * head. The elements must be in the same order. The original list
	 * must not change or be affected by changes in the new list.
	 *
	 * If the list is empty, another empty list is returned.
	 */
	@Override
	public FunctionalList rest() {
		FunctionalArrayList storageFAL = new FunctionalArrayList();
		if (isEmpty()) {
			return storageFAL;
		} else {
			for (int i = 1; i<size(); i++) {
				storageFAL.add(this.get(i).getReturnValue());
			}
			return storageFAL;
		}
	}
}