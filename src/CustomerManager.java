import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;
    private int customerCounter;

    public CustomerManager() {
        customers = new ArrayList<>();
        customerCounter = 1; // Start customer ID counter
    }

    // Add a customer with details
    public String addCustomer(String name, String identityNumber, String phoneNumber) {
        String generatedId = "C" + customerCounter++;
        Customer customer = new Customer(generatedId, name, identityNumber, phoneNumber);
        customers.add(customer);
        return generatedId;
    }

    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
        } else {
            System.out.println("Registered Customers:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }
}
