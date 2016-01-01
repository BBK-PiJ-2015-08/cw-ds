/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for grading.
 */
public class LinkedList implements List
    private int nodeAt;
    private int numberOfNodes;
    private LinkedListNode head;

    public LinkedList() {
        head = null;
        numberOfNodes = 0;
    }

    @Override
    //not done
    /**
     * Returns true if the list is empty, false otherwise.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (head == null) {
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
        if (!isEmpty()) {
            return numberOfNodes;
        } else {
            return 0;
        }
    }
    //Do I need a HasNext type method?
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
    //not done
    public ReturnObject get(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if (index<0 || index>numberOfNodes){
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            LinkedListNode current = head;
            nodeAt = 0;
            while (nodeAt < index) {
                current = current.next;
                nodeAt++;
            }
            //check this is returning in the right format
            return current;
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
    //not done
    public ReturnObject remove(int index) {
        if (!isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        else if (index < 0 || index>=numberOfNodes) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS)
        } else if (there is only one item in list) {
            store it
                    set this item, the head to null
                    increment the number of nodes down one.
                    return the stored removed element
        } else if (the item to be removed is the head){
            store it
                    set the head to the next item
                    while next.next is not equal to null, assign the next element
                    to this element
                    increment down the numberofnodes
                    return the stored removed element
        }
            //All other cases
            else {
                LinkedListNode current = head;
                nodeAt = 0;
                while (nodeAt < index) {
                current = current.next;
                nodeAt++;
            }
            // check if the below should be this.node
            ReturnObject elementRemoved = new ReturnObjectImpl(current);
            while (nodeAt < numberOfNodes) {
                current = current.next;
                nodeAt++;
            } while (nodeAt = numberOfNodes) {
            }
                node = delete this node
                numberOfNodes--;
                return elementRemoved;

//            go to the element at the given position
//                  store the element
                    shift everything subsequent back 1
                    delete the final element
//                    minus one from the number of elements
//                    return the removed element

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
    //not done
    public ReturnObject add(int index, Object item) {
        //don't forget invalid argument error
        if (index < 0 || index > numberOfNodes) {
                return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            }

        else if (isEmpty()) {
            if (given position isn't 0) {
                return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                insert as first node
                        increment numberofnodes up by 1
                        return an empty ReturnObject
            }
        }
        else {
                start at first node
                        go along to final position
                        shift everything up one until you are back at the element for which
                        the index was specified
                        add the item at that index
                        increment numberofnodes up by 1
                        return an empty ReturnObject
            }
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
    //not done
    public ReturnObject add(Object item) {
        //don't forget invalid argument error
        if (this.next == null) {
            this.next = item;
        } else {
            this.next.add(item);
        }
        return null;
    }
}