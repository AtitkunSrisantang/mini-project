// Beverage.java หรือ class ที่ใช้กับอาหารที่สั่งพิเศษไม่ได้เช่นพวกน้ำ
package MINI;

public class BV extends MenuItem {

    public BV(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice(boolean isSpecial) {
        // Beverages cannot be special, so always return the normal price.
        return super.getPrice();
    }

}
