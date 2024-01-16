package commerce_java;

public class ShippingChargeCalc {
    private static double getDistance(Address address1, Address address2){
        return 23.50;
    }

    public static double calculateCharge(Address address1, Address address2){
        double distance = getDistance(address1, address2);
        return distance*5;
    }
}
