#include "LinkedDouble.cpp"
#include "VolleyballPlayer.h"
#include <iostream>

using namespace std;

class Controller {
public:
    Controller() {
        SquadVoley = new LinkedDouble<VolleyballPlayer>();
        /*SquadVoley->addNodeFirst(VolleyballPlayer(4, "Sebastian", "Libero", 13));
        SquadVoley->addNodeLast(VolleyballPlayer(7, "Sahra", "Punta", 3));
        SquadVoley->addNodeFirst(VolleyballPlayer(2, "Camilo", "Cuatro", 2));
        SquadVoley->addNodeLast(VolleyballPlayer(1, "Pedro", "Levantador", 9));

        SquadVoley->addNodeBeforeTo(SquadVoley->findNode(4), VolleyballPlayer(13, "Andres", "Central", 8));
        SquadVoley->addNodeAfterTo(SquadVoley->findNode(13), VolleyballPlayer(5, "Mona", "Punta", 9));
        SquadVoley->addNodeSorted(VolleyballPlayer(6, "Llanero", "Cuatro", 15));*/
    }

    void addPlayerFirst(int number, const string &name, const string &position, int yearsInGame) {
        SquadVoley->addNodeFirst(VolleyballPlayer(number, name, position, yearsInGame));
    }

    void addPlayerLast(int number, const string &name, const string &position, int yearsInGame) {
        SquadVoley->addNodeLast(VolleyballPlayer(number, name, position, yearsInGame));
    }

    void addPlayerBeforeTo(int fintPlayer, int number, const string &name, const string &position, int yearsInGame) {
        SquadVoley->addNodeBeforeTo(SquadVoley->findNode(fintPlayer),
                                    VolleyballPlayer(number, name, position, yearsInGame));
    }

    void addPlayerAfterTo(int fintPlayer, int number, const string &name, const string &position, int yearsInGame) {
        SquadVoley->addNodeAfterTo(SquadVoley->findNode(fintPlayer),
                                   VolleyballPlayer(number, name, position, yearsInGame));
    }

    string getListPlayers(bool order) {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(order);
        string playerList;
        for (VolleyballPlayer player: players) playerList += player.toString() + "\n";
        return playerList;
    }

    void addPlayerSorted(int number, const string &name, const string &position, int yearsInGame) {
        SquadVoley->addNodeSorted(VolleyballPlayer(number, name, position, yearsInGame));
    }

    string findPlayerByNumber(int number) {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(true);
        for (VolleyballPlayer player: players) {
            if (player.getNumberPlayer() == number) return player.toString();
        }
        return " no encontrado";
    }

    string deletePlayer(int deletePlayer) {
        return SquadVoley->deleteNode(SquadVoley->findNode(deletePlayer));
    }

    int getNumberAllPlayer() {
        return SquadVoley->getSize();
    }

    string showFirstPlayer() {
        return SquadVoley->getFirst().toString();
    }

    string showLastPlayer() {
        return SquadVoley->getLast().toString();
    }

    string showPlayers() {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(true);
        string playerList;
        for (VolleyballPlayer player: players) playerList += player.toString() + "\n";
        return playerList;
    }

    bool playerExist(int number) {
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(true);
        for (const VolleyballPlayer &player: players) {
            if (player.getNumberPlayer() == number) return true;
        }
        return false;
    }

    bool playerEmply() {
        return SquadVoley->isEmpty();
    }

    void sortPlayersByNumber() {
        int n = SquadVoley->getSize();
        vector<VolleyballPlayer> players = SquadVoley->getLinkedList(true);
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (players[j].getNumberPlayer() < players[minIndex].getNumberPlayer()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(players[i], players[minIndex]);
            }
        }

        SquadVoley = new LinkedDouble<VolleyballPlayer>();
        for (const auto &player: players) {
            SquadVoley->addNodeLast(player);
        }
    }

    ~Controller() {
        delete SquadVoley;
    }
private:
    LinkedDouble<VolleyballPlayer> *SquadVoley{};
};