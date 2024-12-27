import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Show All Cars");
            System.out.println("2. Show Available Cars");
            System.out.println("3. Add Customer");
            System.out.println("4. Show Registered Customers");
            System.out.println("5. Rent a Car");
            System.out.println("6. Return a Car");
            System.out.println("7. Show Rental Records");
            System.out.println("8. Add New Car");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.displayAllCars();
                    break;
                case 2:
                    system.displayAvailableCars();
                    break;
                case 3:
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Identity Number: ");
                    String identityNumber = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    String generatedId = system.addCustomer(customerName, identityNumber, phoneNumber);
                    System.out.println("Customer added successfully! Assigned ID: " + generatedId);
                    break;
                case 4:
                    system.displayRegisteredCustomers();
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    String rentCustomerId = scanner.nextLine();
                    System.out.print("Enter Car ID: ");
                    String rentCarId = scanner.nextLine();
                    system.rentCar(rentCustomerId, rentCarId);
                    break;
                case 6:
                    System.out.print("Enter Car ID to Return: ");
                    String returnCarId = scanner.nextLine();
                    system.returnCar(returnCarId);
                    break;
                case 7:
                    system.displayRentalRecords();
                    break;
                case 8:
                    system.getCarInventory().addCarDynamically();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
