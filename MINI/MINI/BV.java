package MINI;

public class BV extends MenuItem {

    public BV(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice(boolean isSpecial) {
        return super.getPrice();
    }
}