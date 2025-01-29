# Cargo Vehicle Rental System

## Overview

The Cargo Vehicle Rental System is a command line application designed to simplify and improve the management of vehicle rental operations. It offers features for both staff and customers to efficiently add new vehicles, register customers, rent vehicles, and process returns. The system is built using Object-Oriented Programming (OOP) principles, ensuring the code is organized, reusable, and easy to maintain.

## Features

- **Dynamic Inventory Management:** Staff can add, update, and track car availability in real-time.
- **Customer Management:** Facilitates customer registration and validation.
- **Rental Transactions:** Handles car rental and return processes, ensuring accurate record-keeping.
- **Data Persistence:** Automatically saves and loads data, ensuring continuity.

## Classes and Methods

### Car
- **Attributes:** id, make, model, available
- **Methods:** Getters and setters, toString()

### CarInventory
- **Attributes:** carList
- **Methods:** findCarById(), addCar(), saveCarsToFile(), loadCarsFromFile()

### Person (Abstract)
- **Attributes:** id, name, identityNumber, phoneNumber
- **Methods:** Getters and setters, toString()

### Customer (Child of Person)
- **Methods:** toString()

### CustomerManager
- **Attributes:** customerList, customerCount
- **Methods:** addCustomer(), rentCar(), returnCar(), saveCustomersToFile(), loadCustomersFromFile(), isCustomerRegistered()

### RentalRecord
- **Attributes:** customerId, carId
- **Methods:** Getters and setters, displayRentalRecords(), toString()

### Rental
- **Attributes:** customerId, carID
- **Methods:** Handles rental and return of cars, saves rental records to the file

### Staff (Child of Person)
- **Attributes:** role, salary
- **Methods:** Getters and setters, toString()

### StaffManager
- **Attributes:** staffList
- **Methods:** addStaff(), displayStaff(), generateStaffId()

### Menu (Abstract)
- **Methods:** displayMenu(), handleMenuOption(), getUserInput()

### CustomerMenu & StaffMenu (Subclasses of Menu)
- **Methods:** Overrides displayMenu() and handleMenuOption()

### CarRentalSystem
- **Attributes:** rentalRecord, carInventory, customerManager, staffManager
- **Methods:** Central point for managing operations, creates instances of other classes

### Main
- **Methods:** Get user choice and return them to that functionality

## Use Cases of OOP Concepts

1. **Encapsulation:** Used extensively with private fields and public getter and setter methods.
2. **Inheritance:** Staff and Customer inherit from the abstract class Person. StaffMenu and CustomerMenu inherit from the abstract class Menu.
3. **Polymorphism:** Demonstrated in the Menu class with overridden methods in StaffMenu and CustomerMenu.
4. **Abstraction:** Implemented in the Menu class with abstract methods displayMenu and handleMenuOption.

## User Guide

### 1. Overview of the System
The Car Rental System is a user-friendly application designed to manage car rentals efficiently. It provides separate functionalities for customers and staff.

### 2. Accessing the Main Menu
Upon launching the application, you will see the Main Menu with the following options:
1. Customer Menu
2. Staff Menu
3. Exit

### 3. Using the Staff Menu
The Staff Menu provides tools for staff members to manage the rental service. Available options include:
1. Show All Cars
2. Show Available Cars
3. Add Customer
4. Show Registered Customers
5. Rent a Car
6. Return a Car
7. Show Rental Records
8. Add New Car
9. Add Staff
10. Show Registered Staff
11. Exit

### 4. Using the Customer Menu
The Customer Menu provides features for customers to view and manage their rentals. Available options include:
1. View Available Cars
2. Rent a Car
3. Return a Car
4. Exit to Main Menu

### 5. Exiting the System
To exit the application, select the Exit option from either the Main Menu, Staff Menu, or Customer Menu.

## Conclusion

Thank you for using the Car Rental System! If you have questions or require assistance, please contact me.

---

For more details, please refer to the [project report](Cargo%20Vehicle%20Rental%20System.pdf).
