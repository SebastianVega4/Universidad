//
// Created by mint on 17/11/23.
//

#include "ServicePatient.h"
#include "PatientContributor.h"
#include "PatientSubsidized.h"

ServicePatient::ServicePatient() {}
int patients;
Patient *ServicePatient::findById(long id) {
    for(Patient* patient: patients) {
        if(patient->getId() == id) return patient;
    }
    return nullptr;
}

bool ServicePatient::addPatient(long id, std::string name, std::string city, short stratum, EGender gender) {
    Patient* newPatient = new Patient(id, name, city, stratum);
    patients.push_back(newPatient);
    return true;
}

bool ServicePatient::addPatient(long id, std::string name, std::string city, short stratum, char category) {
    if (category < 'A' || category > 'D') {
        return false;
    }

    PatientContributor* newPatient = new PatientContributor(id, name, city, stratum, category);

    patients.push_back(newPatient);
    return true;
}

bool ServicePatient::addPatient(long id, std::string name, std::string city, short stratum, bool state) {
    PatientSubsidized* newPatient = new PatientSubsidized(id, name, city, stratum, state);
    patients.push_back(newPatient);
    return true;
}

std::vector<Patient *> ServicePatient::getPatients() {
    return std::vector<Patient *>();
}

std::vector<Patient *> ServicePatient::findByName(std::string name) {
    std::vector<Patient*> foundPatients;
    for (auto& patient : patients) {
        if (patient->getName() == name) {
            foundPatients.push_back(patient);
        }
    }
    return foundPatients;
}