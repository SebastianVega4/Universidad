#include <iostream>

#include "Dish.h"

#include "LinkedList.cpp"

using namespace std;

int main() {

    LinkedList<Dish> *linkedList = new LinkedList<Dish>();

    linkedList->addNodeFirst( Dish("3020","Pollo a la Cazadora",35000,false,340));
    linkedList->addNodeLast( Dish("4060","Bisteck",20000,false,400));
    linkedList->addNodeFirst( Dish("2468","Pasta",15000,true,100));
    linkedList->addNodeLast( Dish("1010","Mojarra",40000,false,450));
    linkedList->addNodeFirst( Dish("2020","Bagre Frito",43000,false,340));

    linkedList->addNodeAfterTo( linkedList->findNode("2020"),Dish("3210","Sancocho",15000,false,200));
    linkedList->addNodeAfterTo( linkedList->findNode("1010"),Dish("6900","Ensalada",10000,true,50));

    for( Dish dish : linkedList->getLinkedList()){
        cout<<dish<<endl;
    }

    Node<Dish> *node = linkedList->findNode("10130");

    if( node != NULL ){
        cout<<"El Nodo Existe"<<endl;
    }else{
        cout<<"El Nodo NO Existe"<<endl;
    }

    delete(linkedList);

    return 0;
}
