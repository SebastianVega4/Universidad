//
// Created by mint on 17/11/23.
//


#include "PatientPrepaid.h"
#include "cmake-build-debug/EPlain.h"

PatientPrepaid::PatientPrepaid(long id, std::string name, std::string city, short int stratum, EPlain plain) : Patient(
        id, name, city, stratum), plain(plain) {}

void PatientPrepaid::setPlain(EPlain plain) {
    this->plain = plain;
}


EPlain PatientPrepaid::getPlain() {
    return plain;
}
