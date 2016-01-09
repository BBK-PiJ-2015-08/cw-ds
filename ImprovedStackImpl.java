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
 */

/**
 * This class must have only one constructor with only one parameter
 of type List.
 */
public class ImprovedStackImpl implements ImprovedStack {

    protected List internalList;

    public ImprovedStackImpl(List list) {
        this.internalList = list;
    }

    /**
     * That code did not actually have a way to access the top, pop methods of StackImpl
     * as it only referred to ImprovedStack, which was just an interface. Try to create an
     * object of type StackImpl. Failing that, keep code copied from StackImpl
     * @return
     */


    @Override
    /**
     * Returns a copy of this stack with the items reversed, the top
     * elements on the original stack is at the bottom of the new
     * stack and viceversa.
     *
     * @return a copy of this stack with the items reversed.
     */
    public ImprovedStack reverse() {
        List reversedArrayList = new ArrayList();
        ImprovedStack reversedList = new ImprovedStackImpl(reversedArrayList);
        if (!(internalList.isEmpty())) {
            for (int s = (internalList.size())-1; s>=0; s--) {
                reversedList.push(internalList.get(s).getReturnValue());
            }
        }
        return reversedList;
        /**
         * Create an ImprovedStack
         * Assign a list (specific type or general) to it
         * Want to return an empty object if list is empty
         * Make adding values to list part of loop that is only
         * entered if this list is not empty
         * in this if loop
         * have a for loop, where you take the final value
         * of the list and add it to the ImprovedStack
         * this should start at the index equal to the size -1
         * and use the add() method to add the value from
         * the get value. use getreturnvalue to avoid hash codes
         */


    }

    @Override
    /**
     * Removes the given object from the stack if it is
     * there. Multiple instances of the object are all removed.
     *
     * Classes implementing this method must use method .equals() to
     * check whether the item is in the stack or not.
     *
     * @param object the object to remove
     */
    public void remove(Object object) {

    }

    @Override
    /**
     * Returns true if the stack is empty, false otherwise.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of items currently in the stack
     */
    public int size() {
        return internalList.size();
    }

    @Override
    /**
     * Adds an element at the top of the stack.
     *
     * @param item the new item to be added
     */
    public void push(Object item) {
        if (item != null) {
            internalList.add(item);
        }
        return;
    }

    @Override
    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject top() {
        if (internalList.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return new ReturnObjectImpl(internalList.get((size()) - 1));
        }
    }

    @Override
    /**
     * Returns the element at the top of the stack. The element is
     * removed frmo the stack.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject pop() {
        if (internalList.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return new ReturnObjectImpl(internalList.remove((size())-1));
        }
    }
}