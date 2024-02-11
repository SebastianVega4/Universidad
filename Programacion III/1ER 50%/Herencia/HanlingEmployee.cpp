//
// Created by Jairo Riaño on 8/11/23.
//

#include "HanlingEmployee.h"
#include "EmployeeTemp.h"

HanlingEmployee::HanlingEmployee() {}

Employee *HanlingEmployee::findById(std::string id) {

    return NULL;

}

bool HanlingEmployee::addEmployee(std::string id, std::string name, double salary, std::string dateBegin, ETypeGender gender, std::string dateEnd) {

    if(findById( id) == NULL ){

        employees.push_back( new EmployeeTemp( id,name,salary,dateBegin,gender,dateEnd));

        return true;
    }

    return false;
}

bool HanlingEmployee::addEmployee(std::string id, std::string name, double salary, std::string dateBegin, ETypeGender gender, int hours) {
    if(findById( id) == NULL ){

        //employees.push_back( new EmployeeFix( id,name,salary,dateBegin,gender,hours));

        return true;
    }

    return false;
}

std::vector<Employee *> HanlingEmployee::getEmployees() {
    return employees;
}
