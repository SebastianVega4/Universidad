//
// Created by mint on 17/11/23.
//


#ifndef PATIENTPREPAID_H
#define PATIENTPREPAID_H

#include "Patient.h"
#include "EPlain.h"

class PatientPrepaid : public Patient {
private:
    EPlain plain;
public:
    PatientPrepaid(long id, std::string name, std::string city, short int stratum, EPlain plain);
    void setPlain(EPlain plain);
    EPlain getPlain();
};

#endif /* PATIENTPREPAID_H */
