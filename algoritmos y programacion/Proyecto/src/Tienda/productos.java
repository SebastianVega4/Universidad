package Tienda;

public class productos {
	//atributos
	private String nombrePro;
	private double precio=0;
	private int cantstock;
	private boolean disponible = false;
	private int contador=0;
	private double subtotal=0;
	
	//constructors
	public productos(String nombrePro, double precio, int cantstock, boolean disponible) {
		this.nombrePro = nombrePro;
		this.precio = precio;
		this.cantstock = cantstock;
		this.disponible = disponible;
	}
	
	//DatosProducto	
	public String verNombrePro() {
		return nombrePro;
	}
	public double verPrecio() {
		return precio;
	}
	
	public int verCantStock() {
		return cantstock;
	}
	
	public boolean verDisponible() {
		return disponible;
	}
	
	public void Contador() {
		contador++;
	}
	public int verContador() {
		return contador;
	}
	//factura
	public void SubTotal() {
		subtotal=precio*contador;
	}
	public double verSubTotal() {
		return subtotal;
	}
	
	public String supFactura() {
		return "Producto: "+nombrePro+"\n"+"Valor por unidad: $" + precio+"\n"+ "Usted esta comprando "+ contador + " articulos\n"+"SubTotal: $"+subtotal+" ";
	}

}