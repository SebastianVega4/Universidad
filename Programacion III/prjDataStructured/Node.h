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

    T getInfo() const {
        return info;
    }

    void setInfo(T info) {
        Node::info = info;
    }

    Node<T> *getNext() const {
        return next;
    }

    void setNext(Node<T> *next) {
        Node::next = next;
    }

    virtual ~Node() {
        delete(next);
    }

private:
    T info;
    Node<T> *next;
};





#endif //PRJDATASTRUCTURED_NODE_H
