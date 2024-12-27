public class Car {
    private String id;
    private String make;
    private String model;
    private boolean available;

    public Car(String id, String make, String model, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car ID: " + id + ", Make: " + make + ", Model: " + model + ", Available: " + (available ? "Yes" : "No");
    }
}
