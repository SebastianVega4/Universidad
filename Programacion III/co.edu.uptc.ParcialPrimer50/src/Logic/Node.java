package Logic;

public class Node{
    private Digit info;
    private Node next;
    public Node(Digit info) {
        this.info = info;
        this.next = null;
    }

    public void setInfo(Digit info) {
        this.info = info;
    }

    public Digit getInfo() {
        return info;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}