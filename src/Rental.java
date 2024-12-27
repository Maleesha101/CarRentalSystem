public class Rental {
    private String customerId;
    private String carId;

    public Rental(String customerId, String carId) {
        this.customerId = customerId;
        this.carId = carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCarId() {
        return carId;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Car ID: " + carId;
    }
}
