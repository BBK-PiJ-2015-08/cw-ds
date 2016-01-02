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

    @Override
    //not done
    /**
     * Returns true if the list is empty, false otherwise.
     * @return true if the list is empty, false otherwise.
     */
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
    //not done
    public ReturnObject remove(int index) {
        if (!isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }
        else if (index < 0 || index>=numberOfNodes) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (numberOfNodes == 1) {
            /** (there is only one item in list) {
             store it
             set this item, the head to null
             increment the number of nodes down one.
             return the stored removed element
             */
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
        /**
            else if (the item to be removed is the head)
            store it
                    set the head to the next item
                    while next.next is not equal to null, make the next element
                    the head
                    increment down the numberofnodes
                    return the stored removed element
         */
            else {
                Node current = head;
                nodeAt = 0;
                while (nodeAt < index) {
                    current = current.getNext();
                    nodeAt++;
                }
                ReturnObject elementRemoved = new ReturnObjectImpl(current.getValue());
                while (nodeAt < numberOfNodes) {
                    current.setNext(current.getNext());
                    nodeAt++;
                }
                current = null;
                numberOfNodes--;
                return elementRemoved;
        }
    }
//            go to the element at the given position
//                  store the element
//                    shift everything subsequent back 1
//                    delete the final element
//                    minus one from the number of elements
//                    return the removed element

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
        //don't forget invalid argument error: Added. Precedence for Invalid
        //Arguement over Index_Out_Of_bounds?
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }
        else if (index < 0 || index > numberOfNodes) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }
        Node storageNode = new Node(item);
        else if (isEmpty()) {
            if (index == 0) {
                head = storageNode;
                numberOfNodes++;
                //check if this should be returning the item
                return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
            }
        } else {
                /**
                nodeAt = 0;
                while (nodeAt < numberOfNodes) {
                    Node current = current.getNext();
                    nodeAt++;
                }
                 */
                    for (int i = 0; i < (index-1); i++) {
                        Node current = current.getNext();
                    }
                    storageNode.setNext(current.getNext());
                    current.setNext(storageNode);
                    numberOfNodes++;
                    return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
}
                /**
                while (nodeAt > index) {
                    // is the line below assigning a value or just shifting
                    //the position in the linkedlist
                    //Just struggling to make the current node take the
                    //value of the previous node
                    Node current = current.setNext(current);
                    nodeAt--;
                }
                 */
                /**
                 start at first node
                 go along to final position
                 shift everything forward one until you are back at the element for which
                 the index was specified
                 add the item at that index
                 increment numberofnodes up by 1
                 return an empty ReturnObject
                 */
                /**
                shift node at end, followed by each previous node until nodeAt = index, forward one. Recursive?
                 while nodeAt = index, add Object item to this node
                increment numberofnodes up by 1
                return an empty ReturnObject
                */

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
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else if (head == null) {
            head = item;
            numberOfNodes++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(item);
            numberOfNodes++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
        /**
        if (this.next == null) {
            this.next = item;
        } else {
            this.next.add(item);
        }
        return null;
         */
    }
}