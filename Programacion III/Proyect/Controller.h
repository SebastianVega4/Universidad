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

    void addPlayerFirst(int number, const string& name, const string& position) {
        SquadVoley->addNodeFirst(VolleyballPlayer(number, name, position, 0));
    }

    void addPlayerLast(int number, const string& name, const string& position) {
        SquadVoley->addNodeLast(VolleyballPlayer(number, name, position, 0));
    }

    void addPlayerBeforeto(int fintPlayer, int number, const string& name, const string& position) {
        SquadVoley->addNodeBeforeTo(SquadVoley->findNode(fintPlayer), VolleyballPlayer(number, name, position, 0));
    }

    void addPlayerAfterTo(int fintPlayer, int number, const string& name, const string& position) {
        SquadVoley->addNodeAfterTo(SquadVoley->findNode(fintPlayer), VolleyballPlayer(number, name, position, 0));
    }

    string getListPlayers(bool order) {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(order);
        string playerList;
        for (VolleyballPlayer player : players) {
            playerList += player.toString() + "\n";
        }
        return playerList;
    }

    void addPlayerSorted(int number, const string& name, const string& position) {
        SquadVoley->addNodeSorted(VolleyballPlayer(number, name, position, 0));
    }

    string findPlayerByNumber(int number) {
        VolleyballPlayer player = SquadVoley->findInfo(number);
        if (player.getNumberPlayer() != -1) {
            return "Jugador encontrado: " + player.toString();
        } else {
            return "Jugador no encontrado";
        }
    }

    string deletePlayer(int deletePlayer) {
        return SquadVoley->deleteNode(SquadVoley->findNode(deletePlayer));
    }

    int getNumberAllPlayer() {
        return SquadVoley->getSize();
    }

    string showFirstPlayer() {
        return "Primer jugador: " + SquadVoley->getFirst().toString();
    }

    string showLastPlayer() {
        return "Último jugador: " + SquadVoley->getLast().toString();
    }

    string showPlayers() {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(true);
        string playerList;
        for (VolleyballPlayer player: players) {
            playerList += player.toString() + "\n";
        }
        return playerList;
    }

    ~Controller() {
        delete SquadVoley;
    }

private:
    LinkedDouble<VolleyballPlayer> *SquadVoley;
};

#endif //LINKEDDOUBLE_CONTROLLER_H