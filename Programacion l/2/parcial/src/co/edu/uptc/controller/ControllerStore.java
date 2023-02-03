package co.edu.uptc.controller;
import co.edu.uptc.logic.Store;

public class ControllerStore {
    Store store= new Store();
    public void menu(){

        store.addProduc();


    }
    public void getNombre(String Name){
        store.setNameProduct(Name);
    }
    public void getPcompra(int PCompra){
        store.setPurchasePrice(PCompra);
    }
    public void getPventa(int PVenta){
        store.setSalePrice(PVenta);
    }
    public void getPeso(int peso){
        store.setWeight(peso);
    }
    public void getAlto(int alto){
        store.setHigh(alto);
    }
    public void getAncho(int ancho){
        store.setWidth(ancho);
    }





}
