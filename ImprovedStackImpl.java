/**
 * An implementation of a stack with additional methods.
 *
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack.
 *
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 * This class must have only one constructor with only one parameter
 of type List.
 */
public class ImprovedStackImpl implements ImprovedStack {

    Stack internalList = new StackImpl();
    /**
    private List internalList;

    public ImprovedStackImpl(List list) {
        this.internalList = list;
    }
    */
    /**
     * Returns a copy of this stack with the items reversed, the top
     * elements on the original stack is at the bottom of the new
     * stack and viceversa.
     *
     * @return a copy of this stack with the items reversed.
     * Create an ImprovedStack. Assign a list (specific type or general) to it. Want to return an empty object if list is empty
     * Make adding values to list part of loop that is only entered if this list is not empty in this if loop have
     * a for loop, where you take the final value of the list and add it to the ImprovedStack this should start at
     * the index equal to the size -1 and use the add() method to add the value from the get value.
     * use getreturnvalue to avoid hash codes
     */
    @Override
    public ImprovedStack reverse() {
        List reversedArrayList = new ArrayList();
        ImprovedStack reversedList = new ImprovedStackImpl(reversedArrayList);
        if (!(internalList.isEmpty())) {
            int lastIndexInList = internalList.size()-1;
            for (int s = lastIndexInList; s>=0; s--) {
                reversedList.push(internalList.get(s).getReturnValue());
            }
        }
        return reversedList;

    }
    /** Removes the given object from the stack if it is there. Multiple instances of the object are all removed.
     * Classes implementing this method must use method .equals() to check whether the item is in the stack or not.
     * @param object the object to remove
     */
    /**
     * Need to go through list, checking if the object matches any of the values
     * Don't need to return anything as this is a void method
     * If the list is empty, just skip all the rest of the method
     * Want to make a holder list, to add the values not matching Object object
     * Once have finished going through list, want to reassign holder list to original internalList
     *
     * Think about other errors, e.g. can skip everything if the object is null
     */
    @Override
    public void remove(Object object) {
        if (!(internalList.isEmpty())) {
            //List nonMatchingArrayList = new ArrayList();
            //ImprovedStack reversedList = new ImprovedStackImpl(reversedArrayList);
            ImprovedStackImpl reversedWithoutObject = new ImprovedStackImpl();
            Object currentObject;
            while (internalList.size() != 0) {
                currentObject = internalList.pop().getReturnValue();
                if (!currentObject.equals(object)) {
                    reversedWithoutObject.push(currentObject);
                }
            }
            Object storageObject;
            while (reversedWithoutObject.size() != 0) {
                storageObject = reversedWithoutObject.pop().getReturnValue();
                internalList.push(storageObject);
            }

            /**
            Object currentObject;
            int finalIndexPos = internalList.size()-1;
            for (int t = 0; t <= finalIndexPos; t++) {
                currentObject = pop().getReturnValue();
                if (!currentObject.equals(object)) {
                    nonMatchingArrayList.add(currentObject);
                }
            }
            int upperBound = nonMatchingArrayList.size() - 1;
            for (int v = 0; v<=upperBound; v++) {
                this.push(nonMatchingArrayList.get(v).getReturnValue());
            }
             */
        }
    }
    /**
     * Returns true if the stack is empty, false otherwise.
     *
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }
    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of items currently in the stack
     */
    @Override
    public int size() {
        return internalList.size();
    }
    /**
     * Adds an element at the top of the stack.
     *
     * @param item the new item to be added
     */
    @Override
    public void push(Object item) {
        if (item != null) {
            this.internalList.push(item);
        }
    }
    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    @Override
    public ReturnObject top() {
        if (internalList.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return internalList.get(this.internalList.size() - 1);
        }
    }
    /**
     * Returns the element at the top of the stack. The element is
     * removed frmo the stack.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    @Override
    public ReturnObject pop() {
        if (internalList.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return this.internalList.pop();
        }
    }
}