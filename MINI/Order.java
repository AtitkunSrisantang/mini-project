// Order.java
package MINI;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderedItems = new ArrayList<>();

    public void addItem(OrderItem item) {
        orderedItems.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : orderedItems) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        if (orderedItems.isEmpty()) {
            System.out.println("Your order is empty.");
        } else {
            System.out.println("--- Your Order ---");
            for (OrderItem item : orderedItems) {
                System.out.println("- " + item.getName() + " (" + item.getPrice() + " Baht)");
            }
            System.out.println("------------------");
            System.out.println("Total Price: " + getTotal() + " Baht");
        }
    }
}