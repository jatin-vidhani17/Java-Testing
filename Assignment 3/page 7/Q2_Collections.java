/*
2. Create a HashSet of 5 names. Write a menu driven program to do the following:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (display in reverser order also – use ListIterator )
e. Display number of elements in hashset

*/
import java.util.*;

class Hashsets {

    public static void main(String[] args) {
       
        HashSet<String> h1 = new HashSet<>();
        Scanner s1 = new Scanner(System.in);
        char ch;

        do {
            System.out.println("\nMenu:");
            System.out.println("a. Add a new name");
            System.out.println("b. Remove a name");
            System.out.println("c. Search a name");
            System.out.println("d. Display all the names (in reverse order also)");
            System.out.println("e. Display the number of elements in HashSet");
            System.out.println("x. Exit");
            System.out.print("Enter your choice: ");
            ch = s1.next().charAt(0);
            s1.nextLine(); 

            String name;

            switch (ch) {
                case 'a':
                    System.out.print("Enter the name to add: ");
                    name = s1.nextLine();
                    if (h1.add(name)) {
                        System.out.println("Name added successfully.");
                    } else {
                        System.out.println("Name already exists in the HashSet.");
                    }
                    break;

                case 'b':
                    System.out.print("Enter the name to remove: ");
                    name = s1.nextLine();
                    if (h1.remove(name)) {
                        System.out.println("Name removed successfully.");
                    } else {
                        System.out.println("Name not found in the HashSet.");
                    }
                    break;

                case 'c':
                    System.out.print("Enter the name to search: ");
                    name = s1.nextLine();
                    if (h1.contains(name)) {
                        System.out.println("Name found in the HashSet.");
                    } else {
                        System.out.println("Name not found in the HashSet.");
                    }
                    break;

                case 'd':
                    System.out.println("Displaying all names:");
                    List<String> list = new ArrayList<>(h1); // Convert HashSet to List for ordering
                    for (String n : list) {
                        System.out.println(n);
                    }

                    System.out.println("Displaying names in reverse order:");
                    ListIterator<String> iterator = list.listIterator(list.size());
                    while (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;

                case 'e':
                    System.out.println("Number of elements in the HashSet: " + h1.size());
                    break;

                case 'x':
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (ch != 'x');

        s1.close();
    }
}
/*
 
Output : 

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: a
Enter the name to add: Alice
Name added successfully.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: a
Enter the name to add: Bob
Name added successfully.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: a
Enter the name to add: Charlie
Name added successfully.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: a
Enter the name to add: David
Name added successfully.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: a
Enter the name to add: Eve
Name added successfully.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: d
Displaying all names:
Alice
Bob
Charlie
David
Eve
Displaying names in reverse order:
Eve
David
Charlie
Bob
Alice

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: e
Number of elements in the HashSet: 5

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: b
Enter the name to remove: Bob
Name removed successfully.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: d
Displaying all names:
Alice
Charlie
David
Eve
Displaying names in reverse order:
Eve
David
Charlie
Alice

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: c
Enter the name to search: Charlie
Name found in the HashSet.

Menu:
a. Add a new name
b. Remove a name
c. Search a name
d. Display all the names (in reverse order also)
e. Display the number of elements in HashSet
x. Exit
Enter your choice: x
Exiting program. Goodbye!


*/