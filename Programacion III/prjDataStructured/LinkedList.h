//
// Created by julia on 15/11/2023.
//

#ifndef LINKEDLIST_LINKEDLIST_H
#define LINKEDLIST_LINKEDLIST_H


#include "Node.h"
#include <vector>

template<class T>
class LinkedList {
private:
    Node<T> *head;


public:
    LinkedList();
    bool isEmpty();
    void addNodeFirst(T info);
    void addNodeLast(T info);
    std::vector<T> getLinkedList();
    virtual ~LinkedList();
};


#endif //LINKEDLIST_LINKEDLIST_H