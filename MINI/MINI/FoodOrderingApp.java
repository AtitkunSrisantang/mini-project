package MINI;

import java.util.Scanner;

public class FoodOrderingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();

        menu.addItem(new RD("Pork Basil Stir-fry with Rice", 50.0));
        menu.addItem(new RD("Fried Rice", 50.0));
        menu.addItem(new BV("Papaya Salad", 40.0));
        menu.addItem(new BV("Water", 10.0));

        int choice = -1;

        System.out.println("⭐ Welcome to our restaurant! ⭐");

        while (choice != 0) {
            menu.displayMenu();
            System.out.println("\nPlease select an item by number (e.g., 1, 2, 3,...)");
            System.out.println("Enter 's' to see your order and total.");
            System.out.println("Enter 'd' to delete an item from your order.");
            System.out.println("Enter '0' to finish ordering and pay.");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("s")) {
                order.displayOrder();
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                continue;
            } else if (input.equalsIgnoreCase("d")) {
                if (order.isEmpty()) {
                    System.out.println("❌ Your order is empty. Nothing to delete.");
                } else {
                    order.displayOrder(); // Show the order with numbers
                    System.out.print("Enter the item number to delete: ");
                    try {
                        String itemNumberInput = scanner.nextLine();
                        int itemNumber = Integer.parseInt(itemNumberInput);
                        if (order.removeItem(itemNumber)) {
                            System.out.println("✅ Item #" + itemNumber + " removed successfully.");
                        } else {
                            System.out.println("❌ Invalid item number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input. Please enter a number.");
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
                        System.out.println("✅ Added '" + orderItem.getName() + "' to your order!");

                    } else {
                        System.out.println("❌ Item not found. Please try again.");
                    }
                } else if (choice != 0) {
                    System.out.println("❌ Invalid option. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input format. Please enter a number or 's'/'d'.");
            }
            System.out.println();
        }

        System.out.println("\n--- Final Order Summary ---");
        order.displayOrder();
        System.out.println("🙏 Thank you for your visit!");

        scanner.close();
    }
}