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
            Node aux=head;
            nodeNew.setNext(head);
            while(aux.getNext()!=head){
                aux=aux.getNext();
            }
            head=nodeNew;
            aux.setNext(nodeNew);
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
        if (node==head.getInfo().getDigit()){
            return head;
        }
        do{
            if( node==aux.getNext().getInfo().getDigit()){
                return aux.getNext();
            }
            aux = aux.getNext();
        }while( aux != head);
        return null;
    }

    public List<Digit> getLinked(){
        ArrayList<Digit> list = new ArrayList<>();
        Node aux = head;
        do{
            list.add( aux.getInfo());
            aux = aux.getNext();
        }while( aux != head );
        return list;
    }

    public Node jumping(Node aux,int v){
        for (int i = 0; i < v ; i++) {
            aux.getInfo().setVisited(true);
            aux= aux.getNext();
        }
        return aux;
    }

    public boolean isJumping(){
        Node aux = head;
        do{
            aux= jumping(aux,aux.getInfo().getDigit());
        }while(!aux.getInfo().isVisited() && aux != head && !aux.getNext().getInfo().isVisited());
        return aux != head;
    }

    private boolean isAllVisited(){
        ArrayList<Digit> list = new ArrayList<>();
        Node aux = head;
        do{
            list.add(aux.getInfo());
            aux = aux.getNext();
        }while(aux != head);
        for (Digit digit : list) {
            if (!digit.isVisited()) {
                return false;
            }
        }
        return true;
    }
}