//
// Created by Jairo Riaño on 10/11/23.
//

#ifndef PRJDATASTRUCTURED_NODE_H
#define PRJDATASTRUCTURED_NODE_H

#include <cstdlib>

template <class T> class LinkedList;

template<class T>
class Node {
    friend class LinkedList<T>;

public:
    Node() {
        Node::next = NULL;
    }

    explicit Node(T info) : info(info) {
        Node::next = NULL;
    }

    virtual ~Node() {

    }

private:
    T info;
    Node<T> *next;
};





#endif //PRJDATASTRUCTURED_NODE_H
