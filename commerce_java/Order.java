package commerce_java;

public class Order {
    private String orderId;
    private Address address;
    private double price;
    private Cart cart;
    private User user;
    private boolean paid;

    public Order(String orderId, Address address, double price, boolean paid, Cart cart, User user){
        this.orderId = orderId;
        this.address = address;
        this.price = price;
        this.paid = paid;
        this.cart = cart;
        this.user = user;
    }

    public void showOrder(){
        System.out.println("OrderId: "+orderId);
        System.out.println("Address: "+address.houseno+", "+address.city+", "+address.district+", "+address.state+", "+address.pincode);
        System.out.println("price: "+price);
        System.out.println("Products: ");
        cart.showCart();
    }

    public String getOrderId() {
        return this.orderId;
    }
    
    public User getUser(){
        return this.user;
    }

    public Address getAddress(){
        return this.address;
    }

    public double getPrice(){
        return this.price;
    }

    public Cart getCart(){
        return this.cart;
    }

    public boolean isPaid(){
        return this.paid;
    }

    public void changePaidStatus(){
        paid = !paid;
    }
}
