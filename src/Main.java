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
        system.loadAllData(); //load saved data from files

        //Display banner
        while (true) {
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

            //Greeting
            checkTime();

            //Menu option
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Customer Menu");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (mainChoice) {
                    case 1:
                        System.out.print("Enter Customer ID: ");
                        String customerId = scanner.nextLine();

                        if (system.isValidCustomerId(customerId)) {
                            System.out.println("Welcome Back!!");
                            CustomerMenu customerMenu = new CustomerMenu(customerId);
                            customerMenu.runMenu(system);
                        } else {
                            System.out.println("Invalid Customer ID. Access Denied.");

                        }
                        break;

                    case 2:
                        StaffMenu staffMenu = new StaffMenu();
                        staffMenu.runMenu(system);
                        break;

                    case 3:
                        System.out.println("Exiting the system. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            }
        }
    }
    static void checkTime() {

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
