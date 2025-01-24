import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarInventory {
    private static List<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    //Method to search car by their ID
    public static Car findCarById(String carId) {
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                return car;
            }
        }
        return null;
    }
    public void displayAvailableCars() {
        List<Car> cars = getCarList();
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
    //Method to get saved data form file
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

    //To add car to inventory
    public void addCarDynamically(String id, String make, String model) {

        Car newCar = new Car(id, make, model, true);
        getCarList().add(newCar); // Add the car to the inventory
        System.out.println("Car added successfully!");
        System.out.println("Car Details: " + newCar);
    }
    //Store car object in array
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

}
