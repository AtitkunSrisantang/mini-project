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

    // ใช้คำนวนราคาของอาหารรวมกันและพิเศษไหม
    // เป็น Subclass
    public abstract double calculatePrice(boolean isSpecial);

}
