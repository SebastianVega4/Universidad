//
// Created by Jairo Riaño on 30/10/23.
//

#include "Employee.h"

Employee::Employee() {}

Employee::Employee(const std::string &id, const std::string &name, double salary, const std::string &dateBegin,
                   ETypeGender gender) : id(id), name(name), salary(salary), dateBegin(dateBegin), gender(gender) {}

const std::string &Employee::getId() const {
    return id;
}

void Employee::setId(const std::string &id) {
    Employee::id = id;
}

const std::string &Employee::getName() const {
    return name;
}

void Employee::setName(const std::string &name) {
    Employee::name = name;
}

double Employee::getSalary() const {
    return salary;
}

void Employee::setSalary(double salary) {
    Employee::salary = salary;
}

const std::string &Employee::getDateBegin() const {
    return dateBegin;
}

void Employee::setDateBegin(const std::string &dateBegin) {
    Employee::dateBegin = dateBegin;
}

ETypeGender Employee::getGender() const {
    return gender;
}

void Employee::setGender(ETypeGender gender) {
    Employee::gender = gender;
}

std::ostream &operator<<(std::ostream &os, const Employee &employee) {
    os << "id: " << employee.id << " name: " << employee.name << " salary: " << employee.salary << " dateBegin: "
       << employee.dateBegin << " gender: " << employee.gender;
    return os;
}

Employee::~Employee() {

}

