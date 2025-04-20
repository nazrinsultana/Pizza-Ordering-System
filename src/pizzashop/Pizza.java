package pizzashop;

import java.util.ArrayList;

public abstract class Pizza implements Comparable<Pizza> {

    public static final int SMALL = 12;
    public static final int MEDIUM = 14;
    public static final int LARGE = 16;
    public static final int XLARGE = 18;

    protected double[] basePrices = {10.00, 12.00, 14.00, 16.00};
    protected double cost;
    protected int size;
    protected String type;
    protected ArrayList<String> toppings = new ArrayList<>();

    public Pizza() {
        this.type = "Pizza";
    }

    public Pizza(int size) {
        this.size = size;
        switch (size) {
            case SMALL -> cost = basePrices[0];
            case MEDIUM -> cost = basePrices[1];
            case LARGE -> cost = basePrices[2];
            case XLARGE -> cost = basePrices[3];
            default -> {
                System.out.println("Invalid size. Defaulting to medium.");
                this.size = MEDIUM;
                cost = basePrices[1];
            }
        }
    }

    public abstract void getToppings();

    public double getCost() {
        return cost;
    }

    public String getToppingsString() {
        return toppings.isEmpty() ? "No toppings" : String.join(", ", toppings);
    }

    public void printSummary(String customerName) {
        String toppingList = getToppingsString();
        System.out.println("\nOrder Summary:");
        System.out.println("Customer: " + customerName);
        System.out.println("Pizza Type: " + type);
        System.out.println("Pizza Size: " + size + "\"");
        System.out.println("Toppings: " + toppingList);
        System.out.printf("Total Cost: $%.2f%n", cost);

        DBHelper.insertOrder(customerName, type, size + "\"", toppingList, cost);
    }

    @Override
    public int compareTo(Pizza other) {
        return Integer.compare(this.size, other.size);
    }
}
