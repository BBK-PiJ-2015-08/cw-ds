/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for grading.
 */
public class ArrayList implements List {
	protected Object[] intArray;
	protected final static int DEFAULT_SIZE = 32;
	protected int max = 32;
	protected int numberOfItems = 0;
	protected int j = 0;

	public ArrayList() {
		intArray = new Object[DEFAULT_SIZE];
	}

	@Override
	public boolean isEmpty() {
		if (numberOfItems==0) {
			return true;
		}
	else {
			return false;
		}
	}

	@Override
	public int size() {
		return numberOfItems;
	}

	@Override
	public ReturnObject get(int index) {
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(intArray[index]);
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			ReturnObject itemRemoved = new ReturnObjectImpl(intArray[index]);
			for (int i = index+1 ; i<numberOfItems; i++) {
				intArray[i-1] = intArray[i];
			}
			intArray[numberOfItems] = null;
			numberOfItems--;
			//N.B. making the below a returnobject makes it start returning
			//hash values.
			return itemRemoved;
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		/**
		 * Adds an element to the list, inserting it at the given
		 * position. The indeces of elements at and after that position
		 * must be updated accordignly.
		 *
		 * If the index is negative or greater or equal than the size of
		 * the list, then an appropriate error must be returned.
		 *
		 * If a null object is provided to insert in the list, the
		 * request must be ignored and an appropriate error must be
		 * returned.
		 *
		 * @param index the position at which the item should be inserted in
		 *              the list
		 * @param item the value to insert into the list
		 * @return an ReturnObject, empty if the operation is successful
		 *         or containing an appropriate error message otherwise
		 */
		if ((item == null)) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if ((index%1) != 0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (index < 0 || index>=(this.size())) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			if (numberOfItems >= max) {
				increaseSizeTwofold();
			}
			j = index;
			while (!((intArray[j+1]) == null)) {
				j++;
			}
			for (int pos = j; pos>=index; pos--) {
				intArray[pos+1] = intArray[pos];
			}
			intArray[index] = item;
			numberOfItems++;
			return new ReturnObjectImpl(null);
		}
	}

	@Override
	public ReturnObject add(Object item) {
		/**
		 * Adds an element at the end of the list.
		 *
		 * If a null object is provided to insert in the list, the
		 * request must be ignored and an appropriate error must be
		 * returned.
		 *
		 * @param item the value to insert into the list
		 * @return an ReturnObject, empty if the operation is successful
		 *         or containing an appropriate error message otherwise
		 */
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			if (numberOfItems >= max) {
				increaseSizeTwofold();
			}
			intArray[numberOfItems] = item;
			numberOfItems++;
			return new ReturnObjectImpl(null);
		}
	}

	public void increaseSizeTwofold() {
		max = max * 2;
		Object[] storageArray = new Object[max];
		for (int k=0; k<numberOfItems; k++) {
			storageArray[k] = this.intArray[k];
		}
		intArray = storageArray;
	}
}