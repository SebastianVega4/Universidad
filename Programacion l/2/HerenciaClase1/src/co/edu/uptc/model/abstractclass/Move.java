package co.edu.uptc.model.abstractclass;
public abstract class Move {
    public abstract Boolean moveForward(Integer distance);
    private static final int lHours = 0;

    public boolean getLiveHours(){
        return lHours >= 0;
    }

    public Boolean advance(Integer distance) {
        System.out.println("Se movio adelante hacia adelante " + distance+" metros");
        return true;
    }
    
    //crear metodo retroceder, desplazar derecha, izquierda
    //subir y bajar
    
    public Boolean back(Integer distance){
        System.out.println("Retrocedio "+distance+" metros");
        return true;
    }
    
    public Boolean scrollRight(Integer distance){
        System.out.println("Se desplazo hacia la derecha "+distance+" metros");
        return true;
    }
    
    public Boolean scrollLeft(Integer distance){
        System.out.println("Se desplazo hacia la izquierda "+distance+" metros");
        return true;
    }
    
    public Boolean scrollUp(Integer distance){
        System.out.println("Se desplazo hacia arriba"+distance+" metros");
        return true;
    }
    
    public Boolean scrollDown(Integer distance){
        System.out.println("Se desplazo hacia abajo "+distance+" metros");
        return true;
    }
}
