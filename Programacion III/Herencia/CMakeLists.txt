cmake_minimum_required(VERSION 3.24)
project(prjHerencia)

set(CMAKE_CXX_STANDARD 17)

add_executable(prjHerencia main.cpp Employee.cpp Employee.h ETypeGender.h EmployeeTemp.cpp EmployeeTemp.h HanlingEmployee.cpp HanlingEmployee.h)
