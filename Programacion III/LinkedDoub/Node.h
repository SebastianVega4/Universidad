//
// Created by Jairo Riaño on 20/02/21.
//

#ifndef LINKDOUBLE_NODE_H
#define LINKDOUBLE_NODE_H

#include <cstdlib>

template <class T> class LinkedDouble;

template <class T>
class Node {
    friend class LinkedDouble<T>;
public:
    Node() {
        next = NULL;
        previous = NULL;
    }

    Node(T info) : info(info) {
        next = NULL;
        previous = NULL;
    }

    virtual ~Node() {

    }

private:
    T info;
    Node<T>* next;
    Node<T>* previous;
};


#endif //LINKDOUBLE_NODE_H
