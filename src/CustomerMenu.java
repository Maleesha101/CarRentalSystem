import java.awt.im.InputMethodRequests;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerMenu extends Menu {
    private final String customerId;

    public CustomerMenu(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- Customer Menu ---");
        System.out.println("1. View Available Cars");
        System.out.println("2. Rent a Car");
        System.out.println("3. Return a Car");
        System.out.println("4. Exit to Main Menu");
    }

    @Override
    public void handleMenuOption(int option, CarRentalSystem system) {
        Scanner scanner = new Scanner(System.in);

        try {
            switch (option) {
                case 1:
                    // View Available Cars
                    system.displayAvailableCars();
                    break;

                case 2:
                    // Rent a Car
                    System.out.print("Enter Car ID: ");
                    String rentCarId = scanner.nextLine();
                    system.rentCar(customerId, rentCarId, "rentalRecords.txt");
                    break;

                case 3:
                    // Return a Car
                    System.out.print("Enter Car ID to Return: ");
                    String returnCarId = scanner.nextLine();
                    system.returnCar(returnCarId, customerId, "rentalRecords.txt");
                    break;

                case 4:
                    // Exit to Main Menu
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    // Handle Invalid Input
                    System.out.println("Invalid choice. Please try again.");
            }
        }   catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number between 1 and 9.");
            scanner.nextLine();

        }
    }

    // Run the Customer Menu Loop
    public void runMenu(CarRentalSystem system) {
        int customerChoice = 0;
        do {
            try {
                displayMenu();
                customerChoice = getUserInput();
                handleMenuOption(customerChoice, system);
            } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");

            }
        } while (customerChoice != 4); // Exit on option 4
    }
}
