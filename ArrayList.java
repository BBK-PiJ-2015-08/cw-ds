/**
 * @author Jade Dickinson jdicki04
 */
public class ArrayList implements List {
	private Object[] intArray;
	private final static int DEFAULT_SIZE = 32;
	private int max = 32;
	private int numberOfItems = 0;

	public ArrayList() {
		intArray = new Object[DEFAULT_SIZE];
	}

	/**
	 * @see List
     */
	@Override
	public boolean isEmpty() {
		return numberOfItems==0;
	}

	/**
	 * @see List
	 */
	@Override
	public int size() {
		return numberOfItems;
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject get(int index) {
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			return new ReturnObjectImpl(intArray[index]);
		}
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject remove(int index) {
		if (index < 0 || index >= numberOfItems) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			ReturnObject itemRemoved = new ReturnObjectImpl(intArray[index]);
			int shiftUpPoint = index + 1;
			for (int i = shiftUpPoint ; i<numberOfItems; i++) {
				intArray[i-1] = intArray[i];
			}
			intArray[numberOfItems] = null;
			numberOfItems--;
			return itemRemoved;
		}
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject add(int index, Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (index < 0 || index >= (this.size())) {
				return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			} else {
				if (numberOfItems >= max) {
					increaseSizeTwofold();
				}
				int j = numberOfItems - 1;
				for (int pos = j; pos >= index; pos--) {
					intArray[pos + 1] = intArray[pos];
				}
				intArray[index] = item;
				numberOfItems++;
				return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			}
		}
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			if (numberOfItems >= max) {
				increaseSizeTwofold();
			}
			this.intArray[numberOfItems] = item;
			numberOfItems++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
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