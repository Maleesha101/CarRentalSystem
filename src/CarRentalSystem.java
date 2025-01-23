import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarRentalSystem {
    private static List<RentalRecord> rentalRecords;
    public CarInventory carInventory;
    public CustomerManager customerManager;
    public StaffManager staffManager;

    public CarRentalSystem() {
        rentalRecords = new ArrayList<>();
        carInventory = new CarInventory();
        customerManager = new CustomerManager();
        staffManager = new StaffManager();
    }

    //Method to return car
    public void rentCar(String customerId, String carId, String filename) {
        Car car = CarInventory.findCarById(carId);
        if (car != null && car.isAvailable()) {
            boolean customerExists = customerManager.getCustomerList().stream()
                    .anyMatch(customer -> customer.getId().equals(customerId));

            if (!customerExists) {
                System.out.println("Customer with ID " + customerId + " not found.");
                return;
            }
            car.setAvailable(false);
            rentalRecords.add(new RentalRecord(customerId, carId));

            // Log the rental in the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                writer.write("[Rented] Customer ID: " + customerId + ", Car ID: " + carId +
                        " on " + timestamp);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error saving rented record to file: " + e.getMessage());
            }
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is either unavailable or does not exist.");
        }
    }

    //Method to return car
    public void returnCar(String carId, String customerId, String filename) {
        Car car = CarInventory.findCarById(carId);
        if (car != null && !car.isAvailable()) {
            car.setAvailable(true);

            // Log the return in the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {

                String timestamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
                writer.write("[Returned] Customer ID: " + customerId + ", Car ID: " + carId +
                        " on " + timestamp);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error saving returned record to file: " + e.getMessage());
            }
            System.out.println("Car returned successfully !!");
        } else {
            System.out.println("Car is already available or does not exist.");
        }
    }

    // Method to load rental records from a file
    public void loadRentalRecordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String customerId = parts[0];
                String carId = parts[1];
                rentalRecords.add(new RentalRecord(customerId, carId));
            }
        } catch (IOException e) {
            System.out.println("Error loading rental records from file: " + e.getMessage());
        }
    }

    // Method to display rental records
    public void displayRentalRecords() {
        if (rentalRecords.isEmpty()) {
            System.out.println("No rental records available.");
        } else {
            System.out.println("Rental Records:");
            for (RentalRecord record : rentalRecords) {
                System.out.println(record);
            }
        }
    }

    // Example of loading all data
    public void loadAllData() {
        carInventory.loadCarsFromFile("cars.txt");
        customerManager.loadCustomersFromFile("customers.txt");
        loadRentalRecordsFromFile("rentalRecords.txt");
    }


    //Display all cars in inventory
    public void displayAllCars() {
        carInventory.getCarList().forEach(System.out::println);
    }

    public void displayRegisteredCustomers() {
       customerManager.getCustomerList().forEach(System.out::println);

    }
    public void displayAvailableCars() {
        List<Car> cars = carInventory.getCarList();
        boolean hasAvailableCars = false;

        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
                hasAvailableCars = true;
            }
        }

        if (!hasAvailableCars) {
            System.out.println("No cars are currently available for rent.");
        }
    }

    //Add customer with unique id
    public String addCustomer(String name, String identityNumber, String phoneNumber) {
        String customerId = "C" + (customerManager.getCustomerList().size() + 1); // Generate a unique ID
        Customer newCustomer = new Customer(customerId, name, identityNumber, phoneNumber);
        customerManager.getCustomerList().add(newCustomer); // Add customer to the list
        System.out.println("Customer added successfully!");
        System.out.println("Customer Details: " + newCustomer);

        return customerId;
    }

    //To add car to inventory
    public void addCarDynamically(String id, String make, String model) {

        Car newCar = new Car(id, make, model, true);
        carInventory.getCarList().add(newCar); // Add the car to the inventory
        System.out.println("Car added successfully!");
        System.out.println("Car Details: " + newCar);
    }

    //Add Staff
    public void addStaff(String name, String identityNumber, String phoneNumber, String role, double salary) {
        staffManager.addStaff(name, identityNumber, phoneNumber, role, salary);
    }

    public void displayRegisteredStaff() {
        staffManager.displayStaff();
    }
    public boolean isValidCustomerId(String customerId) {
        return customerManager.isCustomerRegistered(customerId);
    }


}
