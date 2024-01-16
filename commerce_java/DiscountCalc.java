package commerce_java;

public class DiscountCalc {
    public static double calculateDiscount(Cart cart){
        return cart.calculatePrice()*0.3;          // 30% discount
    }
}
