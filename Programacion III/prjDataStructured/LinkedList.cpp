//
// Created by julia on 15/11/2023.
//

#include "LinkedList.h"
#include <vector>


template<class T>
LinkedList<T>::~LinkedList() {
    LinkedList::head = NULL;
}

template<class T>
std::vector<T> LinkedList<T>::getLinkedList() {
    std::vector<T> linked;
    Node<T> *aux = head;

    while (aux != NULL){
        linked.push_back(aux->info);
        aux = aux->next;
    }

    return linked;
}

template<class T>
void LinkedList<T>::addNodeFirst(T info) {
    head = new Node<T>(info);
if(isEmpty()){
      Node<T> *aux = new Node<T>(info);
    aux -> next = head;
    head = aux;

  }
}

template<class T>
void LinkedLast<T>::addNodeLast(T info) {
    head = new Node<T>(info);
    if(isEmpty()){
        Node<T> *aux = new Node<T>(info);
        aux -> next = head;
        head = aux;

    }
}

template<class T>
bool LinkedList<T>::isEmpty() {
    return head == NULL;
}

template<class T>
LinkedList<T>::LinkedList() {

}