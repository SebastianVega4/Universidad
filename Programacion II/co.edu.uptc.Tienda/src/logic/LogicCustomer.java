package logic;

import Interface.GUIstore;
import model.Order;
import model.Product;
import model.ShoppingCart;
import model.User;

import java.io.FileWriter;
import java.io.IOException;

public class LogicCustomer {
    ShoppingCart cart = GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart();
    private Order order;
    private String facture = "";

    //Reguistro de usuario
    public String signinCustomer() {
        try {
            GUIstore.getCustomers().addUsersToTxt();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return "Usuario Registrado";
    }

    //logica iniciar sesion
    public boolean loginCustomer(String email, String password) {
        int userSize = 0;
        for (User customer : GUIstore.getCustomers().getUsers()) {
            if (customer.getEmail().equals(email)) {
                if (customer.getPassword().equals(password)) {
                    GUIstore.setUserSelect(userSize);
                    return true;
                }
            }
            userSize++;
        }
        return false;
    }

    //logica saber cuantos productos compra y añadir al corrito
    public void addNumberPurchesed(Product product, int amount) {
        cart.setPurchased(product, amount);
    }

    public String addPurchased(Product product) {
            cart.addProduct(product);
            return "Articulo: '" + product.getNameProduct() + "' añadido al carrito.";
    }

    //logica eliminar producto del carrito
    public void eraseProductCart(Product product) {
        cart.eraseProduct(product);
    }

    //logica vaciar carrito de compra
    public void clearCart() {
        GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().getProducts().clear();
    }

    //logica para realizar la compra
    public boolean ifAdressIsNull() {
        return GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getAddress() == null ||
                GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getAddress().equals("null") ||
                GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getAddress().isEmpty();
    }

    public void makePurchase(String address) throws IOException {
        GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).setAddress(address);
        order = new Order(cart, address);
        createFileFactureUser();
        if (!address.isEmpty()) {
            lessInventary();
            GUIstore.getCustomers().addUsersToTxt();
            setFacture();
        }
    }

    public void makePurchase() throws IOException {
        order = new Order(cart, GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getAddress());
        createFileFactureUser();
        setFacture();
        lessInventary();
        GUIstore.getCustomers().addUsersToTxt();
        clearCart();
    }

    public void lessInventary() throws IOException {
        for (Product product : GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().getProducts()){
            int numberPurchased=GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().getPurchased(product);
            product.setStock(product.getStock()-numberPurchased);
        }
        GUIstore.getInventory().updateProductToTxt();
    }


    public String getFacture() {
        return facture;
    }

    public void setFacture() {
        if (GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().getProducts().isEmpty()){
            facture = GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getName() +
                    "\n No tiene productos en el carrito\n";
        }else {
            facture = GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getName() +
                    " su facura se ha generado con exito \n"
                    + "    ¡Tu ferreteria de Confianza!\n";
            for (Product orderliness : order.getShoppingCart().getProducts()) {
                facture += " _______________________________" + "\n" + "Producto:  " + orderliness.getNameProduct() + "\n"
                        + "Cantidad: " + order.getShoppingCart().getPurchased(orderliness) + "\n"
                        + "Precio:  " + orderliness.getPrice() + "\n";
            }
        }
        facture += " _______________________________" + "\n \n" +
                "Total:  $" + GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getShoppingCart().calcTotal()
                + "\n                 ¡Gracias por preferirnos!";
    }

    //crear archivo por cada usuario(factura)
    public void createFileFactureUser() throws IOException {
        FileWriter writerFactureUser = new FileWriter("Resourses\\Bills\\User" + GUIstore.getCustomers().getUsers().get(GUIstore.getUserSelect()).getName() + ".txt", true);

        order.getShoppingCart().getProducts().forEach(ordenes -> {
            try {
                writerFactureUser.write(ordenes.getNameProduct() + "," + order.getShoppingCart().getPurchased(ordenes) + ","
                        + ordenes.getPrice() + "," + order.getShoppingCart().calcTotalForProduct(ordenes) + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writerFactureUser.close();
    }
}