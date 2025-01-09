# Supply Chain Management System

This project is a simple Java-based Supply Chain Management System designed to manage products, suppliers, and orders. The application interacts with a MySQL database to store and retrieve data. It provides a console-based interface for performing CRUD (Create, Read, Update, Delete) operations on the supply chain entities.

**Note:** This project is part of a case study assigned by my organization. Candidate ID: 30743779.


## Features

- **Manage Products**: Add, update, view, and delete products in the system.
- **Manage Suppliers**: Add, update, view, and delete suppliers in the system.
- **Manage Orders**: Place orders, view order details, update order information, and cancel orders.

## Table of Contents

- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Functionality](#functionality)
  - [Manage Products](#manage-products)
  - [Manage Suppliers](#manage-suppliers)
  - [Manage Orders](#manage-orders)
- [How to Run](#how-to-run)
  - [Prerequisites](#prerequisites)
  - [Setup Instructions](#setup-instructions)
  - [Running the Application](#running-the-application)
- [Error Handling](#error-handling)

## Project Structure

The project consists of the following Java classes:

- `DatabaseConnection.java`: Handles the connection to the MySQL database.
- `MainMenu.java`: Contains the main menu interface for interacting with the user and also for performing CRUD operations on products, suppliers, and orders.
- `InvalidOptionException.java`: Custom exception for handling invalid menu options.
- `DatabaseException.java`: Custom exception for handling database-related errors.

## Database Schema

The application uses a MySQL database named `SupplyChainDB` with the following tables:

- **Product**: Stores product information.
- **Supplier**: Stores supplier information.
- **Order**: Stores order information.

## Functionality

### Manage Products

- **Add Product**: Allows you to add a new product to the database by entering the product's name, description, price, and quantity in stock.
- **View Products**: Displays a list of all products in the database.
- **Update Product**: Update the details of an existing product.
- **Delete Product**: Remove a product from the database.

### Manage Suppliers

- **Add Supplier**: Allows you to add a new supplier by entering their name, email, phone number, and address.
- **View Suppliers**: Displays a list of all suppliers in the database.
- **Update Supplier**: Update the details of an existing supplier.
- **Delete Supplier**: Remove a supplier from the database.

### Manage Orders

- **Place Order**: Place a new order by specifying the product ID, supplier ID, and order details.
- **View Order by ID**: View the details of a specific order by entering its order ID.
- **View All Orders**: Display all orders in the system.
- **Update Order**: Update the product ID, supplier ID, and status of an existing order.
- **Cancel Order**: Cancel an existing order by setting its status to 'canceled'.

## How to Run

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed on your machine.
- **MySQL Server**: MySQL Server must be installed and running.
- **MySQL Connector/J**: Ensure that the MySQL JDBC driver (mysql-connector-j-x.x.x.jar) is downloaded.

### Setup Instructions

1. **Clone the Repository:**

    ```bash
    [cd supply-chain-management](https://github.com/Lootera69/Group-4-CaseStudy-30743779.git)
    ```

2. **Set Up the Database:**

    Open MySQL Workbench or any MySQL client. Create the `SupplyChainDB` database using the provided schema.

3. **Configure Database Connection:**

    Open `DatabaseConnection.java` and update the `DB_URL`, `DB_USER`, and `DB_PASSWORD` constants with your MySQL connection details.

4. **Compile the Project:**

    ```bash
    javac -cp "path/to/mysql-connector-j-x.x.x.jar" *.java
    ```

5. **Run the Application:**

    ```bash
    java -cp ".;path/to/mysql-connector-j-x.x.x.jar" MainMenu
    ```

### Running the Application

After running the `MainMenu` class, follow the console prompts to interact with the system:

- **Manage Products**: Choose Options 1-4 in the product menu.
- **Manage Suppliers**: Choose Options 1-4 in the supplier menu.
- **Manage Orders**: Choose Options 1-6 in the order menu.

## Error Handling

- **InvalidOptionException**: Thrown when the user selects an invalid option from the menu.
- **DatabaseException**: Thrown when there is an issue connecting to or interacting with the database.

test text