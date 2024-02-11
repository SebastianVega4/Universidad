// Patient.cpp
#include "Patient.h"

Patient::Patient(long id, std::string name, std::string city, short int stratum) : id(id), name(name), city(city),
                                                                                   stratum(stratum) {}

void Patient::setId(long id) {
    this->id = id;
}

void Patient::setName(std::string name) {
    this->name = name;
}


void Patient::setCity(std::string city) {
    this->city = city;
}

void Patient::setStratum(short int stratum) {
    this->stratum = stratum;
}

std::string Patient::getName() {
    return name;
}

std::string Patient::getCity() {
    return city;
}

short int Patient::getStratum() {
    return stratum;
}

double Patient::calculateBond() {

    return 0.0;
}

