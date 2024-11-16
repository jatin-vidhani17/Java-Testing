/*
Create a HashTable/ HashMap of students object and find the following:
a. Check if a particular key exist in the hashtable or not. If exist then display the value
b. Remove an entry from hashtable (key is entered by user to remove)
c. Add a new entry
d. Display all the entries
e. Check if a particular value exist in the hashtable or not. If exist then display the value
*/
import java.util.*;

class Student {
    private int rollNo;
    private String name;

    // Constructor
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    
    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name;
    }

    // Getter for name (used for value existence check)
    public String getName() {
        return name;
    }
}


class StudentHashMap {
    public static void main(String[] args) {
      
        Map<Integer, Student> studentMap = new HashMap<>();

        studentMap.put(1, new Student(101, "Alice"));
        studentMap.put(2, new Student(102, "Bob"));
        studentMap.put(3, new Student(103, "Charlie"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check if a key exists and display the value");
            System.out.println("2. Remove an entry by key");
            System.out.println("3. Add a new entry");
            System.out.println("4. Display all entries");
            System.out.println("5. Check if a value exists and display it");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter key to check: ");
                    int keyToCheck = scanner.nextInt();
                    if (studentMap.containsKey(keyToCheck)) {
                        System.out.println("Key exists. Value: " + studentMap.get(keyToCheck));
                    } else {
                        System.out.println("Key does not exist.");
                    }
                    break;

                case 2:
                    System.out.print("Enter key to remove: ");
                    int keyToRemove = scanner.nextInt();
                    if (studentMap.remove(keyToRemove) != null) {
                        System.out.println("Entry removed successfully.");
                    } else {
                        System.out.println("Key not found. No entry removed.");
                    }
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    int newKey = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter roll number: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    studentMap.put(newKey, new Student(rollNo, name));
                    System.out.println("New entry added successfully.");
                    break;

                case 4:
                    System.out.println("Displaying all entries:");
                    
                    for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    }
                    break;

                case 5:
                    System.out.print("Enter name to check: ");
                    String nameToCheck = scanner.nextLine();
                    boolean found = false;
                    for (Student student : studentMap.values()) {
                        if (student.getName().equalsIgnoreCase(nameToCheck)) {
                            System.out.println("Value exists: " + student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Value does not exist.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
/*
 
Output : 

Choose an option:
1. Check if a key exists and display the value
2. Remove an entry by key
3. Add a new entry
4. Display all entries
5. Check if a value exists and display it
6. Exit
Enter your choice: 1
Enter key to check: 2
Key exists. Value: Roll No: 102, Name: Bob

Choose an option:
1. Check if a key exists and display the value
2. Remove an entry by key
3. Add a new entry
4. Display all entries
5. Check if a value exists and display it
6. Exit
Enter your choice: 2
Enter key to remove: 3
Entry removed successfully.

Choose an option:
1. Check if a key exists and display the value
2. Remove an entry by key
3. Add a new entry
4. Display all entries
5. Check if a value exists and display it
6. Exit
Enter your choice: 3
Enter key: 4
Enter roll number: 104
Enter name: David
New entry added successfully.

Choose an option:
1. Check if a key exists and display the value
2. Remove an entry by key
3. Add a new entry
4. Display all entries
5. Check if a value exists and display it
6. Exit
Enter your choice: 4
Displaying all entries:
Key: 1, Value: Roll No: 101, Name: Alice
Key: 2, Value: Roll No: 102, Name: Bob
Key: 4, Value: Roll No: 104, Name: David

Choose an option:
1. Check if a key exists and display the value
2. Remove an entry by key
3. Add a new entry
4. Display all entries
5. Check if a value exists and display it
6. Exit
Enter your choice: 5
Enter name to check: Bob
Value exists: Roll No: 102, Name: Bob

Choose an option:
1. Check if a key exists and display the value
2. Remove an entry by key
3. Add a new entry
4. Display all entries
5. Check if a value exists and display it
6. Exit
Enter your choice: 6
Exiting the program.

 */