import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        Scanner scanner = new Scanner(System.in);
        int choice;

        system.loadAllData();

        do {
            try {
                FileReader reader = new FileReader("art.txt");
                int data = reader.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = reader.read();
                }
                reader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("\n");
            checkTime();
            System.out.println();

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
            try {
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
                        CustomerManager.saveCustomersToFile("customers.txt");
                        break;
                    case 4:
                        system.displayRegisteredCustomers();
                        break;
                    case 5:
                        System.out.print("Enter Customer ID: ");
                        String rentCustomerId = scanner.nextLine();
                        System.out.print("Enter Car ID: ");
                        String rentCarId = scanner.nextLine();

                        system.rentCar(rentCustomerId, rentCarId, "rentalRecords.txt");
                        break;
                    case 6:
                        System.out.print("Enter Customer ID: ");
                        String returnCustomerId = scanner.nextLine();
                        System.out.print("Enter Car ID to Return: ");
                        String returnCarId = scanner.nextLine();

                        system.returnCar(returnCarId, returnCustomerId, "rentalRecords.txt");
                        break;
                    case 7:
                        system.displayRentalRecords();
                        break;
                    case 8:
                        System.out.print("Enter Car ID: ");
                        String id = scanner.nextLine();
                        System.out.print("What is the Make of Car: ");
                        String make = scanner.nextLine();
                        System.out.print("What is the Model of Car: ");
                        String model = scanner.nextLine();
                        system.addCarDynamically(id, make, model);
                        CarInventory.saveCarsToFile("cars.txt");
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                scanner.nextLine();
                choice = 0; // Reset choice to continue loop
            }
        } while (choice != 9);

        scanner.close();
    }

    static void checkTime(){

        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        if (hour >= 5 && hour < 12) {
            System.out.println("Good Morning!");
        } else if (hour >= 12 && hour < 17) {
            System.out.println("Good Afternoon!");
        } else
            System.out.println("Good Evening!");

    }
}
