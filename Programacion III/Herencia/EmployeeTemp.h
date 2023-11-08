//
// Created by Jairo Riaño on 30/10/23.
//

#ifndef PRJHERENCIA_EMPLOYEETEMP_H
#define PRJHERENCIA_EMPLOYEETEMP_H


#include <ostream>
#include "Employee.h"

class EmployeeTemp : public Employee {
public:
    EmployeeTemp();

    EmployeeTemp(const std::string &id, const std::string &name, double salary, const std::string &dateBegin,
                 ETypeGender gender, const std::string &dateEnd);

    const std::string &getDateEnd() const;

    void setDateEnd(const std::string &dateEnd);

    double calcSalary() override;

    friend std::ostream &operator<<(std::ostream &os, const EmployeeTemp &temp);

    ~EmployeeTemp() override;

private:
    std::string dateEnd;
};


#endif //PRJHERENCIA_EMPLOYEETEMP_H
