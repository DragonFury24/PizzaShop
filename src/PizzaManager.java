import java.util.ArrayList;

public class PizzaManager extends ArrayList<Pizza> {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pizza pizza : this) {
            stringBuilder.append(pizza).append("/n");
        }
        return stringBuilder.toString();
    }
}
