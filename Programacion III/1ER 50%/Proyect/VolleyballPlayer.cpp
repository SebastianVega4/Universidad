#include "VolleyballPlayer.h"

VolleyballPlayer::VolleyballPlayer(int numberPlayer, const string &name, const string &posicion, int yearsInGame)
        : name(name), numberPlayer(numberPlayer), posicion(posicion), yearsInGame(yearsInGame) {}

const int VolleyballPlayer::getNumberPlayer() const {
    return numberPlayer;
}

string VolleyballPlayer::toString() {
    return " numberPlayer: " + to_string(numberPlayer) + ",  name: " + name + ",   posicion: " + posicion +
           " yearsInGame: " +
           to_string(yearsInGame);
}

VolleyballPlayer::~VolleyballPlayer() = default;