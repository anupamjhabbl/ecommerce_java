package commerce_java;

public class DiscountCalc {
    public static double calculateDiscount(Order order){
        return order.getPrice() - order.getPrice()*0.3;          // 30% discount
    }
}
