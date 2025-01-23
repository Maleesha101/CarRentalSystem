import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    // Display the menu options
    public abstract void displayMenu();

    // Handle the user's choice
    public abstract void handleMenuOption(int option, CarRentalSystem system);

    // Get user input
    protected int getUserInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            return scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number between 1 and 9.");
        }

        return 0;
    }

}
