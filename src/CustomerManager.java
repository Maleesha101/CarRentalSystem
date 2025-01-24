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

    //Add customer with unique id
    public String addCustomer(String name, String identityNumber, String phoneNumber) {
        String customerId = "C" + (getCustomerList().size() + 1); // Generate a unique ID
        Customer newCustomer = new Customer(customerId, name, identityNumber, phoneNumber);
        getCustomerList().add(newCustomer); // Add customer to the list
        System.out.println("Customer added successfully!");
        System.out.println("Customer Details: " + newCustomer);

        return customerId;
    }
    //Load dat from file
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

   //To save all new customers to inventory
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

    //To check user give ID is exit in inventory
    public boolean isCustomerRegistered(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }


}
