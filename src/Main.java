import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        // Preload some data
        system.addCar(new Car("1", "Toyota", "Corolla"));
        system.addCar(new Car("2", "Honda", "Civic"));
        system.addCar(new Car("3", "Ford", "Focus"));

        system.addCustomer(new Customer("C1", "John Doe"));
        system.addCustomer(new Customer("C2", "Jane Smith"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n........ Car Rental System ........");
            System.out.println("1. Show All Cars");
            System.out.println("2. Show Available Cars");
            System.out.println("3. Add Customer");
            System.out.println("4. Rent a Car");
            System.out.println("5. Return a Car");
            System.out.println("6. Show Rental Records");
            System.out.println("7. Add New Car");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayAllCars();
                    break;
                case 2:
                    system.displayAvailableCars();
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.next();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.next();
                    system.addCustomer(new Customer(customerId, customerName));
                    System.out.println("Customer added successfully!");
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    String rentCustomerId = scanner.next();
                    System.out.print("Enter Car ID: ");
                    String rentCarId = scanner.next();
                    system.rentCar(rentCustomerId, rentCarId);
                    break;
                case 5:
                    System.out.print("Enter Car ID to Return: ");
                    String returnCarId = scanner.next();
                    system.returnCar(returnCarId);
                    break;
                case 6:
                    System.out.println("Rental Records:");
                    system.displayRentalRecords();
                    break;
                case 7:
                    system.getCarInventory().addCarDynamically();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
