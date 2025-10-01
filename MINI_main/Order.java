package MINI_main;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderedItems = new ArrayList<>();

    public void addItem(OrderItem item) {
        orderedItems.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < orderedItems.size()) {
            OrderItem removed = orderedItems.remove(index);
            System.out.println("Removed '" + removed.getName() + "' from your order.");
        } else {
            System.out.println("Invalid index. Cannot remove item.");
        }
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
            for (int i = 0; i < orderedItems.size(); i++) {
                OrderItem item = orderedItems.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " (" + item.getPrice() + " Baht)");
            }
            System.out.println("------------------");
            System.out.println("Total Price: " + getTotal() + " Baht");
        }
    }

    public List<OrderItem> getOrderedItems() {
        return orderedItems;
    }
}

