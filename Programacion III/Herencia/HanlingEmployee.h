//
// Created by Jairo Riaño on 8/11/23.
//

#ifndef PRJHERENCIA_HANLINGEMPLOYEE_H
#define PRJHERENCIA_HANLINGEMPLOYEE_H

#include <vector>
#include "Employee.h"

class HanlingEmployee {
public:
    HanlingEmployee();
    Employee* findById(std::string);

    bool addEmployee(std::string,std::string,double,std::string,ETypeGender, std::string);

    bool addEmployee(std::string,std::string,double,std::string,ETypeGender, int);

    std::vector<Employee*> getEmployees();

private:
    std::vector<Employee*> employees;

};


#endif //PRJHERENCIA_HANLINGEMPLOYEE_H
