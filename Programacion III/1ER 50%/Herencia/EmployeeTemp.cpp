//
// Created by Jairo Riaño on 30/10/23.
//

#include "EmployeeTemp.h"

EmployeeTemp::EmployeeTemp() {}

EmployeeTemp::EmployeeTemp(const std::string &id, const std::string &name, double salary, const std::string &dateBegin,
                           ETypeGender gender, const std::string &dateEnd) : Employee(id, name, salary, dateBegin,
                                                                                      gender), dateEnd(dateEnd) {}

const std::string &EmployeeTemp::getDateEnd() const {
    return dateEnd;
}

void EmployeeTemp::setDateEnd(const std::string &dateEnd) {
    EmployeeTemp::dateEnd = dateEnd;
}

double EmployeeTemp::calcSalary() {
    
    return getSalary() - (getSalary() * 0.1);
}

EmployeeTemp::~EmployeeTemp() {

}

std::ostream &operator<<(std::ostream &os, const EmployeeTemp &temp) {
    os << static_cast<const Employee &>(temp) << " dateEnd: " << temp.dateEnd;
    return os;
}
