import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInventory {
    private List<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findCarById(String carId) {
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    public void displayAllCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available in inventory.");
        } else {
            System.out.println("All Cars:");
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    public void displayAvailableCars() {
        boolean hasAvailableCars = false;
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("Car ID: " + car.getId() + ", Make: " + car.getMake() + ", Model: " + car.getModel());
                hasAvailableCars = true;
            }
        }
        if (!hasAvailableCars) {
            System.out.println("No cars available for rent.");
        }
    }

    // Method to add a car  by taking user input
    public void addCarDynamically() {
        Scanner scanner = new Scanner(System.in);

        // Get car details from the user
        System.out.println("Enter Car ID:");
        String carId = scanner.nextLine();

        System.out.println("Enter Car Make:");
        String make = scanner.nextLine();

        System.out.println("Enter Car Model:");
        String model = scanner.nextLine();

        System.out.println("Is the car available (true/false)?");
        boolean available = Boolean.parseBoolean(scanner.nextLine());

        // Create a new Car object and add it to inventory
        Car newCar = new Car(carId, make, model, available);
        addCar(newCar);  // Use the existing addCar method to add the new car

        System.out.println("Car added successfully!");
    }
}
