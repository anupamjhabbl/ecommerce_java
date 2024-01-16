package commerce_java;
import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
    private ArrayList<Product> productList;

    public Cart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product)
    {
        productList.add(product);
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
            totalPrice += (float) product.getPrice();
        }
        return totalPrice;
    }

    public void removeProduct(int productId) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId() == productId) {
                iterator.remove();
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found in the cart.");
    }

    public void placeOrder(User user, Address address){
        Address headAddress = new Address("c455","mahua","Vaisali","Bihar",844126);
        double price = user.cart.calculatePrice() + ShippingChargeCalc.calculateCharge(headAddress, address) - DiscountCalc.calculateDiscount(user.cart);
        Order order = new Order("hdhbcb", address, price, false, user.cart, user);
        // payment is done
        order.changePaidStatus();
        System.out.println("Your order is placed");
        user.appendHistory(order);
    }

    // No need for a separate method to find product index, as ArrayList provides indexOf()

    // You can add other methods or functionalities as needed
}
