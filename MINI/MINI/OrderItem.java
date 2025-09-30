package MINI;

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
        return menuItem.calculatePrice(isSpecial);
    }
}