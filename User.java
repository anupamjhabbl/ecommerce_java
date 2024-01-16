package commerce_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User{
    private String username;
    private String password;
    private String email;
    public Cart cart;
    private Order[] history;
    private int historyCount;
    
    public User(String username, String password, String email){
        this.username = username;
        this.email = email;
        this.password = password;
        this.cart = null;
        this.history = new Order[100];
        this.historyCount = 0;
    }

    public void updatePassword(String password){
        this.password = password;
    }

    public void showUser(){
        System.out.println("username: "+username+"\nemail: "+email);
    }

    public void appendHistory(Order order){
        this.history[this.historyCount] = order;
        this.historyCount++;
    }

    public void register(){
        try{
            String text = username+"~"+email+"~"+password+"\n";
            FileWriter filewriter = new FileWriter("./commerce_java/userlist.txt", true);
            filewriter.write(text);
            filewriter.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public User login(String username, String password){
        try{
            FileReader fr=new FileReader("./commerce_java/userlist.txt");   
            BufferedReader br=new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){
                String[] words = line.split("~");
                if (words[0].equals(username) && words[2].equals(password)){
                    User user = new User(words[0],words[2], words[1]);
                    br.close();
                    return user;
                }
            }
            br.close();
            System.out.println("User not found");
            return new User(this.username, this.password, this.email);
        }
        catch(IOException e){
            System.out.println(e);
            return new User(this.username, this.password, this.email);
        }
        catch(Exception e){
            System.out.println(e);
            return new User(this.username, this.password, this.email);
        }
    }

    public void logout(){
        System.out.println("You are logged out");
    }

    public void showHistory(){
        for (int i=0;i<historyCount;i++){
            Order order = history[i];
            System.out.println("orderId: "+order.getOrderId()+"\n"+"Address: "+order.getAddress().city+" "+order.getAddress().pincode+"\n"+"Price: "+order.getPrice()+"\n"+"username: "+order.getUser().username);
            System.out.println("Items: ");
            order.getCart().showCart();
        }
    }
}