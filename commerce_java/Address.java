package commerce_java;

public class Address {
    public String houseno;
    public String city;
    public String district;
    public String state;
    public int pincode;

    public Address(String houseno, String city, String district, String state, int pincode){
        this.houseno = houseno;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pincode = pincode;
    }
}
