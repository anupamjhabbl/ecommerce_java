package commerce_java;

import java.util.ArrayList;

public class User{
    private String username;
    private String password;
    private String email;
    private Cart cart;
    private ArrayList<Order> history;
    
    public User(String username, String password, String email){
        this.username = username;
        this.email = email;
        this.password = password;
        this.cart = null;
        // this.history = new ArrayList<>();
    }

    public void updatePassword(String password){
        
    }

    public void register(String username, String email, String password){

    }

    public void login(String username, String password){

    }

    public void logout(){

    }

    public void showHistory(){
        for (int i=0;i<history.size();i++){
            Order order = history.get(i);
            System.out.println("orderId: "+order.getOrderId()+"\n"+"Address: "+order.getAddress()+"\n"+"Price: "+order.getPrice()+"\n"+"username: "+order.getUser().username);
            System.out.println("Items: ");

            // code for showing the item
        }
    }
}