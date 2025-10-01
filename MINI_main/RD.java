// RiceDish.java
package MINI_main;

// RD ใช้ขยายว่ามันคืออาหารที่สั่งพิเศษได้ไหมหรือสั่งพิเศษไม่ได้
public class RD extends MenuItem {

    public RD(String name, double price) {
        // Call the constructor of the parent class (MenuItem)
        super(name, price);
    }

    // Implement the method required by the parent class
    @Override
    public double calculatePrice(boolean isSpecial) {
        // สำหรับพวกข้าวจานหรือพวกกระเพราหรือใช้ Class RD จะบวกเพิม 10 บาทถ้าเอาพิเศษ
        if (isSpecial) {
            return super.getPrice() + 10.0;
        } else {
            return super.getPrice();
        }
    }

}

