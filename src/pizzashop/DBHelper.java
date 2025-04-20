package pizzashop;

import java.sql.*;

public class DBHelper {

    public static final String URL = "jdbc:mysql://localhost:3306/pizzashop";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void insertOrder(String customerName, String type, String size, String toppings, double cost) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO orders (customer_name, pizza_type, pizza_size, toppings, total_cost) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerName);
            stmt.setString(2, type);
            stmt.setString(3, size);
            stmt.setString(4, toppings);
            stmt.setDouble(5, cost);
            stmt.executeUpdate();
            System.out.println("Order inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting order: " + e.getMessage());
        }
    }

    public static void showAllOrders() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM orders";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("---- Order List ----");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Type: %s | Size: %s | Toppings: %s | Cost: $%.2f%n",
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getString("pizza_type"),
                        rs.getString("pizza_size"),
                        rs.getString("toppings"),
                        rs.getDouble("total_cost"));
            }
            System.out.println("---------------------");
        } catch (SQLException e) {
            System.out.println("Error fetching orders: " + e.getMessage());
        }
    }

    public static void deleteOrder(int orderId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM orders WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order deleted successfully.");
            } else {
                System.out.println("No order found with that ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting order: " + e.getMessage());
        }
    }
}
