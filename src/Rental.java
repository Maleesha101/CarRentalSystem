import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Rental {
    private String customerId;
    private String carId;
    private static List<RentalRecord> rentalRecords;

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
