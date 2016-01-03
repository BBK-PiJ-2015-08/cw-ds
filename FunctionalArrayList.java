/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for
 * grading.
 * the order is extends x implements y
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	public FunctionalArrayList() {
		super();
	}
	@Override
	/**
	 * Returns the element at the beginning of the list.
	 *
	 * If the list is empty, an appropriate error is returned.
	 *
	 * @return a copy of the element at the beginning of the list or
	 *         an error if the list is empty.
	 */
	public ReturnObject head () {
		if (numberOfItems == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		else {
			return new ReturnObjectImpl(this.get(0).getReturnValue());
		}
	}
	@Override
	/**
	 * Returns a list with the elements in this list except the
	 * head. The elements must be in the same order. The original list
	 * must not change or be affected by changes in the new list.
	 *
	 * If the list is empty, another empty list is returned.
	 */
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