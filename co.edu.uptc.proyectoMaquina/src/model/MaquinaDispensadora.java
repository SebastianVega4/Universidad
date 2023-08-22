package model;

import java.util.HashMap;
import java.util.Map;

public class MaquinaDispensadora<T extends Producto> implements Prender, Apagar {
    private boolean encendida;
    private double dineroBase;
    private int totalVentas;
    private int totalOnzas;
    private double totalDinero;
    private final Map<T, Integer> nivelOnzasProducto;
    private final Map<T, Double> dineroPorProducto;


    public MaquinaDispensadora() {
        this.nivelOnzasProducto = new HashMap<>();
        this.dineroPorProducto = new HashMap<>();
        this.encendida = false;
    }

    @Override
    public void prender() {
        encendida = true;
    }
    @Override
    public void apagar() {
        encendida = false;
    }

    public void surtirProducto(T producto, int nivelProductoOnzas) {
        nivelOnzasProducto.put(producto, nivelProductoOnzas);
        if (dineroPorProducto.get(producto)!=null){
            dineroPorProducto.put(producto,dineroPorProducto.get(producto)+0.0);
        }else{
            dineroPorProducto.put(producto,0.0);
        }

    }


    public void ingresarDineroBase(double dineroBase) {
        dineroBase += dineroBase;
    }

    public String realizarVenta(T producto, int onzas, double dineroDepositado) {
        if (!encendida) {
            return "La máquina dispensadora está apagada.";
        }

        Integer nivelProducto = nivelOnzasProducto.get(producto);
        if (nivelProducto == null || nivelProducto < onzas) {
            return "No hay suficiente producto.";
        }
        if (5!=onzas && 10!=onzas){
            return """
                   No Seleccionaste Onzas correctas.
                   Cambio: $
                   """ + dineroDepositado;
        }

        double costo = getCosto(producto, onzas);

        if (dineroDepositado < costo) {
            double faltaDinero = costo - dineroDepositado;
            return "Falta dinero. Debes depositar $" + faltaDinero+"mas. \nCambio: $" + dineroDepositado;
        }

        double cambio = dineroDepositado - costo;

        nivelOnzasProducto.put(producto,nivelOnzasProducto.get(producto)-onzas);
        dineroPorProducto.put(producto,dineroPorProducto.get(producto)+ costo);
        producto.incrementarOnzas(onzas);
        producto.incrementarVentas();

        totalVentas++;
        totalOnzas += onzas;
        totalDinero += costo;

        return producto.llenarProducto()+"\nVenta realizada:\n" + "Producto: " + producto.getNombre() + "\n" +
                "Tamaño: " + onzas + " onzas\n" + "Dinero depositado: $" + dineroDepositado + "\n" +
                "Costo: "+ costo +"\n"+
                "Cambio: $" + cambio;
    }
    public double getCosto(T producto,int onzass){
        return producto.getPrecioPorOnza() * onzass;
    }
    public int getTotalVentas() {
        return totalVentas;
    }
    public int getTotalOnzas() {
        return totalOnzas;
    }
    public double getTotalDinero() {
        return totalDinero;
    }
    public int getTotalVentaProducto(T producto) {
        return producto.getTotalVentas();
    }
    public int getTotalOnzasProducto(T producto) {
        return producto.getTotalOnzas();
    }

    public Map<T, Double> getDineroPorProducto() {
        return dineroPorProducto;
    }
}
