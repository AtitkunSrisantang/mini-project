// MenuItem.java
package MINI;

public abstract class MenuItem {
    protected String name;
    protected double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method for price calculation.
    // Subclasses must implement this method.
    public abstract double calculatePrice(boolean isSpecial);
}