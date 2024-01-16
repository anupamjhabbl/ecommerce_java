public class Cart {
    private Product[] p;

    public Cart(Product[] p) {
        this.p = p;
    }

    public void showCart() {
        System.out.println("Cart Contents:");
        for (Product product : p) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("---------------");
        }
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (Product product : p) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void removeProduct(int productId) {
        // Assuming you have a method to find the index of a product in the array
        int index = findProductIndex(productId);

        if (index != -1) {
            // Create a new array excluding the product to be removed
            Product[] updatedCart = new Product[p.length - 1];
            System.arraycopy(p, 0, updatedCart, 0, index);
            System.arraycopy(p, index + 1, updatedCart, index, p.length - index - 1);

            // Update the cart
            p = updatedCart;

            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found in the cart.");
        }
    }

//    public Order placeOrder(User user, Address ad){
//        // Implementation of placing an order
//    }

    // Helper method to find the index of a product in the array
    private int findProductIndex(int productId) {
        for (int i = 0; i < p.length; i++) {
            if (p[i].getProductId() == productId) {
                return i;
            }
        }
        return -1; // Product not found
    }
}
