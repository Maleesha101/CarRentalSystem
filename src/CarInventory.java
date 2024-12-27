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

    public void addCarDynamically() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Car ID: ");
        String id = scanner.next();
        System.out.print("Enter Car Brand: ");
        String brand = scanner.next();
        System.out.print("Enter Car Model: ");
        String model = scanner.next();

        Car newCar = new Car(id, brand, model);
        cars.add(newCar);
        System.out.println("Car added successfully!");
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
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
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
