import java.util.ArrayList;

public class PizzaManager {
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    public Pizza[] pizzasToArray() {
        return pizzas.toArray(new Pizza[0]);
    }

    public void add(Pizza p) {
        pizzas.add(p);
    }

    public void remove(int index) {
        pizzas.remove(index);
    }

    public void displayPizzas() {
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println(i + ". " + pizzas.get(i).toString());
        }
    }

    public Pizza get(int index) {
        return pizzas.get(index);
    }

    public double totalCost() {
        double cost = 0;
        for (Pizza pizza : pizzas) {
            cost += pizza.getCost();
        }
        return cost;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pizza pizza : pizzas) {
            stringBuilder.append(pizza).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
