/**
 * @author Jade Dickinson jdicki04
 */
public class ImprovedStackImpl implements ImprovedStack {
    private Stack internalList;

    public ImprovedStackImpl(List list) {
        internalList = new StackImpl(list);
    }

    /**
     * @see ImprovedStack
     */
    @Override
    public ImprovedStack reverse() {
        Stack reversedList = new ImprovedStackImpl(new ArrayList());
        Stack storageListForRebuilding = new ImprovedStackImpl(new ArrayList());
        Object objectToAdd;
        while (!internalList.top().hasError() ) {
            objectToAdd = internalList.pop().getReturnValue();
            reversedList.push(objectToAdd);
            storageListForRebuilding.push(objectToAdd);
        }
        while (storageListForRebuilding.size() != 0) {
            objectToAdd = storageListForRebuilding.pop().getReturnValue();
            internalList.push(objectToAdd);
        }
        return (ImprovedStack) reversedList;
    }

    /**
     * @see ImprovedStack
     */
    @Override
    public void remove(Object object) {
        if (!(internalList.isEmpty())) {
            Stack reversedWithoutObject = new ImprovedStackImpl(new ArrayList());
            Object currentObject;
            while (internalList.size() != 0) {
                currentObject = internalList.pop().getReturnValue();
                if (!currentObject.equals(object)) {
                    reversedWithoutObject.push(currentObject);
                }
            }
            while (reversedWithoutObject.size() != 0) {
                internalList.push(reversedWithoutObject.pop().getReturnValue());
            }
        }
    }

    /**
     * @see Stack
     */
    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    /**
     * @see Stack
     */
    @Override
    public int size() {
        return internalList.size();
    }

    /**
     * @see Stack
     */
    @Override
    public void push(Object item) {
        internalList.push(item);
    }

    /**
     * @see Stack
     */
    @Override
    public ReturnObject top() {
        return internalList.top();
    }

    /**
     * @see Stack
     */
    @Override
    public ReturnObject pop() {
        return internalList.pop();
    }
}