public class Main {
    public static void main(String[] args) {
        // Creating an array of subcategories
        Category[] subcategories = {
                new Category(101, "Subcategory1", "Description1", null),
                new Category(102, "Subcategory2", "Description2", null)
        };

        // Creating an instance of the Category class with subcategories
        Category mainCategory = new Category(100, "MainCategory", "MainDescription", subcategories);

        // Creating instances of the Product class with a category
        Product product1 = new Product(1, "Laptop", 999.99, mainCategory);
        Product product2 = new Product(2, "Smartphone", 499.99, mainCategory);

        // Creating a Cart and adding products to it
        Cart cart = new Cart(new Product[]{product1, product2});

        // Showing cart contents
        System.out.println("Initial Cart Contents:");
        cart.showCart();

        // Calculating total price
        float totalPrice = cart.calculatePrice();
        System.out.println("\nTotal Price of Cart: $" + totalPrice);

        // Removing a product from the cart
        cart.removeProduct(1);

        // Showing updated cart contents
        System.out.println("\nUpdated Cart Contents:");
        cart.showCart();
    }
}
