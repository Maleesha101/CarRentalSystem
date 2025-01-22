import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class CustomerManager {
    private static List<Customer> customers;
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
    public void loadCustomersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                String identityNumber = parts[2];
                String phoneNumber = parts[3];
                customers.add(new Customer(id, name, identityNumber, phoneNumber));
            }

        } catch (IOException e) {
            System.out.println("Error loading customers from file: " + e.getMessage());
        }
    }

    public List<Customer> getCustomerList() {
        return customers;
    }
    public static void saveCustomersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Customer customer : customers) {
                writer.write(customer.getId() + "," + customer.getName() + "," + customer.getIdentityNumber() + "," + customer.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving customers to file: " + e.getMessage());
        }
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
