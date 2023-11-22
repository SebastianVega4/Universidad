//
// Created by Jairo Riaño on 15/11/23.
//
#include <iostream>
#include "LinkedList.h"
template<class T>
LinkedList<T>::LinkedList() {
    LinkedList::head = NULL;
}

template<class T>
bool LinkedList<T>::isEmpty() {
    return head == NULL;
}

template<class T>
void LinkedList<T>::addNodeFirst(T info) {
    if( isEmpty()){
        head = new Node<T>(info);
    }else{
        Node<T> *newNode = new Node<T>(info);
        newNode->next = head;
        head = newNode;
    }
}

template<class T>
std::vector<T> LinkedList<T>::getLinkedList() {
    std::vector<T> linked;

    Node<T> *aux = head;
    while( aux != NULL ){
        linked.push_back( aux->info);
        aux = aux->next;
    }

    return linked;
}

template<class T>
Node<T>* LinkedList<T>::findNode(std::string id) {
    Node<T>* aux = head;
    while( aux != NULL ){
        if( aux->info.getId().compare(id) == 0 ){

            return aux;
        }
        aux = aux->next;
    }

    return NULL;
}

template<class T>
void LinkedList<T>::addNodeAfterTo(Node<T> *node, T info) {
    if( isEmpty()) {
        head = new Node<T>( info );
        // cout<<"El Nodo NO Existe"<<endl;
    }else{
        Node<T> *aux = head;
        while( aux->next != node ){
            aux = aux->next;
        }
        Node<T> *newNodee = new Node<T>(info);
        Node<T> *valBack = aux;
        newNodee->next = aux->next;
        valBack->next = newNodee;
    }
}

template<class T>
void LinkedList<T>::addNodeBeforeTo(Node<T> *node, T info) {
    if( isEmpty()) {
        head = new Node<T>( info );
    }else{
        Node<T> *newNodee = new Node<T>(info);
        Node<T> *valNextt = node->next;

        node->next = newNodee;
        newNodee->next = valNextt;
    }
}

template<class T>
void LinkedList<T>::addNodeLast(T info) {
    if( isEmpty()){
        head = new Node<T>( info );
    }else{
        Node<T> *aux = head;
        while( aux->next != NULL ){
            aux = aux->next;
        }

        Node<T> *node = new Node<T>(info);
        aux->next = node;
    }
}

template<class T>
LinkedList<T>::~LinkedList() {
    while( head != NULL ){
        Node<T> *delAux = head;
        head = head->next;
        delete(delAux);
    }
    delete(head);
}