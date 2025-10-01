package MINI;

import java.util.Scanner;

public class FoodOrderingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();

        // สร้างเมนูอาหาร
        menu.addItem(new RD("Pork Basil Stir-fry with Rice", 50.0));
        menu.addItem(new RD("Fried Rice", 50.0));
        menu.addItem(new RD("Steak", 80.0));
        menu.addItem(new RD("Pizza", 100.0));
        menu.addItem(new BV("Papaya Salad", 40.0));
        menu.addItem(new BV("Water", 10.0));

        int choice = -1;
        
        System.out.println("Welcome to our restaurant!");

        while (choice != 0) {
            menu.displayMenu();
            System.out.println("\nPlease select an item by number (e.g., 1, 2, 3,...)");
            System.out.println("Enter 's' to see your order and total.");
            System.out.println("Enter 'r' to remove an item from your order."); // เพิ่มบรรทัดนี้
            System.out.println("Enter '0' to finish ordering and pay.");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("s")) {
                order.displayOrder();
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                continue;
            }

            if (input.equalsIgnoreCase("r")) {
                if (order.getOrderedItems().isEmpty()) {
                    System.out.println("Your order is empty. Nothing to remove.");
                } else {
                    order.displayOrder();
                    System.out.print("Enter the number of the item to remove: ");
                    String removeInput = scanner.nextLine();
                    try {
                        int removeIndex = Integer.parseInt(removeInput) - 1;
                        order.removeItem(removeIndex);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                continue;
            }

            try {
                choice = Integer.parseInt(input);

                if (choice > 0) {
                    MenuItem selectedItem = menu.getItem(choice - 1);
                    if (selectedItem != null) {
                        boolean isSpecial = false;

                        if (selectedItem instanceof RD) {
                            System.out.print("Make it special (adds 10 Baht)? (y/n): ");
                            String specialInput = scanner.nextLine();
                            if (specialInput.equalsIgnoreCase("y")) {
                                isSpecial = true;
                            }
                        }

                        OrderItem orderItem = new OrderItem(selectedItem, isSpecial);
                        order.addItem(orderItem);
                        System.out.println("Added '" + orderItem.getName() + "' to your order!");
                    } else {
                        System.out.println("Item not found. Please try again.");
                    }
                } else if (choice != 0) {
                    System.out.println("Invalid option. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a number or 's'/'r'.");
            }
            System.out.println(); // Add a blank line for readability
        }

        System.out.println("\n--- Final Order Summary ---");
        order.displayOrder();
        System.out.println("Thank you for your visit!");

        scanner.close();
    }
}
