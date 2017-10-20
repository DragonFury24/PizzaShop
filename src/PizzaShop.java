/**
 *
 */

import java.util.Scanner;

/**
 * The PizzaShop class runs an application to allow the user to order one or more pizzas, and
 * calculate the total cost of the order
 *
 * @author kabaram
 */
public class PizzaShop {

    /**
     * Displays the toppings available for the pizza
     */
    public static void showToppings() {
        System.out.println("Available toppings include: \n"
                + "Sausage, Pepperoni, Meatball, Bacon, Ham, \n"
                + "ExtraCheese, Anchovy, Jalapeno, Artichoke, \n"
                + "Broccoli, Spinach, Garlic, Tomato, FreshMozz, \n"
                + "Pepper, Onion, Mushroom");
    }

    public static void askSize() {
        System.out.println("What size pizza would you like?");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
    }

    public static void askToppingsAndAdd(Pizza pizza, Scanner keyType) {
        System.out.println("Would you like to add a topping?");
        System.out.println("Y or N");
        if (keyType.next().equalsIgnoreCase("N")) {
            return;
        }
        System.out.println("What topping would you like?");
        showToppings();
        while (true) {
            pizza.addTopping(keyType.next());
            System.out.println("Would you like another topping?");
            System.out.println("Y or N");
            if (keyType.next().equalsIgnoreCase("y")) {
                System.out.println("What topping would you like?");
                continue;
            }
            keyType.next();
            break;
        }
    }

    public static void displayGreeting() {
        System.out.println("Greetings. May the eternal bubbling of artisan cheese engulf you as");
        System.out.println("you bed yourself in thick juicy pepperoni.");
        System.out.println("What magnitude of taste will you be indulging in today?");
    }

    /**
     * Models placing an order for pizza where customer can select their pizza size and toppings
     */
    public static PizzaManager callPizzaShop() {
        Scanner keyType = new Scanner(System.in);
        PizzaManager pizzaManager = new PizzaManager();
        pizzaManager.add(new Pizza());
        pizzaManager.toArray();
        double totalCost = 0;
        displayGreeting();
        while (true) {
            askSize();
            Pizza pizza = new Pizza(keyType.nextInt());
            askToppingsAndAdd(pizza, keyType);
            totalCost += pizza.getCost();
            System.out.println("Would you like to experience the beauty of the next flavor town?");
            System.out.println("Y or N");
            if (keyType.next().equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Thank you for your order.");
        System.out.println("Your total comes to $" + totalCost);
        return pizzaManager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(callPizzaShop());
    }
}
