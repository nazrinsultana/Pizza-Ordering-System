# Pizza Ordering System

A simple command-line Java application for ordering pizzas, viewing and managing orders.

## Features

- Create new pizza orders
- View existing orders
- Delete an order by its ID
- Persist orders using MySQL (JDBC)

## Prerequisites

- Java 8 or higher
- MySQL server (if using database persistence)
- MySQL Connector/J (`lib/mysql-connector-j-9.3.0.jar`)

## Project Structure
```
Pizza-Ordering-System/
├── lib/
│   └── mysql-connector-j-9.3.0.jar   # JDBC driver for MySQL
├── src/
│   └── pizzashop/                    # Java source files
│       ├── PizzaShop.java            # Main application
│       ├── Order.java                # Order model
│       ├── OrderManager.java         # Business logic for orders
│       └── DBConnection.java         # Database connection helper
└── bin/                              # Compiled .class files
```

## Configuration

1. Ensure `lib/mysql-connector-j-9.3.0.jar` is present in the `lib/` folder.
2. Open `src/pizzashop/DBConnection.java` and update the connection details:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/pizzadb";
   private static final String USER = "root";
   private static final String PASS = "password";
   ```
3. (Optional) Create the `pizzadb` database in MySQL:
   ```sql
   CREATE DATABASE pizzadb;
   USE pizzadb;
   CREATE TABLE orders (
     id INT AUTO_INCREMENT PRIMARY KEY,
     pizza_type VARCHAR(50),
     quantity INT,
     price DECIMAL(5,2)
   );
   ```

## Compilation

From the project root directory:

```bash
# Create bin folder if it doesn't exist
mkdir bin 2>nul

# Compile all Java sources
javac -cp "lib/*" -d bin src\pizzashop\*.java
```

## Running the Application

- **Windows**
  ```bash
  java -cp "bin;lib/*" pizzashop.PizzaShop
  ```

- **Linux/macOS**
  ```bash
  java -cp "bin:lib/*" pizzashop.PizzaShop
  ```

## Usage

1. Launch the application using the command above.
2. Follow the on-screen menu:
   1. **Create Order**: Enter pizza type, quantity, and price.
   2. **View Orders**: Displays a list of all orders (ID, type, quantity, price).
   3. **Delete Order**: Enter the Order ID to delete.
   4. **Exit**: Close the application.

## Contributing

1. Fork the repository.
2. Create a feature branch:
   ```bash
git checkout -b feature/YourFeature
```
3. Commit your changes:
   ```bash
git commit -m "Add new feature"
```
4. Push and open a Pull Request.

## License

This project is licensed under the MIT License. See `LICENSE` for details.
