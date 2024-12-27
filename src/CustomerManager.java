import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
