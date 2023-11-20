//
// Created by mint on 17/11/23.
//


#include "PatientContributor.h"

PatientContributor::PatientContributor(long id, std::string name, std::string city, short int stratum, char category)
        : Patient(id, name, city, stratum), category(category) {}

void PatientContributor::setCategory(char category) {
    this->category = category;
}

char PatientContributor::getCategory() {
    return category;
}
