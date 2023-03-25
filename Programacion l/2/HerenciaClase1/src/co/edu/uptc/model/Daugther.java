/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.model;

/**
 *
 * @author Sala 6
 */
public class Daugther extends Father{
    private String name;
    private Float height;

    public Daugther(String name, Float height,String skinColor,String hairColor,String lastName){
        super(skinColor,hairColor,lastName);
        this.name = name;
        this.height = height;
    }
    public Daugther(){
        super();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }
    
    
}
