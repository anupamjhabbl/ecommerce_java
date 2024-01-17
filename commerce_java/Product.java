package commerce_java;

public class Product {
    private int productId;
    private String productName;
    private double price;

    private Category category;

    // Constructors
    public Product(int productId, String productName, double price, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCat(Category category) {
        this.category = category;
    }

    public void showProduct()
    {
        System.out.println("Product Id: " + getProductId());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Product Price: "+ getPrice());
        System.out.println("Category Name: "+ category.getType());

    }

    public void addProduct(Cart cart){
        Product product = new Product(this.productId, this.productName, this.price, this.category);
        cart.addProduct(product);
    }
}

