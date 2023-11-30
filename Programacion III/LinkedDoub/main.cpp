#include <iostream>

#include "LinkedDouble.cpp"
#include "VolleyballPlayer.h"

using namespace std;

int main() {
    LinkedDouble<VolleyballPlayer>* SquadVoley = new LinkedDouble<VolleyballPlayer>();
    SquadVoley->addNodeFirst( VolleyballPlayer(4, "Sebastian", "Libero", 13));
    SquadVoley->addNodeLast( VolleyballPlayer(7,"Sahra","Punta",3));
    SquadVoley->addNodeFirst( VolleyballPlayer(2,"Camilo","Cuatro",2));
    SquadVoley->addNodeLast( VolleyballPlayer(1,"Pedro","Levantador",9));

    SquadVoley->addNodeBeforeTo(SquadVoley->findNode(4),VolleyballPlayer(13, "Andres", "Central", 8));
    SquadVoley->addNodeAfterTo(SquadVoley->findNode(13),VolleyballPlayer(5, "Mona", "Punta", 9));
    SquadVoley->addNodeSorted(VolleyballPlayer(6, "Llanero", "Cuatro", 15));

    for (VolleyballPlayer SquadVoley : SquadVoley->getLinkedList(true) ){
        cout<<SquadVoley<<endl;
    }

    cout<<endl<<"primero"<<endl<<SquadVoley->getFirst()<< endl;
    cout<<"Ultimo"<<endl<<SquadVoley->getLast()<< endl;

    cout<<endl<<"Encontrando number 4"<<endl<<SquadVoley->findInfo(4)<< endl;

    return 0;
}