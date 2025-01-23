public class Staff extends Person {
    private String role;
    private double salary;

    public Staff(String id, String name, String identityNumber, String phoneNumber, String role, double salary) {
        super(id, name, identityNumber, phoneNumber);
        this.role = role;
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Staff [" + super.toString() + ", Role: " + role + ", Salary: " + salary + "]";
    }
}
