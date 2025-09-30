package MINI;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderedItems = new ArrayList<>();

    public void addItem(OrderItem item) {
        orderedItems.add(item);
    }

    public boolean removeItem(int itemNumber) {
        int index = itemNumber - 1;

        if (index >= 0 && index < orderedItems.size()) {
            orderedItems.remove(index);
            return true;
        }
        return false;
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
                System.out.println((i + 1) + ". " + orderedItems.get(i).getName() + " (" + orderedItems.get(i).getPrice() + " Baht)");
            }
            System.out.println("------------------");
            System.out.println("Total Price: " + getTotal() + " Baht");
        }
    }
    
    public boolean isEmpty() {
        return orderedItems.isEmpty();
    }
}