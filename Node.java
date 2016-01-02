public class Node {
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
