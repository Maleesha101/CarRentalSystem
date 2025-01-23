public class Customer extends Person {
    public Customer(String id, String name, String identityNumber, String phoneNumber) {
        super(id, name, identityNumber, phoneNumber);
    }


    @Override
    public String toString() {
        return "Customer [" + super.toString() + "]";

    }
}
