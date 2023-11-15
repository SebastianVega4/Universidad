#include <iostream>

#include "Node.h"
#include "Dish.h"

using namespace std;

int main() {

    Node<char> *node = new Node<char>('J');
    node->setNext( new Node<char>('A'));
    node->getNext()->setNext( new Node<char>('I'));

    cout<<node->getInfo()<<node->getNext()->getInfo()<<node->getNext()->getNext()->getInfo()<<endl;

    Node<char>* aux = node;
    while( aux != NULL ){
        cout<<aux->getInfo();
        aux = aux->getNext();
    }

    Node<char>* back = node->getNext();

    delete(node);

    Node<Dish> *nodeTom = new Node<Dish>( Dish("01","Tomahhowk",85000.0,false,700));

    Node<Dish> *nodeHam = new Node<Dish>( Dish("02","Hamburguesa",23000,true,100));


    nodeHam->setNext( nodeTom );
    //nodeTom->setNext( nodeHam );

    Node<Dish> *auxDish = nodeHam;

    while( auxDish != NULL ){
        cout<<auxDish->getInfo()<<endl;
        auxDish = auxDish->getNext();
    }

    //cout<<nodeTom<<endl;
   // cout<<nodeHam<<endl;

    return 0;
}
