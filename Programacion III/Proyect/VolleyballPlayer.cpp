
#include "VolleyballPlayer.h"

VolleyballPlayer::VolleyballPlayer(int numberPlayer, const string &name, const string &posicion, int yearsInGame)
        : name(name), numberPlayer(numberPlayer), posicion(posicion), yearsInGame(yearsInGame) {}

const string &VolleyballPlayer::getName() const {
    return name;
}

void VolleyballPlayer::setName(const string &name) {
    VolleyballPlayer::name = name;
}

const int VolleyballPlayer::getNumberPlayer() const {
    return numberPlayer;
}

void VolleyballPlayer::setNumberPlayer(int numberPlayer) {
    VolleyballPlayer::numberPlayer = numberPlayer;
}

const string &VolleyballPlayer::getPosicion() const {
    return posicion;
}

void VolleyballPlayer::setPosicion(const string &posicion) {
    VolleyballPlayer::posicion = posicion;
}

int VolleyballPlayer::getYearsInGame() const {
    return yearsInGame;
}

void VolleyballPlayer::setYearsInGame(int yearsInGame) {
    VolleyballPlayer::yearsInGame = yearsInGame;
}

string VolleyballPlayer::toString() {
    return "name: " + name + " numberPlayer: " + to_string(numberPlayer) + " posicion: " + posicion + " yearsInGame: " + to_string(yearsInGame);
}


ostream &operator<<(ostream &os, const VolleyballPlayer &player) {
    os << "name: " << player.name << " numberPlayer: " << player.numberPlayer << " posicion: " << player.posicion
       << " yearsInGame: " << player.yearsInGame;
    return os;
}


VolleyballPlayer::~VolleyballPlayer() = default;
