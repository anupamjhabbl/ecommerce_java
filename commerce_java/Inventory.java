package commerce_java;

import java.util.*;

public class Inventory {
    public HashMap<Integer, ArrayList<ItemQuantity>> stock;

    public Inventory(){
        this.stock = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        Category catg = product.getCategory();
        ArrayList<ItemQuantity> arr = stock.get(catg.getId());
        if (arr==null){
            ArrayList<ItemQuantity> newArr = new ArrayList<>();
            ItemQuantity item = new ItemQuantity(product, quantity);
            newArr.add(item);
            stock.put(catg.getId(), newArr);
        }
        else{
            ItemQuantity item = new ItemQuantity(product, quantity);
            arr.add(item);
            stock.put(catg.getId(), arr);
        }
    }

    public void removeProduct(Product product, int quantity){
        Category catg = product.getCategory();
        ArrayList<ItemQuantity> arr = stock.get(catg.getId());
        if (arr!=null){
            for (int i=0;i<arr.size();i++){
                if (arr.get(i).product.getProductId()==product.getProductId()){
                    if (quantity==-1){
                        arr.remove(i);
                    }
                    else{
                        if (arr.get(i).quantity>=quantity){
                            arr.get(i).quantity -= quantity;
                        }
                        else{
                            arr.get(i).quantity = 0;
                        }
                    }
                }
            }
            stock.put(catg.getId(), arr);
        }
    }

    public void addCategory(Category category){
        if (stock.get(category.getId())==null){
            ArrayList<ItemQuantity> arr = new ArrayList<>();
            stock.put(category.getId(), arr);
        }
    }

    public void removeCategory(Category category){
        stock.remove(category.getId());
    }
}
