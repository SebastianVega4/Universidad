package Tienda;

public class factura {
	private double ValorSuptotal=0;
	private double ValorSuptotalcomp=0;
	private double total=0;
	private int opciondepago=0;
	private double descuento1=0;
	private double adicionaltarjeta=0;
	private double iva=0.19;
	private double valorconiva=0;
	private int puntos=0;
	
	public factura(double ValorSuptotal) {	
		this.ValorSuptotal =ValorSuptotal;
		}

	public double operarDescuentos() {
		 //descuento dependiendo el sudtotal de la compra
		if(ValorSuptotal>500000.0) {
			descuento1=ValorSuptotal*0.25;
			ValorSuptotalcomp=ValorSuptotal-descuento1;
			return ValorSuptotalcomp;
		}else if(ValorSuptotal>350000.0) {
			descuento1=ValorSuptotal*0.20;
			ValorSuptotalcomp=ValorSuptotal-descuento1;
			return ValorSuptotalcomp;
		}else if(ValorSuptotal>200000.0) {
			descuento1=ValorSuptotal*0.15;
			ValorSuptotalcomp=ValorSuptotal-descuento1;
			return ValorSuptotalcomp;
		}else if(ValorSuptotal>100000.0) {
			descuento1=ValorSuptotal*0.10;
			ValorSuptotalcomp=ValorSuptotal-descuento1;
			return ValorSuptotalcomp;
		}else if(ValorSuptotal>50000.0) {
			descuento1=ValorSuptotal*0.05;
			ValorSuptotalcomp=ValorSuptotal-descuento1;
			return ValorSuptotalcomp;
		}
		return ValorSuptotal;
	}
	public double verdescuento() {
		return descuento1;
		
	}
	public void Opcion(int opciondepago) {
		
		this.opciondepago =opciondepago;
		}
	
	public String verOpcion() {
		//visa y mastercard
		if(opciondepago==1) {
			adicionaltarjeta=(ValorSuptotalcomp*0.015);
			valorconiva =ValorSuptotalcomp*iva;
			total=ValorSuptotalcomp+adicionaltarjeta+valorconiva;
			return "Adicinal por tarjeta de credito: "+
					adicionaltarjeta;
		}
		if(opciondepago==2) {
			valorconiva =ValorSuptotalcomp*iva;
			total=ValorSuptotalcomp+valorconiva;
			return "A elegido pagar en efectivo \n porfavor diriguete al punto mas cercano \n con el codigo :77777777 para pagar";
		}
		return null;
	}
	
	
	public String Factura() {
		return "Descuento por precio: "+verdescuento()+"$\n"+"Insumo Valor iva: "+valorconiva+"$\n"+"********************************************************************\n"+ "Valor Total a pagar : "+ total+"$\n";
	}
	public String puntosOptenidos() {
		puntos=(int)total/1000;
		if(puntos>1200) {
			return "Usted acumulo por su compra un total de: "+puntos+" puntos \n ve a la caja con el recivo y reclama 1 SMARTPHONE y 1 ASISTEMTE";
		}
		else if(puntos>1000) {
			return "Usted acumulo por su compra un total de: "+puntos+" puntos \n ve a la caja con el recivo y reclama 1 ASISTEMTE Y 1 ROBOT ASPIRADOR";
		}
		else if(puntos>600) {
			return "Usted acumulo por su compra un total de: "+puntos+" puntos \n ve a la caja con el recivo y reclama 1 INTERRUPTOR";
		}
		else if(puntos>400) {
			return "Usted acumulo por su compra un total de: "+puntos+" puntos \n ve a la caja con el recivo y reclama 1 TOMA";
		}
		else if(puntos>200) {
			return "Usted acumulo por su compra un total de: "+puntos+" puntos \n ve a la caja con el recivo y reclama 1 SENSOR";
		}
		return null;
	}


}