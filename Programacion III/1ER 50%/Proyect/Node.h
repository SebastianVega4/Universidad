#include <cstdlib>

template<class T>
class LinkedDouble;

template<class T>
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

    virtual ~Node() = default;
private:
    T info;
    Node<T> *next;
    Node<T> *previous;
};