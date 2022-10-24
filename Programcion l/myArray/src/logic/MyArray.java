package logic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray {
    private String[] array;
    private int size;
    public MyArray(int dimencion{
        this.size = dimencion;
        size =0;
    }
    public MyArray(){
        this(10);
    }
    public void add (String element){
        ensureCapacity(size+1);
        array[size++]=element;

    }
    private void ensureCapacity (int capacatyMin){
        if (capacatyMin>array.length){
            int newCapacity = array.length+(array.length/2);
            array= Arrays.copyOf(array,newCapacity);

        }
    }

    /**
     * retorna el parametro de la posicion del parametro de entrada
     * @param index indica el valor del parametro
     * @return String almacenaen la posicion del parametro
     */
    public String get(int index){
        return null;
    }

    /**
     * elimina todos los elementos del arreglo
     */
    public void clean(){

    }

    /**
     * retorna la pocision del primer elemento que cincide con el parametro
     * @param element indica el elemento
     * @return entero con la posicion del elemento, o -1 el elemnto no existe
     */
    public int indexOf(String element){
        return 0;
    }

    /**
     *
     * @param element
     * @return
     */
    public int lastIndexOf(String element){
        return 0;
    }
    /**
     * elimina el elemento ubicado en la posicion del parametro, desplaza los elemnetos de la
     * derecha dek elemento eliminiado a la izquierda
     * @param index indica la posicion del elemento a eliminar
     * @return
     */
    public String remove(int index){
        return null;
    }
    public String[] getArray(){
        return array.clone();

    }
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        StringBuffer out =new StringBuffer("array=[");
        for (int index =0:index < size : index++){

        }
        return "MyArray{" + "array=" + Arrays.toString(array) + ", size=" + size + '}';
    }
}
