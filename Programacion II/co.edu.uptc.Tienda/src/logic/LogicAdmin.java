package logic;

import java.io.IOException;

import Interface.GUIstore;
import model.Administrator;
import model.Product;
import persistence.ImageProducts;
import persistence.Inventory;

public class LogicAdmin {

	private Inventory inventory = null;
	private ImageProducts ip;
	private Administrator admi;
	
	public LogicAdmin(){
		ip = new ImageProducts();
		admi = new Administrator();
		try {
			inventory = new Inventory();
		} catch (IOException e) {
			System.out.println("ups alg paso");
		}
	}
	
    // iniciar sesion administrador
    public boolean adminlogin(String name, String password) {
        return name.equalsIgnoreCase(admi.getName()) && password.equalsIgnoreCase(admi.getPassword());
    }
    public void deletteProduct(int indice) throws IOException {
    	ip.DeleteImage(inventory.getProducts().get(indice).getId());
    	inventory.getProducts().remove(indice);
    	inventory.updateProductToTxt();
    }

	public void editProduct(String name, String description, String price, String stock, int index) throws IOException {
		Product p = inventory.getProducts().get(index);
		p.setNameProduct(name);
		p.setDescription(description);
		p.setPrice(Double.parseDouble(price));
		p.setStock(Integer.parseInt(stock));
		
		inventory.updateProductToTxt();
	}
	
	public int newIndex() {
		return inventory.getProducts().get(inventory.getProducts().size()-1).getId() + 1;
	}

	public void addProduct(String name, String description, String price, String stock, int index) {
		Product p = new Product(index, name, description, Double.parseDouble(price), Integer.parseInt(stock));
		inventory.getProducts().add(p);
		
		try {
			inventory.updateProductToTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ip.renameImage(String.valueOf(index));
	}
	
	public void deleteImage() {
    	ip.DeleteImage(newIndex());
	}
}
