//
// Created by Jairo Riaño on 10/11/23.
//

#include "Dish.h"

Dish::Dish() {}

Dish::Dish(const std::string &id, const std::string &name, double value, bool isVegetarian, int calories) : id(id),
                                                                                                            name(name),
                                                                                                            value(value),
                                                                                                            isVegetarian(
                                                                                                                    isVegetarian),
                                                                                                            calories(
                                                                                                                    calories) {}

const std::string &Dish::getId() const {
    return id;
}

void Dish::setId(const std::string &id) {
    Dish::id = id;
}

const std::string &Dish::getName() const {
    return name;
}

void Dish::setName(const std::string &name) {
    Dish::name = name;
}

double Dish::getValue() const {
    return value;
}

void Dish::setValue(double value) {
    Dish::value = value;
}

bool Dish::isVegetarian1() const {
    return isVegetarian;
}

void Dish::setIsVegetarian(bool isVegetarian) {
    Dish::isVegetarian = isVegetarian;
}

int Dish::getCalories() const {
    return calories;
}

void Dish::setCalories(int calories) {
    Dish::calories = calories;
}

std::ostream &operator<<(std::ostream &os, const Dish &dish) {
    os << "id: " << dish.id << " name: " << dish.name << " value: " << dish.value << " isVegetarian: "
       << dish.isVegetarian << " calories: " << dish.calories;
    return os;
}

Dish::~Dish() {

}
