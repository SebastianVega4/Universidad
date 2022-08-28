package Tienda;

public class usuario {
	//atributos
	private String Nombre= "";
	private String cedula;
	private String telefono;
	
	
	//datosUsuario
	public void Nombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public String verNombre() {
		return Nombre;
	}
	public void Cedula(String cedula) {
		this.cedula = cedula;
	}
	public String verCedula() {
		return cedula;
	}
	public void Telefono(String telefono) {
		this.telefono = telefono;
	}
	public String verTelefono() {
		return telefono;
	}
	public String Vertodo() {
		return "***************************************\n"+"Nombre: "+ Nombre +"\n"+
			   "Cedula: "+ cedula +"\n"+
			   "Telefono: "+ telefono+ "\n"+"***************************************";
	}
}
