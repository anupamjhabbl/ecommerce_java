package commerce_java;

public class Main {
    public static void main(String[] args){
        Inventory inventory = new Inventory();
        Category electronics = new Category(1234, "electronics", "dhhdhd");
        Category clothing = new Category(4321, "clothing", "dhhdhd");
        inventory.addCategory(electronics);
        Product p1 = new Product(1, "mouse", 23.45, electronics);
        Product p2 = new Product(2,"monitor",3338, electronics);
        inventory.addProduct(p2, 2);
        inventory.addProduct(p1, 3);
        Product p3 = new Product(3,"shirt",3338, clothing);
        inventory.addProduct(p3, 2);
        inventory.removeProduct(p1, -1);
        System.out.println(inventory.stock.get(1234).size());
    }
}
