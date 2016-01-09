/**
 * This class must have only one constructor with only one parameter
 * of type List.
 */
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
public class ImprovedStackImpl implements ImprovedStack {

    @Override
    /**
     * Returns a copy of this stack with the items reversed, the top
     * elements on the original stack is at the bottom of the new
     * stack and viceversa.
     *
     * @return a copy of this stack with the items reversed.
     */
    public ImprovedStack reverse() {
        if (isEmpty()) {
            //this won't work so try returning an empty improved stack
            return ImprovedStack;
        } else {
            //How does this work? Is it accessing arraylists or
            //linkedlists in any way?
        }
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
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {

        }
        //traverse list
        //check if list item is equal to the object being checked
        //if list item is equal, remove it.
        //shift subsequent items in the stack
    }

    @Override
    /**
     * Returns true if the stack is empty, false otherwise.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (this.internalList.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
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
            return internalList.get((size())-1);
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
            return internalList.remove((size())-1);
        }
    }
}