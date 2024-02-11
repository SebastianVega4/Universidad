//
// Created by Jairo Riaño on 15/11/23.
//

#ifndef PRJDATASTRUCTURED_LINKEDLIST_H
#define PRJDATASTRUCTURED_LINKEDLIST_H

#include <vector>
#include <string>

#include "Node.h"


template <class T>
class LinkedList {
public:
    LinkedList();

    bool isEmpty();

    void addNodeFirst(T info);

    std::vector<T> getLinkedList();

    Node<T> *findNode(std::string);

    void addNodeLast( T info );

    void addNodeBeforeTo( Node<T>* node, T info );

    void addNodeAfterTo( Node<T>* node, T info );

    virtual ~LinkedList();

private:
    Node<T> *head;
};



#endif //PRJDATASTRUCTURED_LINKEDLIST_H
