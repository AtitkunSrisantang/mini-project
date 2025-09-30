// RiceDish.java
package MINI;

// Use 'extends' to inherit from MenuItem
public class RD extends MenuItem {

    public RD(String name, double price) {
        // Call the constructor of the parent class (MenuItem)
        super(name, price);
    }

    // Implement the method required by the parent class
    @Override
    public double calculatePrice(boolean isSpecial) {
        // For rice dishes, add 10 Baht if special
        if (isSpecial) {
            return super.getPrice() + 10.0;
        } else {
            return super.getPrice();
        }
    }
}