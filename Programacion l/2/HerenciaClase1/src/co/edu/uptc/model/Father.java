package co.edu.uptc.model;

public class Father {
    
    /*
    todos los atributos son privados en la clase, en estar uml no se ponene
    los sets y gets, solo los atributos,
    */
    
    private String skinColor;
    private String hairColor;
    private String lastName;

    //Los metodos que recibe es una buena practica dejarlos como
    //objetos para poder utilizar los metodos de dichos objetos
    public Boolean walk(Integer meters){
        meters = meters/2;
        meters+=72;
        return true;
        
    }
    public Father(String skinColor, String hairColor, String lastName) {
        this.skinColor = skinColor;
        this.hairColor = hairColor;
        this.lastName = lastName;
    }
    
    public Father(){
        this.skinColor = "blanco";
        this.hairColor = "castaño";
        this.lastName = "Perez";
        
    }
    //Cantidad , tipo y orden para sobrecarga de contructores
    // Aca le agregue un nuevo valor al contructor, weight
    public Father(String skinColor, String lastName, Float weight){
        this.skinColor = "blanco";
        this.hairColor = "castaño";
        this.lastName = "Perez";
        
    }
    //ahora sobre carga de construcctures, tambien se puede colocar en distinto orden y
    // no vota error
    public Father( Float weight,String skinColor, String lastName){
        this.skinColor = "blanco";
        this.hairColor = "castaño";
        this.lastName = "Perez";
        
    }
    
    public String getSkinColor(){
        return this.skinColor;
    }
    
    public void setSkinColor(String skinColor){
        this.skinColor = skinColor;
    }
    
    public String getHairColor(){
        return this.hairColor;
    }
    
    public void setHairColor(String hairColor){
        this.skinColor = hairColor;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
