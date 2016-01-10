/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for grading.
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {
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
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return new ReturnObjectImpl(head.getValue());
        }
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
        if (isEmpty()) {
            return storageFLL;
        } else {
            Node current = head.getNext();
            storageFLL.add(current.getValue());
            while (current.getNext() != null) {
                current = current.getNext();
                storageFLL.add(current.getValue());
            }
            return storageFLL;
        }
    }
}
