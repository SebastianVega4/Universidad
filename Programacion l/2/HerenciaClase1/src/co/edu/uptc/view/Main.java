package co.edu.uptc.view;
import co.edu.uptc.model.abstractclass.Student;
public class Main {
    /*
    de las siguientes declaraciones indicar que hacen
    
    ++var   //incrementa en 1 la varible antes de ser llamada
    var++   //la llama y despues la incrementa en uno
    var+=  // la suma de dos variables contando la primera se le asigna a la primer variable
    --var   //decrementa en 1 la varialble antes de ser llamada
    var--   //se decrementa en 1 despues de ser llama 
    var-=  // en la variable var se a se va decrementar antes de mostrarse
    */
    
    public static void main(String[] args) {
//        Daugther fer = new Daugther();
//        Daugther fer2 = new Daugther("Marlon", 1.3f, "Negro", "Rubio", "De la cruz");
//        
//        Son junior = new Son();
//        
        //instanciar la clase student y probar
        
        Student st1 = new Student();
        
        st1.advance(15);
        st1.back(14);
        st1.scrollDown(2);
        st1.scrollLeft(6);
        st1.scrollRight(7);
        st1.scrollUp(10);
        st1.slimDown(30);
        st1.fatten(20);
    }
}