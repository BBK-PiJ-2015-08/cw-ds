/**
 * @author Jade Dickinson jdicki04
 */
public class ArrayList implements List {
	private Object[] internalArray;
	private final static int DEFAULT_SIZE = 32;
	private int max = 32;
	private int numberOfItems;

	public ArrayList() {
		internalArray = new Object[DEFAULT_SIZE];
		numberOfItems = 0;
	}

	/**
	 * @see List
     */
	@Override
	public boolean isEmpty() {
		return size()==0;
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
		ReturnObject alElementGotOrError;
		if (isEmpty()) {
			alElementGotOrError = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index >= size()) {
			alElementGotOrError = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			alElementGotOrError = new ReturnObjectImpl(internalArray[index]);
		}
		return alElementGotOrError;
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject remove(int index) {
		ReturnObject alElementRemoved;
		if (index < 0 || index >= size()) {
			alElementRemoved = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (this.isEmpty()) {
			alElementRemoved = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else {
			alElementRemoved = new ReturnObjectImpl(internalArray[index]);
			int shiftUpPoint = index + 1;
			for (int i = shiftUpPoint ; i<size(); i++) {
				internalArray[i-1] = internalArray[i];
			}
			internalArray[numberOfItems] = null;
			numberOfItems--;
		}
		return alElementRemoved;
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject add(int index, Object item) {
		ReturnObject alResultAddingToGivenIndex;
		if (item == null) {
			alResultAddingToGivenIndex = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (index < 0 || index >= (this.size())) {
				alResultAddingToGivenIndex = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			} else {
				if (numberOfItems >= max) {
					increaseSizeTwofold();
				}
				int j = numberOfItems - 1;
				for (int pos = j; pos >= index; pos--) {
					internalArray[pos + 1] = internalArray[pos];
				}
				internalArray[index] = item;
				numberOfItems++;
				alResultAddingToGivenIndex = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			}
		}
		return alResultAddingToGivenIndex;
	}

	/**
	 * @see List
	 */
	@Override
	public ReturnObject add(Object item) {
		ReturnObject alResultAddingToEndList;
		if (item == null) {
			alResultAddingToEndList = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		else {
			if (numberOfItems >= max) {
				increaseSizeTwofold();
			}
			this.internalArray[numberOfItems] = item;
			numberOfItems++;
			alResultAddingToEndList = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		return alResultAddingToEndList;
	}

	public void increaseSizeTwofold() {
		max = max * 2;
		Object[] storageArray = new Object[max];
		for (int k=0; k<numberOfItems; k++) {
			storageArray[k] = this.internalArray[k];
		}
		internalArray = storageArray;
	}
}