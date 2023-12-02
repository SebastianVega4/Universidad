#include <iostream>
#include "Controller.h"

using namespace std;
int main() {
    Controller controller;
    int opcion = 0;
    while (opcion != 12) {
        cout << "***********************************************:" << endl;
        cout << "                       Menu:" << endl;
        cout << "1. Agregar jugador al inicio" << endl;
        cout << "2. Agregar jugador al final" << endl;
        cout << "3. Agregar jugador Antes de:" << endl;
        cout << "4. Agregar jugador Despues de:" << endl;
        cout << "5. Mostrar jugadores desc o asc" << endl;
        cout << "6. Adañir Jugador Ordenadamente (ordena la planilla)" << endl;
        cout << "7. Encontrar informacion de jugador por numero" << endl;
        cout << "8. Eliminar jugador" << endl;
        cout << "9.Mostrar numero total de jugadores en planilla" << endl;
        cout << "10.Mostrar el Primer jugador en planilla" << endl;
        cout << "11.Mostrar el ultimo jugador en planilla" << endl;
        cout << "12.Salir" << endl;
        cout << "                  Ingrese una opción: ";
        cout << "***********************************************:" << endl;
        cin >> opcion;

        switch (opcion) {
            case 1://add al inicio
                controller.addPlayerFirst();
                break;
            case 2://add al final
                controller.addPlayerLast();
                break;
            case 3://add Antes de
                controller.addPlayerBeforeto();
                break;
            case 4:// add Despues de
                controller.addPlayerAfterTo();
                break;
            case 5://Optener nodo de forma asc o desc (boot)
                controller.getListPlayers();
                break;
            case 6://Ordenar Lista
                controller.addPlayerSorted();
                break;
            case 7://Encontrar por Info
                controller.findPlayerByNumber();
                break;
            case 8://Eliminar nodo
                controller.delatePlayer();
                break;
            case 9://Obtener el numero total de jugadores
                controller.getNumberAllPlayer();
                break;
            case 10://Obtener el Primero del nodo
                controller.showFirstPlayer();
                break;
            case 11://Obtener el Ultimo de la lista
                controller.showLastPlayer();
                break;
            case 12://Salir
                cout << "Saliendo del programa..." << endl;
                break;
            default:
                cout << "Opción no válida" << endl;
                break;
        }
    }
    return 0;
}


/* auto* SquadVoley = new LinkedDouble<VolleyballPlayer>();
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

 cout<<endl<<"Encontrando number 4"<<endl<<SquadVoley->findInfo(4)<< endl;*/