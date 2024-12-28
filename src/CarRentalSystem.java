import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private CarInventory carInventory;
    private CustomerManager customerManager;
    private List<Rental> rentalRecords; // List to store rental records

    public CarRentalSystem() {
        carInventory = new CarInventory();
        customerManager = new CustomerManager();
        rentalRecords = new ArrayList<>();

        // Preload some cars
        preloadCars();
    }

    private void preloadCars() {
        carInventory.addCar(new Car("1", "Toyota", "Corolla", true));
        carInventory.addCar(new Car("2", "Honda", "Civic", true));
        carInventory.addCar(new Car("3", "Ford", "Focus", true));
        carInventory.addCar(new Car("4", "Hyundai", "Elantra", true));
        carInventory.addCar(new Car("5", "Tesla", "Model 3", true));
    }

    public void displayAllCars() {
        carInventory.displayAllCars();
    }

    public void displayAvailableCars() {
        carInventory.displayAvailableCars();
    }

    public String addCustomer(String name, String identityNumber, String phoneNumber) {
        return customerManager.addCustomer(name, identityNumber, phoneNumber);
    }

    public void displayRegisteredCustomers() {
        customerManager.displayCustomers();
    }

    public void rentCar(String customerId, String carId) {
        Car car = carInventory.findCarById(carId);
        if (car != null && car.isAvailable()) {
            Customer customer = customerManager.findCustomerById(customerId);
            if (customer != null) {
                car.setAvailable(false);
                rentalRecords.add(new Rental(customerId, carId));
                System.out.println("Car rented successfully!");
            } else {
                System.out.println("Customer ID not found.");
            }
        } else {
            System.out.println("Car is unavailable or does not exist.");
        }
    }

    public void returnCar(String carId) {
        Car car = carInventory.findCarById(carId);
        if (car != null && !car.isAvailable()) {
            car.setAvailable(true);
            rentalRecords.removeIf(rental -> rental.getCarId().equals(carId));
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("Car is not rented or does not exist.");
        }
    }

    public void displayRentalRecords() {
        if (rentalRecords.isEmpty()) {
            System.out.println("No rentals recorded.");
        } else {
            System.out.println("Rental Records:");
            for (Rental rental : rentalRecords) {
                System.out.println(rental);
            }
        }
    }

    public CarInventory getCarInventory() {
        return carInventory;
    }
}
