CREATE DATABASE IF NOT EXISTS pizzadb;
USE pizzadb;

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    pizza_type VARCHAR(50),
    pizza_size VARCHAR(10),
    toppings TEXT,
    total_cost DOUBLE
);
