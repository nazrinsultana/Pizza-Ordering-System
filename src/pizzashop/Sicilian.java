package pizzashop;

import java.util.Scanner;

public class Sicilian extends Pizza {

    public Sicilian(int size) {
        super(size);
        this.type = "Sicilian";
    }

    @Override
    public void getToppings() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose toppings for Sicilian pizza (type 'done' to finish):");
        while (true) {
            System.out.print("Add topping: ");
            String topping = input.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            toppings.add(topping);
            cost += 2.00;
        }
    }
}
