/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.model.abstractclass;

/**
 *
 * @author Sala 6
 */
public class Student extends Move implements Growable{

    @Override
    public Boolean moveForward(Integer distance) {
        advance(distance);
        return true;
    }

    @Override
    public Boolean grow(Integer lenght) {
        System.out.println("Crece verracamente");
        return true;
    }

    @Override
    public Integer slimDown(Integer centimeters) {
        System.out.println("Adelagazo "+centimeters+" centimetros");
        return centimeters;
    }

    @Override
    public Integer fatten(Integer centimeters) {
        System.out.println("Engordo "+centimeters+" centimetros");
        return centimeters;
    }
    
}
