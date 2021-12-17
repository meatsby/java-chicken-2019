package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<String, Integer> orders = new LinkedHashMap<>();

    public Table(final int number) {
        this.number = number;
        this.orders.put("1", 0);
        this.orders.put("2", 0);
        this.orders.put("3", 0);
        this.orders.put("4", 0);
        this.orders.put("5", 0);
        this.orders.put("6", 0);
        this.orders.put("21", 0);
        this.orders.put("22", 0);
    }

    public boolean canOrder(String menuNumber, int menuQuantity) {
        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            if (order.getKey().equals(menuNumber) && (order.getValue() + menuQuantity) < 100) {
                return true;
            }
        }
        return false;
    }

    public void addOrder(String menuNumber, int menuQuantity) {
        orders.replace(menuNumber, orders.get(menuNumber) + menuQuantity);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean hasOrder() {
        int totalOrder = 0;
        for (int order : orders.values()) {
            if (order != 0) {
                totalOrder += 1;
            }
        }
        return totalOrder != 0;
    }
}
