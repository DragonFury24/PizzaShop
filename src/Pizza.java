/**
 *
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Pizza class builds a Pizza to the customer's order. The customer may
 * choose the size and topping(s) of their pizza.
 *
 * @author kabaram
 */
public class Pizza {
    // the toppings the customer has ordered
    private String toppings;
    // the cost of this Pizza
    private double cost;
    // the size of this Pizza
    private int size;
    private String[] availableToppings = {
            "sausage", "pepperoni", "meatball", "bacon", "ham",
            "extracheese", "extra cheese", "anchovy", "jalapeno",
            "artichoke", "broccoli", "spinach", "garlic", "tomato",
            "freshmozz", "fresh mozzarella", "pepper", "onion",
            "mushroom"};
    private ArrayList<String> topping = new ArrayList<>(Arrays.asList(availableToppings));
    /**
     * Creates a medium pizza
     */
    public Pizza() {
        this(2);
    }

    /**
     * Creates a pizza of a specified size
     * Precondition: 1 <= size <= 3
     *
     * @param s, the desired pizza size. 1 = small, 2 = medium, 3 = large
     */
    public Pizza(int s) {
        size = s;
        cost = size == 1 ? 12 : size == 2 ? 14 : 18;
        toppings = "CHEESE";
    }

    /**
     * @return the toppings on this pizza
     */
    public String getToppings() {
        return toppings;
    }

    /**
     * @return the cost of this pizza
     */
    public double getCost() {
        return cost;
    }

    public int getSize() {
        return size;
    }

    private boolean hasTopping(String topping) {
        return toppings.contains(topping);
    }

    /**
     * Adds the specified topping to the topping list
     * Added cost depends on the size of the pizza
     *
     * @param topping the topping to be aded
     */
    public void addTopping(String topping) {
        toppings = toppings + ", AND " + topping.toUpperCase();
        cost = cost + (size == 1 ? 1.5 : size == 2 ? 2 : 3);
    }

    private boolean toppingExists(String topping) {
        return topping.contains(topping.toLowerCase());
    }

    /**
     * @return a String representation of this Pizza in the format:
     * <toppings> Pizza, Cost $
     */
    public String toString() {
        return toppings + " Pizza, $" + cost;
    }
}
