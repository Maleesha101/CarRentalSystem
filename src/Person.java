public abstract class Person {
    private String id;
    private String name;
    private String identityNumber;
    private String phoneNumber;

    public Person(String id, String name, String identityNumber, String phoneNumber) {
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
        return "ID: " + id + ", Name: " + name + ", Identity Number: " + identityNumber + ", Phone Number: " + phoneNumber;
    }
}
