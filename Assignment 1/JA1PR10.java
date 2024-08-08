import java.util.Scanner;
class GroceryListManager {
    private static Item[] groceryList = new Item[100]; // Fixed size array
    private static int itemCount = 0; // Keeps track of the number of items
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Grocery List Manager");
            System.out.println("1. Display List");
            System.out.println("2. Add Item");
            System.out.println("3. Mark as Purchased");
            System.out.println("4. Remove Item");
            System.out.println("5. Search for Item");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayList();
                    break;
                case "2":
                    addItem();
                    break;
                case "3":
                    markAsPurchased();
                    break;
                case "4":
                    removeItem();
                    break;
                case "5":
                    searchItem();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
            }
        }
    }

    private static void displayList() {
        System.out.println("\nCurrent Grocery List:");
        if (itemCount == 0) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                Item item = groceryList[i];
                String status = item.isPurchased() ? "Purchased" : "Pending";
                System.out.println("- " + item.getName() + " [" + status + "]");
            }
        }
        System.out.println();
    }

    private static void addItem() {
        if (itemCount >= groceryList.length) {
            System.out.println("The list is full. Cannot add more items.");
            return;
        }
        System.out.print("Enter the name of the item to add: ");
        String itemName = scanner.nextLine();
        groceryList[itemCount++] = new Item(itemName, false);
        System.out.println("Added '" + itemName + "' to the list.");
    }

    private static void markAsPurchased() {
        System.out.print("Enter the name of the item to mark as purchased: ");
        String itemName = scanner.nextLine();
        for (int i = 0; i < itemCount; i++) {
            if (groceryList[i].getName().equalsIgnoreCase(itemName)) {
                groceryList[i].setPurchased(true);
                System.out.println("Marked '" + itemName + "' as purchased.");
                return;
            }
        }
        System.out.println("Item '" + itemName + "' not found.");
    }

    private static void removeItem() {
        System.out.print("Enter the name of the item to remove: ");
        String itemName = scanner.nextLine();
        for (int i = 0; i < itemCount; i++) {
            if (groceryList[i].getName().equalsIgnoreCase(itemName)) {
                for (int j = i; j < itemCount - 1; j++) {
                    groceryList[j] = groceryList[j + 1];
                }
                groceryList[--itemCount] = null;
                System.out.println("Removed '" + itemName + "' from the list.");
                return;
            }
        }
        System.out.println("Item '" + itemName + "' not found.");
    }

    private static void searchItem() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();
        System.out.println("\nSearch results for '" + searchTerm + "':");
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (groceryList[i].getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                String status = groceryList[i].isPurchased() ? "Purchased" : "Pending";
                System.out.println("- " + groceryList[i].getName() + " [" + status + "]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching items found.");
        }
        System.out.println();
    }

    private static class Item {
        private String name;
        private boolean purchased;

        public Item(String name, boolean purchased) {
            this.name = name;
            this.purchased = purchased;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPurchased() {
            return purchased;
        }

        public void setPurchased(boolean purchased) {
            this.purchased = purchased;
        }
    }
}
/*

Output : 

PS C:\TP> java GroceryListManager
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 1

Current Grocery List:
The list is empty.

Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 2
Enter the name of the item to add: Biscuit
Added 'Biscuit' to the list.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 2
Enter the name of the item to add: Brush 
Added 'Brush' to the list.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 2
Enter the name of the item to add: Tea Bags
Added 'Tea Bags' to the list.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): Towel   
Invalid choice. Please select a number between 1 and 6.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 2        
Enter the name of the item to add: Towel    
Added 'Towel' to the list.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 2        
Enter the name of the item to add: Soaps
Added 'Soaps' to the list.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 1

Current Grocery List:
- Biscuit [Pending]
- Brush [Pending]
- Tea Bags [Pending]
- Towel [Pending]
- Soaps [Pending]

Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 3
Enter the name of the item to mark as purchased: Towel
Marked 'Towel' as purchased.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 3     
Enter the name of the item to mark as purchased: Biscuit
Marked 'Biscuit' as purchased.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 3       
Enter the name of the item to mark as purchased: Tea Bags
Marked 'Tea Bags' as purchased.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 3        
Enter the name of the item to mark as purchased: Soaps
Marked 'Soaps' as purchased.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 1

Current Grocery List:
- Biscuit [Purchased]
- Brush [Pending]
- Tea Bags [Purchased]
- Towel [Purchased]
- Soaps [Purchased]

Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 4
Enter the name of the item to remove: Brush
Removed 'Brush' from the list.
Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 1

Current Grocery List:
- Biscuit [Purchased]
- Tea Bags [Purchased]
- Towel [Purchased]
- Soaps [Purchased]

Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 5
Enter search term: Biscuit

Search results for 'Biscuit':
- Biscuit [Purchased]

Grocery List Manager
1. Display List
2. Add Item
3. Mark as Purchased
4. Remove Item
5. Search for Item
6. Exit
Choose an option (1-6): 6
Exiting...
PS C:\TP> 

*/