#include <iostream>
#include "Controller.h"

using namespace std;
int main() {
    Controller controller;

    int opcion = 0;
    while (opcion != 12) {
        cout << endl << "***********************************************:" << endl;
        cout << "                       Menu:" << endl;
        cout << "1. Agregar jugador al inicio" << endl;
        cout << "2. Agregar jugador al final" << endl;
        cout << "3. Agregar jugador Antes de:" << endl;
        cout << "4. Agregar jugador Despues de:" << endl;
        cout << "5. Mostrar jugadores desc o asc" << endl;
        cout << "6. Anadir Jugador Ordenadamente (ordena la planilla)" << endl;
        cout << "7. Encontrar informacion de jugador por numero" << endl;
        cout << "8. Eliminar jugador" << endl;
        cout << "9.Mostrar numero total de jugadores en planilla" << endl;
        cout << "10.Mostrar el Primer jugador en planilla" << endl;
        cout << "11.Mostrar el ultimo jugador en planilla" << endl;
        cout << "                      1"
                "12.Salir" << endl;
        cout << "                  Ingrese una opcion: "<<endl;
        cout << "***********************************************:" << endl;
        cin >> opcion;

        int number = 0,findPlayer, aux;
        string name, position;
        switch (opcion) {
            case 1://add al inicio
                cout << "Ingrese el numero del nuevo jugador:"<< endl;
                cin >> number;
                cout << "Ingrese el nombre del jugador con #"+ to_string(number)+ " :"<< endl;
                cin >> name;
                cout << "Ingrese En que posicion juega "+ name +" :"<< endl;
                cin >> position;
                controller.addPlayerFirst(number,name,position);
                break;
            case 2://add al final
                cout << "Ingrese el numero del nuevo jugador:"<< endl;
                cin >> number;
                cout << "Ingrese el nombre del jugador con #"+ to_string(number)+ " :"<< endl;
                cin >> name;
                cout << "Ingrese En que posicion juega "+ name +" :"<< endl;
                cin >> position;
                controller.addPlayerLast(number,name,position);
                break;
            case 3://add Antes de
                cout << "Ingrese el número del jugador que desea ingresar ANTES de: "<< endl;
                cin >> findPlayer;
                cout << "Ingrese el numero del nuevo jugador:"<< endl;
                cin >> number;
                cout << "Ingrese el nombre del jugador con #"+ to_string(number)+ " :"<< endl;
                cin >> name;
                cout << "Ingrese En que posicion juega "+ name +" :"<< endl;
                cin >> position;
                controller.addPlayerBeforeto(findPlayer,number,name,position);
                break;
            case 4:// add Despues de
                cout << "Ingrese el número del jugador que desea ingresar DESPUES de: "<< endl;
                cin >> findPlayer;
                cout << "Ingrese el numero del nuevo jugador:"<< endl;
                cin >> number;
                cout << "Ingrese el nombre del jugador con #"+ to_string(number)+ " :"<< endl;
                cin >> name;
                cout << "Ingrese En que posicion juega "+ name +" :"<< endl;
                cin >> position;
                controller.addPlayerAfterTo(findPlayer,number,name,position);
                break;
            case 5://mostrar la lista de forma asc o desc (boot)
                cout << "+++++++++++++++++++++++++++++++++++++++++++";
                cout << "De que forma lo desea Mostrar la planilla: ";
                cout << "1 = Asendente";
                cout << "2 = Desendente";
                cout << "+++++++++++++++++++++++++++++++++++++++++++";
                cin >> aux;
                if (aux == 1 || aux==2)cout << controller.getListPlayers(aux);
                else cout<<"Ingrese una opcion valida";
                break;
            case 6://Ordenar Lista y añadir un jugador
                cout << "Ingrese el numero del nuevo jugador:"<< endl;
                cin >> number;
                cout << "Ingrese el nombre del jugador con #"+ to_string(number)+ " :"<< endl;
                cin >> name;
                cout << "Ingrese En que posicion juega "+ name +" :"<< endl;
                cin >> position;
                controller.addPlayerSorted(number,name,position);
                break;
            case 7://Encontrar por Info
                cout << "Ingrese el número del jugador a buscar: "<< endl;
                cin >> number;
                cout<<controller.findPlayerByNumber(number)<< endl;
                break;
            case 8://Eliminar nodo
                cout << "Ingrese el número del jugador que desea Eliminar: "<< endl;
                cin >> findPlayer;
                cout << controller.deletePlayer(findPlayer)<< endl;
                break;
            case 9://Obtener el numero total de jugadores
                cout<<"El numero total de juegadores es: "<< controller.getNumberAllPlayer()<< endl;
                break;
            case 10://Obtener el Primero del nodo
                cout<<"El  primer jugador es: "<<endl<<controller.showFirstPlayer()<< endl;
                break;
            case 11://Obtener el Ultimo de la lista
                cout<<"El ultimo jugador es: "<<endl<<controller.showLastPlayer()<< endl;
                break;
            case 12://Salir
                cout << "Saliendo del programa..." << endl;
                break;
            default:
                cout << "Opción no válida" << endl;
                break;
        }
        cout<<endl<<controller.showPlayers()<<endl;
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