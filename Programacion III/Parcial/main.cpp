#include <iostream>
using namespace std;

#include "ServicePatient.h"
int main() {
    ServicePatient service;

    service.addPatient(new PatientContributor());
    service.addPatient(new PatientPrepaid());
    service.addPatient(new PatientSubsidized());

    Patient* patient = service.findById(1);
    double bond = patient->calculateBond();

    for(Patient* patient: service.getPatients()) {
        std::cout << patient->getName() << ": " << patient->calculateBond();
    }
    return 0;
}