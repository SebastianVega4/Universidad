#include <iostream>
#include "LinkedList.cpp"
using namespace std;


int main() {
    LinkedList<char> *linkedList = new LinkedList<char>();

    linkedList -> addNodeFirst('S');
    linkedList -> addNodeFirst('e');
    linkedList -> addNodeFirst('B');
    linkedList -> addNodeFirst('A');
    linkedList -> addNodeFirst('S');

    for(char c : linkedList->getLinkedList()){
        cout<<c;
    }

    delete(linkedList);
    return 0;
}

