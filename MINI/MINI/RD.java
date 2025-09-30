package MINI;

public class RD extends MenuItem {

    public RD(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice(boolean isSpecial) {
        if (isSpecial) {
            return super.getPrice() + 10.0;
        } else {
            return super.getPrice();
        }
    }
}