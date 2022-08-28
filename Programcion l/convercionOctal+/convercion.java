package convercion;

public class convercion {

	private String otros ;
	private String binario ;
	private String octal ;
	private String hexadciamal;
	private int decimal;
	
	
	
	public String getDecimal() {
		return "El numero en binario es: "+binario+ "\n" +"El numero en Octal es: "+octal+"\n"+"El numero en Hexadciamal es: "+hexadciamal+"\n";
	}
	public void setDecimal(int decimal) {
		 octal = Integer.toOctalString(decimal);
		 hexadciamal = Integer.toHexString(decimal);
		 binario = Integer.toBinaryString(decimal);
		this.decimal = decimal;
		
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros,String number) {
		if (otros=="Binario") {
			otros.matches("^[0-9]$");
		}
		if(otros=="Octal"){
			
		}
		if(otros=="Hexadecimal"){
			
		}
		this.otros = otros;
	}
	
}
