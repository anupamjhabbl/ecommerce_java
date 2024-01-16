package commerce_java;

public class Main {
    public static void main(String[] args){
        // Address address = new Address("t455", "abc", "def", "ghi", 23445);
        // Cart cart = new Cart();
        User user = new User("anupidiam","hd8djjdd","djnsndhjd");
        Address address = new Address("838","3uu3","383ndn","hdhd",23445);
        Cart cart = new Cart();
        Category category = new Category(344, "electronics", "sjdnjd");
        Product product1 = new Product(1233, "jdjj", 23.44, category);
        Product product2 = new Product(1233, "jdjj", 23.44, category);
        cart.addProduct(product1);
        cart.addProduct(product2);
        user.cart = cart;
        Order order = new Order("djdjd",address, 345.67, true, cart, user);
        user.appendHistory(order);
        user.appendHistory(order);
        user.showHistory();

        // Order obj = new Order("123", address, 345.566, false, cart, user);
        // System.out.println(obj.getPrice());
    }
}
