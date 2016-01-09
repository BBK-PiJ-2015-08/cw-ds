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
    //Need to create the internalImpList which is a renamed version of internalList from StackImpl
    //Renamed that to avoid confusion
    //Think this renaming actually means my top & pop methods won't work
    // as they are looking
    // to check if internalList is Empty and find internalImpList instead.

    protected List internalList;

    public ImprovedStackImpl(List list) {
        super();
        this.internalList = list;
    }

    //Is there a way I can just use the previously coded size, top, pop
    //methods instead of having replicated code?. Think using super will
    //do it: http://beginnersbook.com/2014/07/super-keyword-in-java-with-example/

    @Override
    /**
     * Returns a copy of this stack with the items reversed, the top
     * elements on the original stack is at the bottom of the new
     * stack and viceversa.
     *
     * @return a copy of this stack with the items reversed.
     */
    public ImprovedStack reverse() {
        //Not working at all so start from scratch
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
        //Not working at all so start from scratch
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
        internalList.push(item);
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
        return internalList.top();
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
        return internalList.pop();
    }
}