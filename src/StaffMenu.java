import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffMenu extends Menu {
    @Override
    public void displayMenu() {
        System.out.println("\n--- Staff Menu ---");
        System.out.println("1. Show All Cars");
        System.out.println("2. Show Available Cars");
        System.out.println("3. Add Customer");
        System.out.println("4. Show Registered Customers");
        System.out.println("5. Rent a Car");
        System.out.println("6. Return a Car");
        System.out.println("7. Show Rental Records");
        System.out.println("8. Add New Car");
        System.out.println("9. Add Staff");
        System.out.println("10. Show Registered Staff");
        System.out.println("11. Exit");
    }

    @Override
    public void handleMenuOption(int option, CarRentalSystem system) {
        Scanner scanner = new Scanner(System.in);

        try {
            switch (option) {
                case 1:
                    //Show all cars
                    system.displayAllCars();
                    break;

                case 2:
                    //Show available cars
                    system.displayAvailableCars();
                    break;

                case 3:
                    //Add Customers
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
                    //Display customers
                    system.displayRegisteredCustomers();
                    break;

                case 5:
                    //Rent a car
                    System.out.print("Enter Customer ID: ");
                    String rentCustomerId = scanner.nextLine();
                    System.out.print("Enter Car ID: ");
                    String rentCarId = scanner.nextLine();
                    system.rentCar(rentCustomerId, rentCarId, "rentalRecords.txt");
                    break;

                case 6:
                    // Return a car
                    System.out.print("Enter Customer ID: ");
                    String returnCustomerId = scanner.nextLine();
                    System.out.print("Enter Car ID to Return: ");
                    String returnCarId = scanner.nextLine();
                    system.returnCar(returnCarId, returnCustomerId, "rentalRecords.txt");
                    break;

                case 7:
                    //Display rental records
                    system.displayRentalRecords();
                    break;

                case 8:
                    //Add car to inventory
                    System.out.print("Enter Car ID: ");
                    String carId = scanner.nextLine();
                    System.out.print("What is the Make of the Car: ");
                    String make = scanner.nextLine();
                    System.out.print("What is the Model of the Car: ");
                    String model = scanner.nextLine();
                    system.addCar(carId, make, model);
                    CarInventory.saveCarsToFile("cars.txt");
                    break;

                case 9:
                    //Add staff member
                    System.out.print("Enter Staff Name: ");
                    String staffName = scanner.nextLine();
                    System.out.print("Enter Identity Number: ");
                    String staffIdentity = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String staffPhone = scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    system.addStaff(staffName, staffIdentity, staffPhone, role, salary);
                    break;

                case 10:
                    //Display staff
                    system.displayRegisteredStaff();
                    break;

                case 11:
                    //Exit method
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 9.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Run the Staff Menu Loop
    public void runMenu(CarRentalSystem system) {
        int staffChoice;
        do {
            displayMenu();
            staffChoice = getUserInput();
            handleMenuOption(staffChoice, system);
        } while (staffChoice != 11);
    }
}
