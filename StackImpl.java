/**
 *
 * This class must have only one constructor with only one
 * parameter of type List (i.e. a stack can be created using either
 * an ArrayList or a LinkedList as the underlying data structure).
 * An implementation of a stack that uses a {@List} as the underlying
 * data structure.
 *
 */
/**
 * @author Jade Dickinson jdicki04
 */
public class StackImpl extends AbstractStack {
    /**
     * Creates a new abstract stack using the provided list as the
     * underlying data structure.
     *
     * Note: This constructor does not check whether the provided list
     * is null. Programmers must do their own checks. If a null list
     * is provided, a NullPointerException will be thrown at runtime
     * as soon as any operation is attempted on the underlying list.
     *
     * @param list the list to be used
     */
    public StackImpl(List list) {
        super(list);
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
        internalList.add(item);
    }

    /**
     * @see Stack
     */
    @Override
    public ReturnObject top() {
        if (internalList.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return internalList.get(size()-1);
        }
    }

    /**
     * @see Stack
     */
    @Override
    public ReturnObject pop() {
        if (internalList.isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return internalList.remove(size()-1);
        }
    }
}