
#ifndef LINKEDDOUBLE_VOLLEYBALLPLAYER_H
#define LINKEDDOUBLE_VOLLEYBALLPLAYER_H

#include <string>
#include <ostream>

using namespace std;

class VolleyballPlayer {
public:
    VolleyballPlayer();

    VolleyballPlayer(int numberPlayer, const string &name, const string &posicion, int yearsInGame);

    const string &getName() const;

    void setName(const string &name);

    const int getNumberPlayer() const;

    void setNumberPlayer(int numberPlayer);

    const string &getPosicion() const;

    void setPosicion(const string &posicion);

    int getYearsInGame() const;

    void setYearsInGame(int yearsInGame);

    friend ostream &operator<<(ostream &os, const VolleyballPlayer &player);

    virtual ~VolleyballPlayer();

private:
    string name;
    int numberPlayer;
    string posicion;
    int yearsInGame;

};


#endif //LINKEDDOUBLE_VOLLEYBALLPLAYER_H
