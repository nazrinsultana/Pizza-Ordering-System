package pizzashop;

import java.util.Scanner;

public class Regular extends Pizza {

    public Regular(int size) {
        super(size);
        this.type = "Regular";
    }

    @Override
    public void getToppings() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose toppings for Regular pizza (type 'done' to finish):");
        while (true) {
            System.out.print("Add topping: ");
            String topping = input.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            toppings.add(topping);
            cost += 1.50;
        }
    }
}
