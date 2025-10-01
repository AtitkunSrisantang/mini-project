// OrderItem.java
package MINI_main;

public class OrderItem {
    private MenuItem menuItem;
    private boolean isSpecial;

    public OrderItem(MenuItem menuItem, boolean isSpecial) {
        this.menuItem = menuItem;
        this.isSpecial = isSpecial;
    }

    public String getName() {
        return menuItem.getName() + (isSpecial ? " (Special)" : "");
    }

    public double getPrice() {
        // --- Polymorphism is here! ---
        // We call the same method, calculatePrice(), but it behaves differently
        // depending on whether the menuItem is a RiceDish or a Beverage.
        return menuItem.calculatePrice(isSpecial);
    }

}
