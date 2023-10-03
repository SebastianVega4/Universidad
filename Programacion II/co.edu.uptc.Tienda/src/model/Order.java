package model;

public class Order {
    private ShoppingCart shoppingCart;
    private String addressShopping;

    public Order(ShoppingCart shoppingCart, String addressShopping) {
        this.shoppingCart = shoppingCart;
        this.addressShopping = addressShopping;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getAddressShopping() {
        return addressShopping;
    }

    public void setAddressShopping(String addressShopping) {
        this.addressShopping = addressShopping;
    }
}