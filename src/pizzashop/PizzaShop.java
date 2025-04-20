package pizzashop;

import java.util.Scanner;

public class PizzaShop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Pizza Shop Menu ---");
            System.out.println("1. Place new order");
            System.out.println("2. Show all orders");
            System.out.println("3. Delete an order");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = input.nextInt();
            input.nextLine();  // consume newline

            switch (option) {
                case 1:
                    // Place new order
                    System.out.print("Enter customer name: ");
                    String customerName = input.nextLine();

                    System.out.println("Select pizza type:");
                    System.out.println("  1. Regular");
                    System.out.println("  2. Sicilian");
                    int choice = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter pizza size in inches (12, 14, 16, 18): ");
                    int sizeVal = input.nextInt();
                    input.nextLine();

                    Pizza pizza;
                    if (choice == 1) {
                        pizza = new Regular(sizeVal);
                    } else {
                        pizza = new Sicilian(sizeVal);
                    }
                    pizza.getToppings();
                    pizza.printSummary(customerName);
                    break;

                case 2:
                    // Show all orders
                    DBHelper.showAllOrders();
                    break;

                case 3:
                    // Delete an order
                    System.out.print("Enter Order ID to delete: ");
                    int id = input.nextInt();
                    input.nextLine();
                    DBHelper.deleteOrder(id);
                    break;

                case 4:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1–4.");
            }
        }

        input.close();
    }
}
