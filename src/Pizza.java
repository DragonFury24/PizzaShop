/**
 *
 */

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
    private String topping;
    // the cost of this Pizza
    private double cost;
    // the size of this Pizza
    private int size;
    //    private String[] availableToppings = {
//            "sausage", "pepperoni", "meatball", "bacon", "ham",
//            "extracheese", "extra cheese", "anchovy", "jalapeno",
//            "artichoke", "broccoli", "spinach", "garlic", "tomato",
//            "freshmozz", "fresh mozzarella", "pepper", "onion",
//            "mushroom"};
    private static final ArrayList<String> availableToppings = new ArrayList<>(Arrays.asList(
            "sausage", "pepperoni", "meatball", "bacon", "ham",
            "extracheese", "extra cheese", "anchovy", "jalapeno",
            "artichoke", "broccoli", "spinach", "garlic", "tomato",
            "freshmozz", "fresh mozzarella", "pepper", "onion",
            "mushroom"));

    private ArrayList<String> toppings = new ArrayList<String>();

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
        toppings.add("cheese");
    }

    public static void showAvailableToppings() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Available toppings include:");
        for (int i = 0; i < availableToppings.size(); i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.println(stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")).toString().trim());
                stringBuilder.setLength(0);
            }
            stringBuilder.append(StringUtils.capitalizeWords(availableToppings.get(i))).append(", ");
        }
    }

    /**
     * Adds the specified topping to the topping list
     * Added cost depends on the size of the pizza
     *
     * @param topping the topping to be aded
     */
    public void addTopping(String topping) {
        String temp = topping.toLowerCase();
        if (toppingExists(temp)) {
            expandAbbreviation(temp);
            if (hasTopping(temp))
                toppings.set(toppings.indexOf(temp), "extra " + toppings.get(toppings.indexOf(temp)));
            else
                toppings.add(temp);
        } else
            System.out.println("Not a valid topping choice.");
        cost = cost + (size == 1 ? 1.5 : size == 2 ? 2 : 3);
    }

    public void removeTopping(String topping) {
        String temp = topping.toLowerCase();
        if (toppingExists(temp)) {
            expandAbbreviation(temp);
            if (hasTopping(temp)) {
                toppings.remove(toppings.indexOf(temp));
                cost = cost - (size == 1 ? 1.5 : size == 2 ? 2 : 3);
            }
        }
    }

    /**
     * @return the toppings on this pizza
     */
    public String getToppings() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < toppings.size() - 1; i++) {
            toppings.set(i, toppings.get(i).toLowerCase());
            toppings.set(i, StringUtils.capitalizeWords(toppings.get(i)));
            stringBuilder.append(toppings.get(i)).append(", ");
        }
        stringBuilder.append("and ").append(StringUtils.capitalizeWords(toppings.get(toppings.size() - 1)));
        return stringBuilder.toString();
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
        for (String t : toppings)
            if (t.contains(topping))
                return true;
        return false;
    }

    private boolean toppingExists(String topping) {
        return availableToppings.contains(topping.toLowerCase());
    }

    private String expandAbbreviation(String s) {
        if (s.equalsIgnoreCase("freshmozz"))
            s = "fresh mozzarella";
        else if (s.equalsIgnoreCase("extracheese"))
            s = "extra cheese";
        return s;
    }
    /**
     * @return a String representation of this Pizza in the format:
     * <toppings> Pizza, Cost $
     */
    public String toString() {
        return getToppings() + " Pizza, $" + cost;
    }
}
