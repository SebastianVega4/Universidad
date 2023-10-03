package persistence;

import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bills {
	private ArrayList<Product> products;
	private String name;
	
	public Bills(String name) throws IOException {
		this.name = name;
		products = new ArrayList<Product>();
		obtainBills();
	}
	
	public void obtainBills() throws IOException {
		try {
			FileReader reader = new FileReader("Resourses\\Bills\\User" + name + ".txt");
			BufferedReader buffered = new BufferedReader(reader);
			String line;
			while((line = buffered.readLine()) != null) {
				String[] fila = line.split(",");
				String name = fila[0];
				String cantidad = fila[1];
				String precio = fila[2];
				products.add(new Product(0, name, "", Double.parseDouble(precio), Integer.parseInt(cantidad)));
			}
			buffered.close();
		}catch (java.io.FileNotFoundException e) {
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
}
