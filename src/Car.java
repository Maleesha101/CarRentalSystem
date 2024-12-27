public class Car {
    private String id;
    private String brand;
    private String model;
    private boolean isAvailable;

    public Car(String id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rentCar() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Car ID: " + id + ", Brand: " + brand + ", Model: " + model + ", Available: " + isAvailable;
    }
}
