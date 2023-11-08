#include <iostream>

#include "HanlingEmployee.h"

using namespace std;

int main() {

   HanlingEmployee *hanlingEmployee = new HanlingEmployee();

   cout<<hanlingEmployee->addEmployee("123","Juan Jose",1200000,"10/10/2020",MALE,"12/12/2022");
   cout<<hanlingEmployee->addEmployee("6543","Josefa",4500000,"10/10/2020",FEMALE,"12/12/2022");
   cout<<hanlingEmployee->addEmployee("123","Maria Camila",2800000,"10/10/2020",FEMALE,"12/12/2022");

   cout<<"Hay "<<hanlingEmployee->getEmployees().size()<<" Empleados"<<endl;

   for( Employee *employee : hanlingEmployee->getEmployees() ){
       cout<<*employee<<endl;
   }

   delete( hanlingEmployee );

    return 0;
}
