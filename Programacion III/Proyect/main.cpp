#include <iostream>
#include <exception>
#include <limits>
#include "Controller.h"

using namespace std;

int obtenerEntero() {
    int input;
    while (true) {
        if (!(cin >> input)) {
            cin.clear(); // Limpiar el estado de error
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Entrada no valida. Por favor ingrese un numero." << endl;
            break;
        } else {
            return input;
        }
    }
    return 0;
}

string obtenerStrig() {
    string input;
    while (true) {
        if (!(cin >> input)) {
            cin.clear(); // Limpiar el estado de error
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Entrada no valida. Por favor ingrese un String." << endl;
            break;
        } else {
            return input;
        }
    }
    return "";
}
int main() {
    Controller controller;
    int opcion = 1;
    while (opcion != 0 && !cin.fail()) {
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
        cout << "9. Mostrar numero total de jugadores en planilla" << endl;
        cout << "10.Mostrar el Primer jugador en planilla" << endl;
        cout << "11.Mostrar el ultimo jugador en planilla" << endl;
        cout << "12.Ordenar Planilla de jugadores" << endl;
        cout << "                      0.Salir" << endl;
        cout << "                  Ingrese una opcion: "<<endl;
        cout << "***********************************************:" << endl;
        cin >> opcion;
        try {
            if (cin.fail()) {
                cin.clear(); // Limpiar el estado de error
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                opcion = 1;
                throw invalid_argument("Entrada no valida. Por favor ingrese un numero de opcion valida.");

            }
            int number = 0, findPlayer, aux, yearsInGame;
            string name, position;
            switch (opcion) {
            case 1://add al inicio
                cout << "Ingrese el numero del nuevo jugador:" << endl;
                    if ((number = obtenerEntero()) == 0)break;
                    if (controller.playerExist(number)) cout << " el jugador con #" + to_string(number) + " ya existe";
                    else {
                        cout << "Ingrese el nombre del jugador con #" + to_string(number) + " :" << endl;
                        if ((name = obtenerStrig()).empty())break;
                        cout << "Ingrese en que posicion juega " + name + " :" << endl;
                        if ((position = obtenerStrig()).empty())break;
                        cout << "Ingrese los years de experiencia de " + name + " :" << endl;
                        if ((yearsInGame = obtenerEntero()) == 0)break;
                        controller.addPlayerFirst(number, name, position, yearsInGame);
                        cout << endl << controller.showPlayers() << endl;
                    }
                break;
            case 2://add al final
                cout << "Ingrese el numero del nuevo jugador:" << endl;
                    if ((number = obtenerEntero()) == 0)break;
                    if (controller.playerExist(number)) cout << " el jugador con #" + to_string(number) + " ya existe";
                    else {
                        cout << "Ingrese el nombre del jugador con #" + to_string(number) + " :" << endl;
                        if ((name = obtenerStrig()).empty())break;
                        cout << "Ingrese en que posicion juega " + name + " :" << endl;
                        if ((position = obtenerStrig()).empty())break;
                        cout << "Ingrese los years de experiencia de " + name + " :" << endl;
                        if ((yearsInGame = obtenerEntero()) == 0)break;
                        controller.addPlayerLast(number, name, position, yearsInGame);
                        cout << endl << controller.showPlayers() << endl;
                    }
                break;
            case 3://add Antes de
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else {
                    cout << "Ingrese el numero del jugador que desea ingresar ANTES de: " << endl;
                    if ((findPlayer = obtenerEntero()) == 0)break;
                    cout << "Ingrese el numero del nuevo jugador:" << endl;
                    if ((number = obtenerEntero()) == 0)break;
                    if (controller.playerExist(number)) cout << " el jugador con #" + to_string(number) + " ya existe";
                    else {
                        cout << "Ingrese el nombre del jugador con #" + to_string(number) + " :" << endl;
                        if ((name = obtenerStrig()).empty())break;
                        cout << "Ingrese en que posicion juega " + name + " :" << endl;
                        if ((position = obtenerStrig()).empty())break;
                        cout << "Ingrese los years de experiencia de " + name + " :" << endl;
                        if ((yearsInGame = obtenerEntero()) == 0)break;
                        controller.addPlayerBeforeTo(findPlayer, number, name, position, yearsInGame);
                        cout << endl << controller.showPlayers() << endl;
                    }
                }
                break;
            case 4:// add Despues de
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else {
                    cout << "Ingrese el numero del jugador que desea ingresar DESPUES de: " << endl;
                    if ((findPlayer = obtenerEntero()) == 0)break;
                    cout << "Ingrese el numero del nuevo jugador:" << endl;
                    if ((number = obtenerEntero()) == 0)break;
                    if (controller.playerExist(number)) cout << " el jugador con #" + to_string(number) + " ya existe";
                    else {
                        cout << "Ingrese el nombre del jugador con #" + to_string(number) + " :" << endl;
                        if ((name = obtenerStrig()).empty())break;
                        cout << "Ingrese en que posicion juega " + name + " :" << endl;
                        if ((position = obtenerStrig()).empty())break;
                        cout << "Ingrese los years de experiencia de " + name + " :" << endl;
                        if ((yearsInGame = obtenerEntero()) == 0)break;
                        controller.addPlayerAfterTo(findPlayer, number, name, position, yearsInGame);
                        cout << endl << controller.showPlayers() << endl;
                    }
                }
                break;
            case 5://mostrar la lista de forma asc o desc (boot)
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else {
                    cout << "+++++++++++++++++++++++++++++++++++++++++++" << endl;
                    cout << "De que forma lo desea Mostrar la planilla: " << endl;
                    cout << "1 = Asendente" << endl;
                    cout << "2 = Desendente" << endl;
                    cout << "+++++++++++++++++++++++++++++++++++++++++++" << endl;
                    if ((aux = obtenerEntero()) == 0)break;
                    if (aux == 1)cout << controller.getListPlayers(true);
                    else if (aux == 2)cout << controller.getListPlayers(false);
                    else cout << "Ingrese una opcion valida";
                }
                break;
            case 6://Ordenar Lista y añadir un jugador
                cout << "Ingrese el numero del nuevo jugador:" << endl;
                    if ((number = obtenerEntero()) == 0)break;
                    if (controller.playerExist(number)) cout << " el jugador con #" + to_string(number) + " ya existe";
                    else {
                        cout << "Ingrese el nombre del jugador con #" + to_string(number) + " :" << endl;
                        if ((name = obtenerStrig()).empty())break;
                        cout << "Ingrese en que posicion juega " + name + " :" << endl;
                        if ((position = obtenerStrig()).empty())break;
                        cout << "Ingrese los years de experiencia de " + name + " :" << endl;
                        if ((yearsInGame = obtenerEntero()) == 0)break;
                        if (!controller.playerEmply()) controller.sortPlayersByNumber();
                        controller.addPlayerSorted(number, name, position, yearsInGame);
                        cout << endl << controller.showPlayers() << endl;
                    }
                break;
            case 7://Encontrar por Info
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else {
                    cout << "Ingrese el numero del jugador a buscar: " << endl;
                    if ((number = obtenerEntero()) == 0)break;
                    cout << controller.findPlayerByNumber(number) << endl;
                }
                break;
            case 8://Eliminar nodo
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else {
                    cout << "Ingrese el numero del jugador que desea Eliminar: " << endl;
                    if ((findPlayer = obtenerEntero()) == 0)break;
                    cout << controller.deletePlayer(findPlayer) << endl;
                    cout << endl << controller.showPlayers() << endl;
                }
                break;
            case 9://Obtener el numero total de jugadores
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else cout << "El numero total de juegadores es: " << controller.getNumberAllPlayer() << endl;
                break;
            case 10://Obtener el Primero del nodo
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else cout << "El  primer jugador es: " << endl << controller.showFirstPlayer() << endl;
                break;
            case 11://Obtener el Ultimo de la lista
                if (controller.playerEmply()) cout << "la lista esta vacia";
                else cout << "El ultimo jugador es: " << endl << controller.showLastPlayer() << endl;
                break;
                case 12 :
                    if (controller.playerEmply()) cout << "la lista esta vacia";
                    else {
                        controller.sortPlayersByNumber();
                        cout << endl << controller.showPlayers() << endl;
                    }
                    break;
                case 0://Salir
                cout << "Saliendo del programa..." << endl;
                break;
            default:
                cout << "Opcion no valida" << endl;
                break;
            }
        }
        catch (const invalid_argument &e) {
            cout << "Error: " << e.what() << endl;
        }
        catch (const exception &e) {
            cout << "Error: " << e.what() << endl;
        }
        catch (...) {
            cout << "Error desconocido!" << endl;
        }
    }
    return 0;
}