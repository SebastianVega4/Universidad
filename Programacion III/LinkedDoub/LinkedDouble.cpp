
#include <string>
#include "LinkedDouble.h"
#include "VolleyballPlayer.h"

template<class T>
LinkedDouble<T>::LinkedDouble() {
    head = NULL;
    last = NULL;
}

template<class T>
bool LinkedDouble<T>::isEmpty() {
    return head == NULL && last == NULL;
}

template<class T>
void LinkedDouble<T>::addNodeFirst(T info) {
    auto* newNode = new Node<T>(info);
    if ( isEmpty( ) ){
        head = newNode;
        last = newNode;
    }else{
        head->previous = newNode;
        newNode->next = head;
        head = newNode;
    }
}

template<class T>
void LinkedDouble<T>::addNodeLast(T info) {
    auto* newNode = new Node<T>(info);
    if ( isEmpty( ) ){
        head = newNode;
        last = newNode;
    }else{
        last->next = newNode;
        newNode->previous = last;
        last = newNode;
    }
}

template<class T>
void LinkedDouble<T>::addNodeAfterTo(Node<T> *node, T info) {
    auto* newNode = new Node<T>(info);
    newNode->next = node->next;
    newNode->previous = node;
    if (node->next != NULL) {
        node->next->previous = newNode;
    } else {
        last = newNode;
    }
    node->next = newNode;
}

template<class T>
void LinkedDouble<T>::addNodeBeforeTo(Node<T> *node, T info) {
    auto* newNode = new Node<T>(info);
    newNode->next = node;
    newNode->previous = node->previous;
    if (node->previous != NULL) {
        node->previous->next = newNode;
    } else {
        head = newNode;
    }
    node->previous = newNode;
}

template<class T>
void LinkedDouble<T>::addNodeSorted(T info){
    auto* newNode = new Node<T>(info);
    Node<T>* current = head;
    while (current != NULL && current->info.getNumberPlayer() < info.getNumberPlayer()) {
        current = current->next;
    }
    if (current == NULL) {
        addNodeLast(info);
    } else if (current->previous == NULL) {
        addNodeFirst(info);
    } else {
        newNode->next = current;
        newNode->previous = current->previous;
        current->previous->next = newNode;
        current->previous = newNode;
    }
}

template<class T>
Node<T>* LinkedDouble<T>::findNode(int namePLayer) {
    Node<T>* aux = head;
    while( aux != NULL ){
        if( aux->info.getNumberPlayer() == namePLayer){
            return aux;
        }
        aux = aux->next;
    }

    return NULL;
}

template<class T>
T LinkedDouble<T>::findInfo(int namePLayer) {
    Node<T>* node = findNode(namePLayer);
    if (node != NULL) {
        return node->info;
    } else {
        return node;
    }
}
template<class T>
vector<T> LinkedDouble<T>::getLinkedList(bool forward) {
    std::vector<T> out;
    Node<T>* aux = forward ? head : last;
    while( aux != NULL ){
        out.push_back( aux->info );
        aux = forward ? aux->next : aux->previous;
    }

    return out;
}

template<class T>
string LinkedDouble<T>::deleteNode(Node<T> *node){
    if (node == head) {
        head = node->next;
    } else {
        node->previous->next = node->next;
    }
    if (node == last) {
        last = node->previous;
    } else {
        node->next->previous = node->previous;
    }
    delete node;
    return "Nodo eliminado";
}
template<class T>
int LinkedDouble<T>::getSize(){
    int count = 0;
    Node<T>* current = head;
    while (current != NULL) {
        count++;
        current = current->next;
    }
    return count;
}
template<class T>
T* LinkedDouble<T>::getObject(int NumberPLayer){
    Node<T>* node = findNode(NumberPLayer);
    if (node != NULL) {
        return &node->info;
    } else {
        return NULL;
    }
}

template<class T>
VolleyballPlayer LinkedDouble<T>::getFirst(){
 return head->info;
}

template<class T>
VolleyballPlayer LinkedDouble<T>::getLast(){
    return last->info;
}

template<class T>
LinkedDouble<T>::~LinkedDouble() {

}