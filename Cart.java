package commerce_java;

public class Cart {
    private Product[] productList;

    public Cart(Product[] productList) {
        this.productList = productList;
    }

    public void showCart() {
        System.out.println("Cart Contents:");
        for (Product product : productList) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("---------------");
        }
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void removeProduct(int productId) {
        // Assuming you have a method to find the index of a product in the array
        int index = findProductIndex(productId);

        if (index != -1) {
            // Create a new array excluding the product to be removed
            Product[] updatedCart = new Product[productList.length - 1];
            System.arraycopy(productList, 0, updatedCart, 0, index);
            System.arraycopy(productList, index + 1, updatedCart, index, productList.length - index - 1);

            // Update the cart
            productList = updatedCart;

            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found in the cart.");
        }
    }

    // public Order placeOrder(User user, Address ad){
    // // Implementation of placing an order
    // }

    // Helper method to find the index of a product in the array
    private int findProductIndex(int productId) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i].getProductId() == productId) {
                return i;
            }
        }
        return -1; // Product not found
    }
}
