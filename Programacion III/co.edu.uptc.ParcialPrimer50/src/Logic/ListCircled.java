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
        Node newnode= new Node(digit);
        if(isEmpty()) {
            addNodeFirst(digit);
        }else {
            Node aux2;
            Node aux = head;
            do{
                aux2 = aux;
                aux = aux.getNext();
            }while( aux != head );
                aux2.setNext(newnode);
                newnode.setNext(head);
        }
    }

    public Node findNode( int node ){
        Node aux = head;
        if (node==head.getInfo().getdigit()){
            return head;
        }
        do{
            if( node==aux.getNext().getInfo().getdigit()){
                return aux.getNext();
            }
            aux = aux.getNext();
        }while( aux != head);
        return null;
    }

    public List<Digit> getLinked(){
        ArrayList<Digit> list = new ArrayList<>();
        Node aux = head;
        Node aux2 ;
        do{
            list.add( aux.getNext().getInfo());
            aux2 = aux;
            aux = aux.getNext();
        }while( aux != head );
        return list;
    }

    public Node jumping(Node nd,int v){
        Node aux=nd;
        for (int i = 1; i < v ; i++) {
            aux.getInfo().setVisited(true);
            aux= nd.getNext();
        }
        return aux;
    }

    public boolean isJumping(){
        ArrayList<Digit> list = new ArrayList<>();
        Node aux = head;
        Node aux2 ;
        do{
            aux= jumping(aux,aux.getInfo().getdigit());

        }while( aux.getInfo().isVisited() != true );
        return false;
    }

    private boolean isAllVisted(){
        ArrayList<Digit> list = new ArrayList<>();
        Node aux = head;
        Node aux2 ;
        do{
            list.add( aux.getNext().getInfo());
            aux = aux.getNext();
        }while( aux != head );
        return false;
    }
}