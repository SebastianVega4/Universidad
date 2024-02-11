#ifndef LINKEDDOUBLE_VOLLEYBALLPLAYER_H
#define LINKEDDOUBLE_VOLLEYBALLPLAYER_H

#include <string>
#include <ostream>

using namespace std;

class VolleyballPlayer {
public:
    VolleyballPlayer(int numberPlayer, const string &name, const string &posicion, int yearsInGame);

    const int getNumberPlayer() const;

    string toString();

    virtual ~VolleyballPlayer();
private:
    string name;
    int numberPlayer;
    string posicion;
    int yearsInGame;
};
#endif //LINKEDDOUBLE_VOLLEYBALLPLAYER_H