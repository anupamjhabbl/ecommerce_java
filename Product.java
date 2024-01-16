public class Product {
    private int productId;
    private String productName;
    private double price;

    private Category cat;

    // Constructors
    public Product(int productId, String productName, double price, Category cat) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.cat = cat;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }
}
