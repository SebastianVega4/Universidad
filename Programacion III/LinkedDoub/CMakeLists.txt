cmake_minimum_required(VERSION 3.26)
project(LinkedDouble)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(LinkedDouble
        LinkedDouble.cpp
        LinkedDouble.h
        main.cpp
        Node.h
        VolleyballPlayer.cpp
        VolleyballPlayer.h)
