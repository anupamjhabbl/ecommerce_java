package commerce_java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Inventory inventory = new Inventory();


        while (true) {

            System.out.println("Click 1 for Admin: ");
            System.out.println("Click 2 for User: ");
            System.out.println("Click any other key for exit: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice == 1) {
                while (true)
                {
                    int choice2;
                    System.out.println("Click 1 for adding product: ");
                    System.out.println("Click 2 for deleting product: ");
                    System.out.println("Click 3 to show product in Inventory: ");
                    System.out.println("Click any other key for exit");
                    choice2 = sc.nextInt();
                    if (choice2 == 1)
                    {

                        System.out.println("Enter Category id: ");
                        int id = sc.nextInt();

                        System.out.println("Enter category type: ");
                        String type = sc.next();

                        System.out.println("Enter description of category: ");
                        String desc = sc.next();

                        Category cat = new Category(id, type, desc);

                        System.out.println("Enter product ID: ");
                        int prodId = sc.nextInt();

                        System.out.println("Enter Product Name: ");
                        String productName = sc.next();

                        System.out.println("Enter product price: ");
                        double price = sc.nextDouble();

                        Product product = new Product(prodId,productName,price, cat);
                        System.out.println("Enter number of quantity: ");
                        int quantity = sc.nextInt();

                        inventory.addProduct(product, quantity);
                    }else if(choice2 == 2)
                    {
                        try {
                            System.out.print("Enter product ID to delete the item: ");
                            int product_id = sc.nextInt();

                            System.out.print("Enter number of quantity to delete: ");
                            int quantity = sc.nextInt();

                            inventory.removeProduct(product_id, inventory.prodcat.get(product_id), quantity);
                        }
                        catch (Exception e)
                        {
                            System.out.println("This product is not present in inventory.");
                        }

                    }else if(choice2 == 3)
                    {
                        inventory.showProduct();
                    }
                    else {
                        break;
                    }


                }

            } else if(choice == 2 ) {
                System.out.println("user");
                User user = new User("null", "null", "null");
                while (true)
                {
                    int choice3;
                    System.out.println("Do you want to login or register");
                    System.out.println("Press 1 to login");
                    System.out.println("Press 2 to register");
                    choice3 = sc.nextInt();

                    if(choice3 == 1)
                    {
                        System.out.println("Enter your username: ");
                        String username = sc.next();
                        System.out.println("Enter your password");
                        String password = sc.next();

                        User user1  = user.login(username, password);
                        if(user1 != null)
                        {
                            System.out.println("Login Successfull! ");
                            System.out.println("*******************************************");
                            System.out.println("Enter Category id:");

                            int catid = sc.nextInt();
                            ArrayList<ItemQuantity> productList = inventory.stock.get(catid);
                            for (ItemQuantity i : productList)
                            {
                                i.product.showProduct();
                                System.out.println(i.quantity);
                            }

                            Cart cart = new Cart();
                            user1.cart = cart;
                            while (true){
                                int choice5;
                                System.out.println("Enter 1 for adding a product to cart");
                                System.out.println("Enter any other key for exiting");
                                choice5 = sc.nextInt();
                                if (choice5==1){
                                    System.out.print("Enter productId of product that you want to buy: ");
                                    int productId = sc.nextInt();
                                    Product pr = inventory.findProduct(productId);
                                    if (pr==null){
                                        System.out.println("This product doesn't exist");
                                        continue;
                                    }
                                    pr.addProduct(cart);
                                    inventory.removeProduct(productId, pr.getCategory(), 1);
                                }
                                else{
                                    break;
                                }
                            }

                            System.out.println("Your Cart is: ");
                            cart.showCart();
                            System.out.println("To place your order click 1");
                            System.out.println("To leave thr order click 2");
                            int choiceOrderPlace = sc.nextInt();
                            if (choiceOrderPlace==1){
                                System.out.print("Enter your houseno: ");
                                String houseno = sc.next();
                                System.out.print("Enter your city: ");
                                String city = sc.next();
                                System.out.print("Enter your city: ");
                                String district = sc.next();
                                System.out.print("Enter your state: ");
                                String state = sc.next();
                                System.out.print("Enter your pinocde: ");
                                int pincode = sc.nextInt();
                                Address address = new Address(houseno, city, district, state, pincode);
                                Order order = cart.placeOrder(user1, address);
                                order.showOrder();
                            }
                            else{
                                continue;
                            }

                         break;
                        }
                    }
                    else if(choice3 == 2)
                    {
                        System.out.println("Enter Username: ");
                        String username = sc.next();
                        System.out.println("Enter your password");
                        String password = sc.next();
                        System.out.println("Enter your email");
                        String email = sc.next();
                        user.register(username, email, password);

                        System.out.println("Register Successfull! ");


                    }else{
                        break;
                    }

                }

            }else
            {
                System.out.println("Break ");
                break;
            }
        }


//        Category electronics = new Category(1234, "electronics", "dhhdhd");
//        Category clothing = new Category(4321, "clothing", "dhhdhd");
//        inventory.addCategory(electronics);
//        Product p1 = new Product(1, "mouse", 23.45, electronics);
//        Product p2 = new Product(2,"monitor",3338, electronics);
//        inventory.addProduct(p2, 2);
//        inventory.addProduct(p1, 3);
//        Product p3 = new Product(3,"shirt",3338, clothing);
//        inventory.addProduct(p3, 2);
//        inventory.removeProduct(p1, -1);
//        System.out.println(inventory.stock.get(1234).size());
    }
}
