//
// Created by Jairo Riaño on 30/10/23.
//

#ifndef PRJHERENCIA_EMPLOYEE_H
#define PRJHERENCIA_EMPLOYEE_H

#include <string>
#include <ostream>
#include "ETypeGender.h"


class Employee {
public:
    Employee();

    Employee(const std::string &id, const std::string &name, double salary, const std::string &dateBegin,
             ETypeGender gender);

    const std::string &getId() const;

    void setId(const std::string &id);

    const std::string &getName() const;

    void setName(const std::string &name);

    double getSalary() const;

    void setSalary(double salary);

    const std::string &getDateBegin() const;

    void setDateBegin(const std::string &dateBegin);

    ETypeGender getGender() const;

    void setGender(ETypeGender gender);

    virtual double calcSalary() = 0;

    friend std::ostream &operator<<(std::ostream &os, const Employee &employee);

    virtual ~Employee();

protected:
    std::string id;
    std::string name;
    double salary;
    std::string dateBegin;
    ETypeGender gender;
};


#endif //PRJHERENCIA_EMPLOYEE_H
