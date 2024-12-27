import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private CarInventory carInventory;
    private CustomerManager customerManager;
    private List<RentalRecord> rentalRecords;

    public CarRentalSystem() {
        carInventory = new CarInventory();
        customerManager = new CustomerManager();
        rentalRecords = new ArrayList<>();
    }

    public void addCar(Car car) {
        carInventory.addCar(car);
    }

    public void addCustomer(Customer customer) {
        customerManager.addCustomer(customer);
    }

    public void rentCar(String customerId, String carId) {
        Customer customer = customerManager.findCustomerById(customerId);
        Car car = carInventory.findCarById(carId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        if (car == null || !car.isAvailable()) {
            System.out.println("Car not available.");
            return;
        }

        car.rentCar();
        rentalRecords.add(new RentalRecord(customerId, carId));
        System.out.println("Car rented successfully!");
    }

    public void returnCar(String carId) {
        Car car = carInventory.findCarById(carId);
        if (car != null && !car.isAvailable()) {
            car.returnCar();
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("Invalid Car ID or Car is already returned.");
        }
    }

    public void displayAllCars() {
        carInventory.displayAllCars();
    }

    public void displayAvailableCars() {
        List<Car> availableCars = carInventory.getAvailableCars();
        if (availableCars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : availableCars) {
                System.out.println(car);
            }
        }
    }

    public void displayRentalRecords() {
        for (RentalRecord record : rentalRecords) {
            System.out.println(record);
        }
    }


    public CarInventory getCarInventory() {
        return carInventory;
    }
}
