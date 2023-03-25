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
public interface Growable {
    public Boolean grow(Integer lenght);
    
    //inventarse otro metodo que puede ser ancharse o adelgazar
    //e implementar en las clses derivadas, se le puede colocar como 
    //cuerpo un syso, y el retorno puede ser lo que queramos
    
    public Integer slimDown(Integer centimeters);
    public Integer fatten(Integer centimeters);

    public int waterPlant(boolean water);
}
