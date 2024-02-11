#include <vector>

#include "Node.h"
#include "VolleyballPlayer.h"

using namespace std;

template<class T>
class LinkedDouble {
public:
    LinkedDouble();

    bool isEmpty();

    void addNodeFirst(T);

    void addNodeLast(T);

    void addNodeBeforeTo(Node<T> *node, T info);

    void addNodeAfterTo(Node<T> *node, T info);

    Node<T> *findNode(int namePLayer);

    vector<T> getLinkedList(bool forward);

    void addNodeSorted(T No);

    string deleteNode(Node<T> *node);

    int getSize();

    VolleyballPlayer getFirst();

    VolleyballPlayer getLast();

    virtual ~LinkedDouble();
private:
    Node<T> *head;
    Node<T> *last;
};