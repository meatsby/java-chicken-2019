package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<String, String> orders = new LinkedHashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public void addOrder(String menuNumber, String menuQuantity) {
        if (orders.containsKey(menuNumber)) {
            orders.replace(menuNumber, orders.get(menuNumber) + menuQuantity);
            return;
        }
        orders.put(menuNumber, menuQuantity);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
