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
	private long numberOfItems = 0;
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
		} else {
			ReturnObject itemRemoved = new ReturnObjectImpl;
			itemRemoved = (intArray[index]);
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
		//The below line may cause problems where array has already been
		//declared. n.b. size is numberOfItems<- index problem if this==0
		//Also want to avoid doubling if array is not yet full
		//Need to count the size of the array (even if numberofitems is smaller)
		//What if it's specifying to add to a specific index when there are no
		//items in the array?
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
		if ((numberOfItems(intArray)).equals(0)) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS)
		} else if ((item.equals(null)) || index%1 !=0) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index>=) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (intArray[index].equals(null)) {
			intArray[index] = item;
			numberOfItems++;
		} else {
			j = index;
			while (j.nextNode != null) {
				j++;
			}
			while (j>index) {
				intArray[j+1] = intArray[j];
				j--;
			}
			intArray[index] = item;
			numberOfItems++;
		}
	}
	/**
	Have to create another array, and emulate (but DON'T USE) arraycopy
			* when you hit the end of the array, you should double the size of the array
													   * to add your next element. this is done by creating a second array,
											   * copying the first array into that, and adding the last element to the end
													   * of the array.
													   * Sounds liek this would add an item to a specified point in the array then
													   * shift the subsequent elements along one. If there are no elements, create the
											   * first element (and assign size)
	* Also use this to increment the numberOfItems counter up by one each time an
	* element is added
	**/
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
		/**if(numberOfItems==0) {
		 private Object[] storageArray = new storageArray[32];
		 } else {
		 private Object[] storageArray =  new storageArray[numberOfItems*2];
		 }
		 if (index >= 0 )
		 */
		if (item.equals(null)) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else if (numberOfItems.equals(currentSizeOfArray)) {
			increaseSizeTwofold(intArray);
		}
	}

	public ReturnObject increaseSizeTwofold(ArrayList) {
		Object[] storageArray<doubledCount> = new Object[currentSizeOfArray*2];
		for (int k=0; k<numberOfItems; k++) {
			storageArray<doubledCount>[k] = intArray[k];
		}
		intArray = storageArray<doubledCount>;
		doubledCount++;
	}
}