/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for grading.
 */
public class ArrayList implements List {
	//No constructors
	private Object[] intArray;

	private final static int DEFAULT_SIZE = 32;
	protected int currentSizeOfArray;
	private int numberOfItems = 0;
	private int i = 0;
	private int j = 0;
	private int doubledCount = 0;

	public ArrayList() {
		intArray = new Object[DEFAULT_SIZE];
		currentSizeOfArray = DEFAULT_SIZE;
	}

	@Override
	public boolean isEmpty() {
		//if (this.nextNode == null) {
		//	return true;
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

	// nb the below is not using the class, it is indicating that the return value will be an object of type ReturnObject
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
			for (i = index+1 ; i<numberOfItems; i++) {
				intArray[i-1] = intArray[i];
			}
			intArray[numberOfItems] = null;
			numberOfItems--;
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
		if (numberOfItems==0) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index>=numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if ((intArray[index]) == null) {
			intArray[index] = item;
			numberOfItems++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		} else {
			j = index;
			while (!((intArray[j+1]) == null)) {
				j++;
			}
			while (j>index) {
				intArray[j+1] = intArray[j];
				j--;
			}
			intArray[index] = item;
			numberOfItems++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
	}
	/**
	 * If there are no elements, create the first element (and assign size)
	*/
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
		else if (numberOfItems == currentSizeOfArray) {
			increaseSizeTwofold(intArray);
			intArray[numberOfItems] = item;
			numberOfItems++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);

		} else {
			intArray[numberOfItems] = item;
			numberOfItems++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
	}
	public void increaseSizeTwofold(Object[] intArray) {
		Object[] storageArray = new Object[currentSizeOfArray * 2];
		for (int k=0; k<numberOfItems; k++) {
			storageArray[k] = intArray[k];
		}
		intArray = storageArray;
		doubledCount++;
	}
}