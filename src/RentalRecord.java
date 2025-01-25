import java.io.*;
import java.util.List;

public class RentalRecord {
    private String customerId;
    private String carId;
    private static List<RentalRecord> rentalRecords;

    public RentalRecord(String customerId, String carId) {
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
        return "Rental Record [Customer ID: " + customerId + ", Car ID: " + carId + "]";
    }
}
