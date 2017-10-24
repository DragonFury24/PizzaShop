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
     * @param args
     */
    public static void main(String[] args) {
        callPizzaShop();
    }

    /**
     * Models placing an order for pizza where customer can select their pizza size and toppings
     */
    public static void callPizzaShop() {
        Scanner keyType = new Scanner(System.in);
        PizzaManager pizzaManager = new PizzaManager();
        displayGreeting();

        do {
            askSize();
            pizzaManager.add(newPizza());
            System.out.println("Would you like to experience the beauty of the next flavor town?");
            System.out.println("Y or N");
        } while(isYes(keyType.nextLine()));

        System.out.println("You ordered:");
        pizzaManager.displayPizzas();
        System.out.println("Your total comes to $" + pizzaManager.totalCost());
        System.out.println("Would you like to modify your order?");
        if (isYes(keyType.nextLine())) {
            modifyOrder(pizzaManager);
        }

        System.out.println("Thank you for your order.");
        System.out.println("You ordered:");
        pizzaManager.displayPizzas();
        System.out.println("Your total comes to $" + pizzaManager.totalCost());
    }

    public static Pizza newPizza() {
        Scanner keyType = new Scanner(System.in);
        Pizza pizza = new Pizza(keyType.nextInt());
        keyType.nextLine();
        askToppingsAndAdd(pizza, keyType);
        return pizza;
    }

//    /**
//     * Displays the toppings available for the pizza
//     */
//    public static void showToppings() {
//        System.out.println("Available toppings include: \n"
//                + "Sausage, Pepperoni, Meatball, Bacon, Ham, \n"
//                + "ExtraCheese, Anchovy, Jalapeno, Artichoke, \n"
//                + "Broccoli, Spinach, Garlic, Tomato, FreshMozz, \n"
//                + "Pepper, Onion, Mushroom");
//    }

    public static void askSize() {
        System.out.println("What size pizza would you like?");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
    }

    public static void askToppingsAndAdd(Pizza pizza, Scanner keyType) {
        System.out.println("Would you like to add a topping?");
        System.out.println("Y or N");
        if (isNo(keyType.nextLine())) {
            return;
        }

        do {
            System.out.println("What topping would you like?");
            Pizza.showAvailableToppings();
            pizza.addTopping(keyType.nextLine());
            System.out.println("Would you like another topping?");
            System.out.println("Y or N");
        } while (isYes(keyType.nextLine()));
    }

    public static void askToppingsAndRemove(Pizza pizza, Scanner keyType) {
        System.out.println("Do you want to remove a topping");
        System.out.println("Y or N");
        if (isNo(keyType.nextLine())) {
            return;
        }

        do {
            System.out.println("Which topping would you like to remove?");
            Pizza.showAvailableToppings();
            pizza.removeTopping(keyType.nextLine());
            System.out.println("Do you want to remove another topping");
            System.out.println("Y or N");
        } while (isYes(keyType.nextLine()));
    }

    public static boolean isYes(String s) {
        return s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes");
    }

    public static boolean isNo(String s) {
        return s.equalsIgnoreCase("n") || s.equalsIgnoreCase("no");
    }

    public static void displayGreeting() {
        System.out.println("Greetings. May the eternal bubbling of artisan cheese engulf you as");
        System.out.println("you bed yourself in thick juicy pepperoni.");
        System.out.println("What magnitude of taste will you be indulging in today?");
    }

    public static void modifyOrder(PizzaManager pizzaManager) {
        Scanner keyType = new Scanner(System.in);
        int index = 0;
        do {
            System.out.println("What action would you like to take?");
            System.out.println("1. Remove a pizza.");
            System.out.println("2. Modify toppings");
            switch(keyType.nextInt()) {
                default:
                    keyType.nextLine();
                case 1:
                    pizzaManager.displayPizzas();
                    System.out.println("Which pizza would you like to remove?");
                    pizzaManager.remove(keyType.nextInt());
                    keyType.nextLine();
                case 2:
                    pizzaManager.displayPizzas();
                    System.out.println("Which pizza do you want to modify?");
                    index = keyType.nextInt();
                    keyType.nextLine();
                    askToppingsAndAdd(pizzaManager.get(index), keyType);
                    askToppingsAndRemove(pizzaManager.get(index), keyType);
                    break;
            }

            System.out.println("Would you like to make another modification?");
        } while(!isNo(keyType.nextLine()));
    }

}
