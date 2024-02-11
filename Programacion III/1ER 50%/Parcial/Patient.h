// Patient.h
#ifndef PATIENT_H
#define PATIENT_H

#include <string>

class Patient {
private:
    long id;
    std::string name;
    std::string city;
    short int stratum;
public:
    Patient(long id, std::string name, std::string city, short int stratum);

    void setId(long id);

    void setName(std::string name);

    void setCity(std::string city);

    void setStratum(short int stratum);

    std::string getName();

    std::string getCity();

    short int getStratum();

    double calculateBond();

    long getId();
};

#endif /* PATIENT_H */
