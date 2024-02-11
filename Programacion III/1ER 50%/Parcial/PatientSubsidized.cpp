//
// Created by mint on 17/11/23.
//

#include "PatientSubsidized.h"

PatientSubsidized::PatientSubsidized(long id, std::string name, std::string city, short int stratum, bool state)
        : Patient(id, name, city, stratum), state(state) {}

void PatientSubsidized::setState(bool state) {
    this->state = state;
}


bool PatientSubsidized::isState() {
    return state;
}
