package Logic;

import java.util.ArrayList;
import java.util.List;

public class ListCircled {
    private Node head;

    public ListCircled() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addNodeFirst(Digit digit) {
        if (isEmpty()) {
            head = new Node(digit);
            head.setNext(head);
        } else {
            Node nodeNew = new Node(digit);
            nodeNew.setNext(head);
            head=nodeNew;
        }
    }

    public void addNodeLast(Digit digit) {
        Node newnode = new Node(digit);
        if (isEmpty()) {
            addNodeFirst(digit);
        } else {
            Node aux = head;
            while (aux.getNext() != head) {
                aux = aux.getNext();
            }
            aux.setNext(newnode);
            newnode.setNext(head);
        }
    }

    public Node findNode( int node ){
        Node aux = head;
        do {
            if (node == aux.getInfo().getDigit()) {
                return aux;
            }
            aux = aux.getNext();
        } while (aux != head);
        return null;
    }

    public List<Digit> getLinked(){
        List<Digit> list = new ArrayList<>();
        Node aux = head;
        do {
            list.add(aux.getInfo());
            aux = aux.getNext();
        } while (aux != head);
        return list;
    }

    public Node jumping(Node nd, int v) {
        for (int i = 0; i < v; i++) {
            if (!nd.getInfo().isVisited()) {
                nd.getInfo().setVisited(true);
            }
            nd = nd.getNext();
        }
        return nd;
    }

    public boolean isJumping() {
        Node aux = head;
        do {
            aux = jumping(aux, aux.getInfo().getDigit());
            if (isAllVisted()) {
                return true;
            }
        } while (!aux.getInfo().isVisited());
        return false;
    }

    private boolean isAllVisted(){
        Node aux = head;
        do {
            if (!aux.getInfo().isVisited()) {
                return false;
            }
            aux = aux.getNext();
        } while (aux != head);
        return true;
    }
}