public class Customer {
    private String id; // System-generated customer ID
    private String name;
    private String identityNumber; // Customer's NIC
    private String phoneNumber; // Customer's phone number

    public Customer(String id, String name, String identityNumber, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name +
                ", Identity Number: " + identityNumber +
                ", Phone Number: " + phoneNumber;
    }
}
