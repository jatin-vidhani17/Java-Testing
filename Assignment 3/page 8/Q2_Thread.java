/*
 2. Write a program for restaurant. Use Inter Thread Communication.
 When customer places an order then and only then Manager can take the Order or
generate a bill of an Order.
 And display the customer order after it place the Order.
 You have to display minimum three orders of three different customers A, B and C, in
which customer A is the preferred customer with higher priority
 */

import java.util.Scanner;

class Restaurant {
    private String currentOrder = null;

    public synchronized void placeOrder(String customerName, String order) {
        while (currentOrder != null) {
            try {
                System.out.println(customerName + " is waiting for the manager to process the order.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentOrder = order;
        System.out.println(customerName + " has placed an order: " + order);
        notify();
    }

    public synchronized void takeOrderAndGenerateBill(String customerName) {
        while (currentOrder == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Manager is processing the order for " + customerName + ": " + currentOrder);
        System.out.println("Bill for " + customerName + ": " + currentOrder + " - $50");
        currentOrder = null;
        notify();
    }
}

class Customer extends Thread {
    private String customerName;
    private String order;
    private Restaurant restaurant;

    public Customer(String customerName, String order, Restaurant restaurant) {
        this.customerName = customerName;
        this.order = order;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        restaurant.placeOrder(customerName, order);
    }
}
 
class Manager extends Thread {
    private Restaurant restaurant;

    public Manager(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String customerChoice;

        do {
            System.out.println("\nManager Menu:");
            System.out.println("1. Process Customer A's Order");
            System.out.println("2. Process Customer B's Order");
            System.out.println("3. Process Customer C's Order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            customerChoice = scanner.nextLine();

            switch (customerChoice) {
                case "1":
                    restaurant.takeOrderAndGenerateBill("Customer A");
                    break;
                case "2":
                    restaurant.takeOrderAndGenerateBill("Customer B");
                    break;
                case "3":
                    restaurant.takeOrderAndGenerateBill("Customer C");
                    break;
                case "4":
                    System.out.println("Exiting the manager menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!customerChoice.equals("4"));

        scanner.close();
    }
}
 
class RestaurantSimulation {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Manager manager = new Manager(restaurant);
        manager.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Restaurant! Let's get started.");
        String customerChoice;
        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Customer A places an order");
            System.out.println("2. Customer B places an order");
            System.out.println("3. Customer C places an order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            customerChoice = scanner.nextLine();

            switch (customerChoice) {
                case "1":
                    new Customer("Customer A", "Pizza", restaurant).start();
                    break;
                case "2":
                    new Customer("Customer B", "Burger", restaurant).start();
                    break;
                case "3":
                    new Customer("Customer C", "Pasta", restaurant).start();
                    break;
                case "4":
                    System.out.println("Exiting customer menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!customerChoice.equals("4"));

        scanner.close();
    }
}

/*
 
Output : 

Welcome to the Restaurant! Let's get started.

Customer Menu:
1. Customer A places an order
2. Customer B places an order
3. Customer C places an order
4. Exit
Enter your choice: 1
Customer A has placed an order: Pizza

Customer Menu:
1. Customer A places an order
2. Customer B places an order
3. Customer C places an order
4. Exit
Enter your choice: 2
Customer B has placed an order: Burger

Customer Menu:
1. Customer A places an order
2. Customer B places an order
3. Customer C places an order
4. Exit
Enter your choice: 3
Customer C has placed an order: Pasta
Manager Menu:
1. Process Customer A's Order
2. Process Customer B's Order
3. Process Customer C's Order
4. Exit
Enter your choice: 1
Manager is processing the order for Customer A: Pizza
Bill for Customer A: Pizza - $50

Manager Menu:
1. Process Customer A's Order
2. Process Customer B's Order
3. Process Customer C's Order
4. Exit
Enter your choice: 2
Manager is processing the order for Customer B: Burger
Bill for Customer B: Burger - $50

Manager Menu:
1. Process Customer A's Order
2. Process Customer B's Order
3. Process Customer C's Order
4. Exit
Enter your choice: 3
Manager is processing the order for Customer C: Pasta
Bill for Customer C: Pasta - $50

Manager Menu:
1. Process Customer A's Order
2. Process Customer B's Order
3. Process Customer C's Order
4. Exit
Enter your choice: 4
Exiting the manager menu.

 */