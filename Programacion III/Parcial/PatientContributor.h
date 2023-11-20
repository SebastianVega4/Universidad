//
// Created by mint on 17/11/23.
//

#ifndef PATIENTCONTRIBUTOR_H
#define PATIENTCONTRIBUTOR_H

#include "Patient.h"

class PatientContributor : public Patient {
private:
    char category;
public:
    PatientContributor(long id, std::string name, std::string city, short int stratum, char category);

    void setCategory(char category);

    char getCategory();
};

#endif /* PATIENTCONTRIBUTOR_H */
