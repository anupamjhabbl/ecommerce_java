package commerce_java;

public class Main {
    public static void main(String[] args){
        // Address address = new Address("t455", "abc", "def", "ghi", 23445);
        // Cart cart = new Cart();
        User user = new User("anupamjhabbl","fordGT350","anupamjhabbl@gmail.com");
        Address address = new Address("T128","subhash Nagr","new delhi","delhi",110013);
        Cart cart = new Cart();
        Category electronics = new Category(344, "electronics", "This holds items related to electronics.");
        Product product1 = new Product(1233, "mouse", 23.44, electronics);
        Product product2 = new Product(1528, "monitor", 1200.23, electronics);
        cart.addProduct(product1);
        cart.addProduct(product2);
        user.cart = cart;
        cart.placeOrder(user, address);
        cart.placeOrder(user, address);
        user.showHistory();

        // Order obj = new Order("123", address, 345.566, false, cart, user);
        // System.out.println(obj.getPrice());
    }
}
