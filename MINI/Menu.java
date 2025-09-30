// Menu.java
package MINI;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }
//หน้านี้ใช้สร้าง List เก็บข้อมูลและทำหน้าเมนูอาหาร
    public void displayMenu() {
        System.out.println("------ Food Menu ------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - " + items.get(i).getPrice() + " Baht");
        }
        System.out.println("-----------------------");
    }

    public MenuItem getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

}
