package com.csd.casestudy;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Custom exception class for handling database-related errors
class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/supplychaindb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    // Load JDBC Driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver successfully loaded.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    // Establish a connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    // Product Operations

    // Add a new product
    public void addProduct(int productId, String name, String description, double price, int quantityInStock) throws DatabaseException {
        String query = "INSERT INTO Product (product_id, name, description, price, quantity_in_stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, productId);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setDouble(4, price);
            statement.setInt(5, quantityInStock);
            statement.executeUpdate();
            
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Error adding product: " + e.getMessage());
        }
    }

    // View product details by ID
    public void viewProduct(int productId) throws DatabaseException {
        String query = "SELECT * FROM Product WHERE product_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Product ID: " + resultSet.getInt("product_id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Description: " + resultSet.getString("description"));
                    System.out.println("Price: $" + resultSet.getDouble("price"));
                    System.out.println("Quantity in Stock: " + resultSet.getInt("quantity_in_stock"));
                } else {
                    System.out.println("No product found with ID: " + productId);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error viewing product: " + e.getMessage());
        }
    }

    // View all products
    public void viewAllProducts() throws DatabaseException {
        String query = "SELECT * FROM Product";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
             
            while (resultSet.next()) {
                System.out.println("----- Product Details -----");
                System.out.println("Product ID: " + resultSet.getInt("product_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Price: $" + resultSet.getDouble("price"));
                System.out.println("Quantity in Stock: " + resultSet.getInt("quantity_in_stock"));
                System.out.println("---------------------------\n");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error viewing all products: " + e.getMessage());
        }
    }

    // Update product information
    public void updateProduct(int productId, String name, String description, double price, int quantityInStock) throws DatabaseException {
        String query = "UPDATE Product SET name = ?, description = ?, price = ?, quantity_in_stock = ? WHERE product_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDouble(3, price);
            statement.setInt(4, quantityInStock);
            statement.setInt(5, productId);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with ID: " + productId);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error updating product: " + e.getMessage());
        }
    }

    // Delete a product
    public void deleteProduct(int productId) throws DatabaseException {
        String query = "DELETE FROM Product WHERE product_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, productId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with ID: " + productId);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting product: " + e.getMessage());
        }
    }

    // Supplier Operations

    // Add a new supplier
    public void addSupplier(int supplierId, String name, String email, String phoneNumber, String address) throws DatabaseException {
        String query = "INSERT INTO Supplier (supplier_id, name, email, phone_number, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, supplierId);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setString(5, address);
            statement.executeUpdate();
            
            System.out.println("Supplier added successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Error adding supplier: " + e.getMessage());
        }
    }

    // View supplier details by ID
    public void viewSupplier(int supplierId) throws DatabaseException {
        String query = "SELECT * FROM Supplier WHERE supplier_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, supplierId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Supplier ID: " + resultSet.getInt("supplier_id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Phone Number: " + resultSet.getString("phone_number"));
                    System.out.println("Address: " + resultSet.getString("address"));
                } else {
                    System.out.println("No supplier found with ID: " + supplierId);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error viewing supplier: " + e.getMessage());
        }
    }

    // View all suppliers
    public void viewAllSuppliers() throws DatabaseException {
        String query = "SELECT * FROM Supplier";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
             
            while (resultSet.next()) {
                System.out.println("----- Supplier Details -----");
                System.out.println("Supplier ID: " + resultSet.getInt("supplier_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone Number: " + resultSet.getString("phone_number"));
                System.out.println("Address: " + resultSet.getString("address"));
                System.out.println("-----------------------------\n");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error viewing all suppliers: " + e.getMessage());
        }
    }

    // Update supplier information
    public void updateSupplier(int supplierId, String name, String email, String phoneNumber, String address) throws DatabaseException {
        String query = "UPDATE Supplier SET name = ?, email = ?, phone_number = ?, address = ? WHERE supplier_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, address);
            statement.setInt(5, supplierId);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Supplier updated successfully.");
            } else {
                System.out.println("No supplier found with ID: " + supplierId);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error updating supplier: " + e.getMessage());
        }
    }

    // Delete a supplier
    public void deleteSupplier(int supplierId) throws DatabaseException {
        String query = "DELETE FROM Supplier WHERE supplier_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, supplierId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Supplier deleted successfully.");
            } else {
                System.out.println("No supplier found with ID: " + supplierId);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting supplier: " + e.getMessage());
        }
    }

    // Order Operations


    // Place a new order
    public void placeOrder(int orderId, int productId, int supplierId) throws DatabaseException {
        String query = "INSERT INTO `Order` (order_id, product_id, supplier_id, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, orderId);
            statement.setInt(2, productId);
            statement.setInt(3, supplierId);
            statement.setString(4, "placed"); // Default status
            
            statement.executeUpdate();
            System.out.println("Order placed successfully.");
        } catch (SQLException e) {
            throw new DatabaseException("Error placing order: " + e.getMessage());
        }
    }

    // View order details by ID
    public void viewOrder(int orderId) throws DatabaseException {
        String query = "SELECT * FROM `Order` WHERE order_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Order ID: " + resultSet.getInt("order_id"));
                    System.out.println("Product ID: " + resultSet.getInt("product_id"));
                    System.out.println("Supplier ID: " + resultSet.getInt("supplier_id"));
                    System.out.println("Order Date: " + resultSet.getDate("order_date"));
                    System.out.println("Delivery Date: " + resultSet.getDate("delivery_date"));
                    System.out.println("Status: " + resultSet.getString("status"));
                } else {
                    System.out.println("No order found with ID: " + orderId);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error viewing order: " + e.getMessage());
        }
    }

    // View all orders
    public void viewAllOrders() throws DatabaseException {
        String query = "SELECT * FROM `Order`";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
             
            while (resultSet.next()) {
                System.out.println("----- Order Details -----");
                System.out.println("Order ID: " + resultSet.getInt("order_id"));
                System.out.println("Product ID: " + resultSet.getInt("product_id"));
                System.out.println("Supplier ID: " + resultSet.getInt("supplier_id"));
                System.out.println("Order Date: " + resultSet.getDate("order_date"));
                System.out.println("Delivery Date: " + resultSet.getDate("delivery_date"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println("--------------------------\n");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error viewing all orders: " + e.getMessage());
        }
    }

    // Update order information
    public void updateOrder(int orderId, int productId, int supplierId, String status) throws DatabaseException {
        String query = "UPDATE `Order` SET product_id = ?, supplier_id = ?, status = ? WHERE order_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, productId);
            statement.setInt(2, supplierId);
            statement.setString(3, status);
            statement.setInt(4, orderId);
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order updated successfully.");
            } else {
                System.out.println("No order found with ID: " + orderId);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error updating order: " + e.getMessage());
        }
    }

    // Cancel an order
    public void cancelOrder(int orderId) throws DatabaseException {
        String query = "UPDATE `Order` SET status = 'cancelled' WHERE order_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             
            statement.setInt(1, orderId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order cancelled successfully.");
            } else {
                System.out.println("No order found with ID: " + orderId);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error cancelling order: " + e.getMessage());
        }
    }
}