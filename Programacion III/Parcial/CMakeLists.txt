cmake_minimum_required(VERSION 3.24)
project(Parcial)

set(CMAKE_CXX_STANDARD 17)

add_executable(Parcial main.cpp Patient.cpp EGender.h PatientSubsidized.h PatientContributor.h PatientPrepaid.cpp ServicePatient.h ServicePatient.cpp Patient.h PatientSubsidized.cpp PatientContributor.cpp EGender.cpp)
