/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for grading.
 */
public class LinkedList implements List {
    protected int nodeAt;
    protected int numberOfNodes;
    protected Node head;

    public LinkedList() {
        head = null;
        numberOfNodes = 0;
    }
    /**
     * Returns true if the list is empty, false otherwise.
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Returns the number of items currently in the list.
     * @return the number of items currently in the list
     */
    @Override
    public int size() {
       return numberOfNodes;
    }
    /**
     * Returns the element at the given position.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    @Override
    public ReturnObject get(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if (index<0 || index>=numberOfNodes){
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            Node current = head;
            nodeAt = 0;
            while (nodeAt < index) {
                current = current.getNext();
                nodeAt++;
            }
            //check this is returning in the right format
            return new ReturnObjectImpl(current.getValue());
        }
    }
    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    @Override
    public ReturnObject remove(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        else if (index < 0 || index>=numberOfNodes) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (numberOfNodes == 1) {
            ReturnObject elementRemoved = new ReturnObjectImpl(head.getValue());
            head = null;
            numberOfNodes--;
            return elementRemoved;
        } else if (index == 0) {
            ReturnObject elementRemoved = new ReturnObjectImpl(head.getValue());
            head = head.getNext();
            numberOfNodes--;
            return elementRemoved;
        }
            else {
                Node current = head;
                nodeAt = 0;
                while (nodeAt < index - 1) {
                    current = current.getNext();
                    nodeAt++;
                }
                ReturnObject elementRemoved = new ReturnObjectImpl(current.getNext().getValue());
                while (nodeAt < numberOfNodes) {
                    current.setNext(current.getNext());
                    nodeAt++;
                }
                //current.setNext(null);
                numberOfNodes--;
                return elementRemoved;
        }
    }
    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
    @Override
    public ReturnObject add(int index, Object item) {
        //don't forget invalid argument error: Added. Precedence for Invalid
        //Argument over Index_Out_Of_bounds?
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else if (index < 0 || index > numberOfNodes) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }
        Node storageNode = new Node(item);
        if (isEmpty()) {
            head = storageNode;
            numberOfNodes++;
            //check that this should be returning the item
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        } else {
            nodeAt = 0;
            Node current = head;
            while (nodeAt < index - 1) {
                current = current.getNext();
                nodeAt++;
            }
            storageNode.setNext(current.getNext());
            current.setNext(storageNode);
            numberOfNodes++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
    }
    /**
     * Adds an element at the end of the list.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            Node storedNode = new Node(item);
            if (head == null) {
                head = storedNode;
                numberOfNodes++;
                return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
            } else {
                Node current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(storedNode);
                numberOfNodes++;
                return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
            }
        }
    }
}