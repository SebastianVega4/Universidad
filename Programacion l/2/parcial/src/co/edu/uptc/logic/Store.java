package co.edu.uptc.logic;

public class Store {
    private String product[]=new String[10];
    private String nameProduct = "";
    private int purchasePrice = 0;
    private int salePrice = 0;
    private double weight ;
    private int  high=0;
    private int width=0;


    public Store(String nameProduct, int purchasePrice, int salePrice, double weight, int high, int width) {
        this.nameProduct = nameProduct;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.weight = weight;
        this.high = high;
        this.width = width;
    }
    public Store() {
        this.nameProduct = nameProduct;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.weight = weight;
        this.high = high;
        this.width = width;
    }

    public String[] getProduct() {
        return product;
    }

    public void setProduct(String[] product) {
        this.product = product;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        String js= String.valueOf(weight);
        this.weight = weight;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void addProduc(){
      purchasePrice, int salePrice, double weight, int high, int width
        String productImpr;
        productImpr = "Nombre del producto:  "+ getNameProduct() + "Precio de venta: "++""+ getSalePrice();
        for (var i = 0; i < product.length; i++) {
            if (product[i] == null) {
                product[i] = productImpr;
                break;
            }
        }
    }
}
