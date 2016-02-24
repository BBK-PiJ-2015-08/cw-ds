/**
 * @author Jade Dickinson jdicki04
 */
public class LinkedList implements List {
    private int nodeAt;
    private int numberOfNodes;
    private Node head;
    private Node current;
    private Node storedNode;
    private Node storageNode;
    private final static int ONLYONENODE = 1;

    public LinkedList() {
        head = null;
        numberOfNodes = 0;
    }

    private class Node {
        private Object obj;
        private Node next;
        public Node (Object obj) {
            this.obj = obj;
            this.next = null;
        }
        public Object getValue() {
                return this.obj;
            }
        public Node getNext() {
                return this.next;
            }
        public void setNext (Node nxt) {
            this.next = nxt;
        }
    }

    /**
     * @see List
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @see List
     */
    @Override
    public int size() {
       return numberOfNodes;
    }

    /**
     * @see List
     */
    @Override
    public ReturnObject get(int index) {
        ReturnObject elementGotOrError;
        if (isEmpty()) {
            elementGotOrError = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            if (index < 0 || index >= numberOfNodes) {
                elementGotOrError = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            } else {
                current = head;
                nodeAt = 0;
                while (nodeAt < index) {
                    current = current.getNext();
                    nodeAt++;
                }
                elementGotOrError = new ReturnObjectImpl(current.getValue());
            }
        }
        return elementGotOrError;
    }

    /**
     * @see List
     */
    @Override
    public ReturnObject remove(int index) {
        ReturnObject elementRemoved;
        if (isEmpty()) {
            elementRemoved = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if (index < 0 || index>=numberOfNodes) {
            elementRemoved = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else if (numberOfNodes == ONLYONENODE) {
            elementRemoved = new ReturnObjectImpl(head.getValue());
            head = null;
            numberOfNodes--;
        } else if (index == 0) {
            current = head;
            elementRemoved = new ReturnObjectImpl(head.getValue());
            head = current.getNext();
            current.setNext(null);
            numberOfNodes--;
        } else {
            current = head;
            nodeAt = 0;
            while (nodeAt < index - 1) {
                current = current.getNext();
                nodeAt++;
            }
            elementRemoved = new ReturnObjectImpl(current.getNext().getValue());
            while (nodeAt < numberOfNodes) {
                current.setNext(current.getNext());
                nodeAt++;
            }
            numberOfNodes--;
        }
        return elementRemoved;
    }

    /**
     * @see List
     */
    @Override
    public ReturnObject add(int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else if (index < 0 || index > numberOfNodes) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            storageNode = new Node(item);
            if (isEmpty()) {
                head = storageNode;
                numberOfNodes++;
            } else {
                nodeAt = 0;
                current = head;
                while (nodeAt < index - 1) {
                    current = current.getNext();
                    nodeAt++;
                }
                storageNode.setNext(current.getNext());
                current.setNext(storageNode);
                numberOfNodes++;
            }
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
    }

    /**
     * @see List
     */
    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            storedNode = new Node(item);
            if (head == null) {
                head = storedNode;
                numberOfNodes++;
            } else {
                current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(storedNode);
                numberOfNodes++;
            }
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
    }
}