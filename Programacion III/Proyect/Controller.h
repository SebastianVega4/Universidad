//
// Created by A372144 on 2/12/2023.
//

#ifndef LINKEDDOUBLE_CONTROLLER_H
#define LINKEDDOUBLE_CONTROLLER_H

#include "LinkedDouble.cpp"
#include "VolleyballPlayer.h"
#include <iostream>

using namespace std;

class Controller {
public:
    Controller() {
        SquadVoley = new LinkedDouble<VolleyballPlayer>();
    }

    void addPlayerFirst() {
        int number;
        string name, position;
        cout << "Ingrese el número del jugador: ";
        cin >> number;
        cout << "Ingrese el nombre del jugador: ";
        cin >> name;
        cout << "Ingrese la posición del jugador: ";
        cin >> position;
        SquadVoley->addNodeFirst(VolleyballPlayer(number, name, position, 0));
    }

    void addPlayerLast() {
        int number;
        string name, position;
        cout << "Ingrese el número del jugador: ";
        cin >> number;
        cout << "Ingrese el nombre del jugador: ";
        cin >> name;
        cout << "Ingrese la posición del jugador: ";
        cin >> position;
        SquadVoley->addNodeLast(VolleyballPlayer(number, name, position, 0));
    }

    void addPlayerBeforeto() {

    }

    void addPlayerAfterTo() {

    }

    void getListPlayers() {

    }

    void addPlayerSorted() {

    }

    void findPlayerByNumber() {
        int number;
        cout << "Ingrese el número del jugador a buscar: ";
        cin >> number;
        cout << "Jugador encontrado: " << SquadVoley->findInfo(number) << endl;
    }

    void delatePlayer() {

    }

    void getNumberAllPlayer() {

    }

    void showFirstPlayer() {
        cout << "Primer jugador: " << SquadVoley->getFirst() << endl;
    }

    void showLastPlayer() {
        cout << "Último jugador: " << SquadVoley->getLast() << endl;
    }

    ~Controller() {
        delete SquadVoley;
    }

    void showPlayers() {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(true);
        for (const auto &player: players) {
            cout << player << endl;
        }
    }

private:
    LinkedDouble<VolleyballPlayer> *SquadVoley;
};

#endif //LINKEDDOUBLE_CONTROLLER_H