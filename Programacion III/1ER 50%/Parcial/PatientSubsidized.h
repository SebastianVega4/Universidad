// PatientSubsidized.h
#ifndef PATIENTSUBSIDIZED_H
#define PATIENTSUBSIDIZED_H

#include "Patient.h"

class PatientSubsidized : public Patient {
private:
    bool state;
public:
    PatientSubsidized(long id, std::string name, std::string city, short int stratum, bool state);

    void setState(bool state);

    bool isState();
};

#endif /* PATIENTSUBSIDIZED_H */
