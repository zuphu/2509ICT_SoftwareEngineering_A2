public class CustomerDetails {
    static String number, address, ccNumber;
    
    public static String getNumber() {
        return number;
    }
    
    public static String getAddress() {
        return address;
    }
    
    public static String getccNumber() {
        return ccNumber;
    }
    
    public static void setNumber (String number) {
        CustomerDetails.number = number;
    }
    
    public static void setAddress (String address) {
    	CustomerDetails.address = address;
    }
    
    public static void setccNumber (String ccNumber) {
    	CustomerDetails.ccNumber = ccNumber;
    }
}