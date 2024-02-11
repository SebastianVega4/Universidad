//
// Created by mint on 17/11/23.
//

// ServicePatient.h
#ifndef SERVICEPATIENT_H
#define SERVICEPATIENT_H

#include "Patient.h"
#include "EGender.h"
#include <vector>

class ServicePatient {
public:
    ServicePatient();

    Patient *findById(long id);

    static bool addPatient(long id, std::string name, std::string city, short int stratum, EGender gender);

    bool addPatient(long id, std::string name, std::string city, short int stratum, char category);

    bool addPatient(long id, std::string name, std::string city, short int stratum, bool state);

    std::vector<Patient *> getPatients();

    std::vector<Patient *> findByName(std::string name);
};

#endif /* SERVICEPATIENT_H */
