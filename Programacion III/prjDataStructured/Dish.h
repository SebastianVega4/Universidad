//
// Created by Jairo Riaño on 10/11/23.
//

#ifndef PRJDATASTRUCTURED_DISH_H
#define PRJDATASTRUCTURED_DISH_H
#include <string>
#include <ostream>

class Dish {
public:
    Dish();

    Dish(const std::string &id, const std::string &name, double value, bool isVegetarian, int calories);

    const std::string &getId() const;

    void setId(const std::string &id);

    const std::string &getName() const;

    void setName(const std::string &name);

    double getValue() const;

    void setValue(double value);

    bool isVegetarian1() const;

    void setIsVegetarian(bool isVegetarian);

    int getCalories() const;

    void setCalories(int calories);

    friend std::ostream &operator<<(std::ostream &os, const Dish &dish);

    virtual ~Dish();

private:
    std::string id;
    std::string name;
    double value;
    bool isVegetarian;
    int calories;
};


#endif //PRJDATASTRUCTURED_DISH_H
