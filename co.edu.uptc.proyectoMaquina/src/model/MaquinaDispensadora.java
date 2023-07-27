package model;

import java.util.HashMap;
import java.util.Map;

public class MaquinaDispensadora<T extends Producto> implements Prender, Apagar {
    private boolean encendida;
    private double dineroBase;
    private Map<T, Integer> productosEnInventario;
    private int totalVentas;
    private int totalOnzas;
    private double totalDinero;
    private Map<T, Integer> ventasPorProducto;

    public MaquinaDispensadora() {
        this.encendida = false;
        this.dineroBase = 0.0;
        this.productosEnInventario = new HashMap<>();
        this.totalVentas = 0;
        this.totalOnzas = 0;
        this.totalDinero = 0.0;
        this.ventasPorProducto = new HashMap<>();
    }

    @Override
    public void prender() {
        encendida = true;
    }

    @Override
    public void apagar() {
        encendida = false;
    }

    public void surtirProducto(T producto, int nivelProducto) {
        productosEnInventario.put(producto, nivelProducto);
        ventasPorProducto.put(producto, 0); // Inicializar el contador de ventas en 0 para cada producto
    }


    public void ingresarDineroBase(double dineroBase) {
        this.dineroBase = dineroBase;
    }

    public String realizarVenta(T producto, int onzas, double dineroDepositado) {
        if (!encendida) {
            return "La máquina dispensadora está apagada.";
        }

        Integer nivelProducto = productosEnInventario.get(producto);
        if (nivelProducto == null || nivelProducto < onzas) {
            return "No hay suficiente producto.";
        }
        if (5!=onzas && 10!=onzas){
            return "No Seleccionaste Onzas correctas."+"\nCambio: $" + dineroDepositado;
        }
        double costo = producto.getPrecioPorOnza() * onzas;

        if (dineroDepositado < costo) {
            double faltaDinero = costo - dineroDepositado;
            return "Falta dinero. Debes depositar $" + faltaDinero+"mas. \nCambio: $" + dineroDepositado;
        }

        double cambio = dineroDepositado - costo;
        productosEnInventario.put(producto, productosEnInventario.get(producto)-1);
        producto.incrementarVentas();

        totalVentas++;
        totalOnzas += onzas;
        totalDinero += costo;

        ventasPorProducto.put(producto, ventasPorProducto.get(producto)+1);

        String mensaje = "Venta realizada:\n";
        mensaje += "Producto: " + producto.getNombre() + "\n";
        mensaje += "Tamaño: " + onzas + " onzas\n";
        mensaje += "Dinero depositado: $" + dineroDepositado + "\n";
        mensaje += "Total del Pedido: $" + costo + "\n";
        mensaje += "Cambio: $" + cambio;
        return mensaje;
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

    public Map<T, Integer> getVentasPorProducto() {
        return ventasPorProducto;
    }
}
