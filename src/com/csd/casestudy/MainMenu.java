package com.csd.casestudy;

import java.util.Scanner;

// Custom exception for invalid menu options
class InvalidOptionException extends Exception {
    public InvalidOptionException(String message) {
        super(message);
    }
}

public class MainMenu {
    // Remove the duplicate declaration of the 'scanner' field
    private static final DatabaseConnection dbOps = new DatabaseConnection();

    public static void main(String[] args) {
        while (true) {
            try {
                displayMainMenu();
            } catch (InvalidOptionException | DatabaseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Display the main menu
    private static void displayMainMenu() throws InvalidOptionException, DatabaseException {
        System.out.println("\n--- Supply Chain Management System ---");
        System.out.println("1. Manage Products");
        System.out.println("2. Manage Suppliers");
        System.out.println("3. Manage Orders");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        int option = getIntInput();

        switch (option) {
            case 1:
                manageProducts();
                break;
            case 2:
                manageSuppliers();
                break;
            case 3:
                manageOrders();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                throw new InvalidOptionException("Invalid option. Please try again.");
        }
    }

    // Manage Products Submenu
    private static void manageProducts() throws InvalidOptionException, DatabaseException {
        while (true) {
            System.out.println("\n--- Manage Products ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = getIntInput();

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProductById();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    return; // Return to main menu
                default:
                    throw new InvalidOptionException("Invalid option. Please try again.");
            }
        }
    }

    // Add a new product
    private static void addProduct() throws InvalidOptionException {
        try {
            System.out.print("Enter product ID: ");
            int productId = getIntInput();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = getIntInput();

            System.out.print("Enter quantity in stock: ");
            int quantityInStock = getIntInput();

            dbOps.addProduct(productId, name, description, price, quantityInStock);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // View product by ID
    private static void viewProductById() throws InvalidOptionException {
        try {
            System.out.print("Enter product ID: ");
            int productId = getIntInput();

            dbOps.viewProduct(productId);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // View all products
    private static void viewAllProducts() {
        try {
            dbOps.viewAllProducts();
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update product information
    private static void updateProduct() throws InvalidOptionException {
        try {
            System.out.print("Enter product ID to update: ");
            int productId = getIntInput();

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new description: ");
            String description = scanner.nextLine();

            System.out.print("Enter new price: ");
            double price = getIntInput();

            System.out.print("Enter new quantity in stock: ");
            int quantityInStock = getIntInput();

            dbOps.updateProduct(productId, name, description, price, quantityInStock);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete a product
    private static void deleteProduct() throws InvalidOptionException {
        try {
            System.out.print("Enter product ID to delete: ");
            int productId = getIntInput();

            dbOps.deleteProduct(productId);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Manage Suppliers Submenu
    private static void manageSuppliers() throws InvalidOptionException, DatabaseException {
        while (true) {
            System.out.println("\n--- Manage Suppliers ---");
            System.out.println("1. Add Supplier");
            System.out.println("2. View Supplier by ID");
            System.out.println("3. View All Suppliers");
            System.out.println("4. Update Supplier");
            System.out.println("5. Delete Supplier");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = getIntInput();

            switch (option) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    viewSupplierById();
                    break;
                case 3:
                    viewAllSuppliers();
                    break;
                case 4:
                    updateSupplier();
                    break;
                case 5:
                    deleteSupplier();
                    break;
                case 6:
                    return; // Return to main menu
                default:
                    throw new InvalidOptionException("Invalid option. Please try again.");
            }
        }
    }

    // Add a new supplier
    private static void addSupplier() throws InvalidOptionException {
        try {
            System.out.print("Enter supplier ID: ");
            int supplierId = getIntInput();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            dbOps.addSupplier(supplierId, name, email, phoneNumber, address);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // View supplier by ID
    private static void viewSupplierById() throws InvalidOptionException {
        try {
            System.out.print("Enter supplier ID: ");
            int supplierId = getIntInput();

            dbOps.viewSupplier(supplierId);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // View all suppliers
    private static void viewAllSuppliers() {
        try {
            dbOps.viewAllSuppliers();
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update supplier information
    private static void updateSupplier() throws InvalidOptionException {
        try {
            System.out.print("Enter supplier ID to update: ");
            int supplierId = getIntInput();

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter new address: ");
            String address = scanner.nextLine();

            dbOps.updateSupplier(supplierId, name, email, phoneNumber, address);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete a supplier
    private static void deleteSupplier() throws InvalidOptionException {
        try {
            System.out.print("Enter supplier ID to delete: ");
            int supplierId = getIntInput();

            dbOps.deleteSupplier(supplierId);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // Manage Orders Submenu
    private static void manageOrders() throws InvalidOptionException, DatabaseException {
        while (true) {
            System.out.println("\n--- Manage Orders ---");
            System.out.println("1. Place Order");
            System.out.println("2. View Order by ID");
            System.out.println("3. View All Orders");
            System.out.println("4. Update Order");
            System.out.println("5. Cancel Order");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int option = getIntInput();

            switch (option) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    viewOrderById();
                    break;
                case 3:
                    viewAllOrders();
                    break;
                case 4:
                    updateOrder();
                    break;
                case 5:
                    cancelOrder();
                    break;
                case 6:
                    return; // Return to main menu
                default:
                    throw new InvalidOptionException("Invalid option. Please try again.");
            }
        }
    }

        // Place a new order
        private static void placeOrder() throws InvalidOptionException {
            try {
                System.out.print("Enter order ID: ");
                int orderId = getIntInput();
    
                System.out.print("Enter product ID: ");
                int productId = getIntInput();
    
                System.out.print("Enter supplier ID: ");
                int supplierId = getIntInput();
    
                dbOps.placeOrder(orderId, productId, supplierId);
            } catch (DatabaseException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // View order by ID
        private static void viewOrderById() throws InvalidOptionException {
            try {
                System.out.print("Enter order ID: ");
                int orderId = getIntInput();
    
                dbOps.viewOrder(orderId);
            } catch (DatabaseException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // View all orders
        private static void viewAllOrders() {
            try {
                dbOps.viewAllOrders();
            } catch (DatabaseException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Update order information
        private static void updateOrder() throws InvalidOptionException {
            try {
                System.out.print("Enter order ID to update: ");
                int orderId = getIntInput();
    
                System.out.print("Enter new product ID: ");
                int productId = getIntInput();
    
                System.out.print("Enter new supplier ID: ");
                int supplierId = getIntInput();
    
                System.out.print("Enter new status (e.g., placed, delivered, cancelled): ");
                String status = scanner.nextLine();
    
                dbOps.updateOrder(orderId, productId, supplierId, status);
            } catch (DatabaseException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Cancel an order
        private static void cancelOrder() throws InvalidOptionException {
            try {
                System.out.print("Enter order ID to cancel: ");
                int orderId = getIntInput();
    
                dbOps.cancelOrder(orderId);
            } catch (DatabaseException e) {
                System.out.println(e.getMessage());
            }
        }
    
        // Helper method to safely get integer input
        private static int getIntInput() throws InvalidOptionException {
            while (true) {
                String input = scanner.nextLine();
                try {
                    return Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a valid integer: ");
                }
            }
        }
    
        // Scanner instance (if not already defined in your class)
        private static final Scanner scanner = new Scanner(System.in);
    }