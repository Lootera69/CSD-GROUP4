CREATE DATABASE SupplyChainDB;
USE SupplyChainDB;

create table product (
product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity_in_stock INT NOT NULL
);

CREATE TABLE Supplier (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone_number VARCHAR(20),
    address TEXT
);

CREATE TABLE `Order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    supplier_id INT,
    order_date DATE,
    delivery_date DATE,
    status ENUM('placed', 'delivered', 'cancelled'),
    FOREIGN KEY (product_id) REFERENCES Product(product_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

INSERT INTO Product (product_id, name, description, price, quantity_in_stock)
VALUES
(1, 'Aspirin', 'Pain reliever', 10.99, 100),
(2, 'Ibuprofen', 'Anti-inflammatory', 12.49, 150),
(3, 'Paracetamol', 'Fever reducer', 8.99, 200);

INSERT INTO Supplier (supplier_id, name, email, phone_number, address)
VALUES
(1, 'HealthCorp', 'contact@healthcorp.com', '123-456-7890', '123 Health St, Wellness City'),
(2, 'MediSupply', 'info@medisupply.com', '987-654-3210', '456 Med Ave, Caretown'),
(3, 'PharmaPro', 'support@pharmapro.com', '555-666-7777', '789 Pharma Blvd, Medicity');

INSERT INTO `Order` (order_id, product_id, supplier_id, order_date, delivery_date, status)
VALUES
(1, 1, 1, '2024-08-01', '2024-08-05', 'placed'),
(2, 2, 2, '2024-08-10', '2024-08-15', 'delivered'),
(3, 3, 3, '2024-08-15', '2024-08-20', 'cancelled');
 