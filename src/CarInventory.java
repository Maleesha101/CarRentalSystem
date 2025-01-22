import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInventory {
    private static List<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public static Car findCarById(String carId) {
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
    public void loadCarsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String make = parts[1];
                String model = parts[2];
                boolean available = Boolean.parseBoolean(parts[3]);
                cars.add(new Car(id, make, model, available));
            }

        } catch (IOException e) {
            System.out.println("Error loading cars from file: " + e.getMessage());
        }
    }
    public List<Car> getCarList() {
        return cars;
    }
    public static void saveCarsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.write(car.getId() + "," + car.getMake() + "," + car.getModel() + "," + car.isAvailable());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving cars to file: " + e.getMessage());
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
