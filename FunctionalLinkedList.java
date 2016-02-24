/**
 * @author Jade Dickinson jdicki04
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    public FunctionalLinkedList() {

    }
    /**
     * Returns the element at the beginning of the list.
     *
     * If the list is empty, an appropriate error is returned.
     *
     * @return a copy of the element at the beginning of the list or
     *         an error if the list is empty.
     */
    @Override
    public ReturnObject head() {
        ReturnObject headElementOrError;
        if (isEmpty()) {
            headElementOrError = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            headElementOrError = new ReturnObjectImpl(get(0).getReturnValue());
        }
        return headElementOrError;
    }
    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list.
     *
     * If the list is empty, another empty list is returned.
     */
    @Override
    public FunctionalList rest() {
        FunctionalLinkedList storageFLL = new FunctionalLinkedList();
        if (!isEmpty()) {
            for(int i = 0; i<size(); i++) {
                storageFLL.add(get(i).getReturnValue());
            }
        }
        return storageFLL;
    }
}
