/*
 



3 (IV) Given an Interface:


public interface Grade {
    int countGrade(int[] marks);
    void displayGrade();
}


**Implement the above interface in the abstract Student class** and create **2 subclasses** –  
- **McaStudent**  
- **DcaStudent**  

Create an array of 5 Student objects, read the information of students – name, id, marks of all the semesters, calculate the grade and display the information in the following format:

| **Id**    | **Course** | **First Name** | **Last Name** | **Total Marks** | **Grade** |
|-----------|------------|----------------|---------------|-----------------|-----------|
| Mca101    | MCA        | Sunil          | Shah          | 790             | A         |
| Dca111    | DCA        | Akhil          | Jain          | 250             | B         |

**Note:**  
- DCA has 2 semesters and MCA has 6 semesters.  
- DCA has marks of the Project also.  

**Grade Calculation:**

- **DCA**: Total marks of 2 semesters and project are considered:
  - Above 75% = A
  - 60 to 75% = B
  - 50 to 60% = C
  - Below 50% = D
  
- **MCA**: Total marks of 6 semesters:
  - Above 80% = A
  - 70 to 80% = B
  - 50 to 70% = C
  - Below 50% = D




 
 
 */



package StudentGrade;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[5];

        // Read student data and store in array
        for (int i = 0; i < 2; i++) {
            
            System.out.println("Enter details for student " + (i + 1));
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter course (MCA/DCA): ");
            scanner.nextLine(); // Consume newline left by nextInt()
            String course = scanner.nextLine();
            int[] marks;

            if (course.equalsIgnoreCase("MCA")) {
                marks = new int[6]; // MCA has 6 semesters
                System.out.println("Enter marks for 6 semesters:");
                for (int j = 0; j < 6; j++) {
                    marks[j] = scanner.nextInt();
                }
                students[i] = new McaStudent(firstName, lastName, id, marks);
            } else if (course.equalsIgnoreCase("DCA")) {
                marks = new int[3]; // DCA has 2 semesters and 1 project
                System.out.println("Enter marks for 2 semesters and 1 project:");
                for (int j = 0; j < 3; j++) {
                    marks[j] = scanner.nextInt();
                }
                students[i] = new DcaStudent(firstName, lastName, id, marks);
            } else {
                System.out.println("Invalid course. Skipping this student.");
                i--;  // Repeat for the same index if invalid
                continue;
            }
            students[i].calculateGrade();  // Calculate grade after creation
            scanner.nextLine();
        }

        // Display information of all students in a tabular format
        System.out.println("\nStudent Information:");
        System.out.printf("%-10s %-5s %-10s %-10s %-15s %-5s\n", "Id", "Course", "First Name", "Last Name", "Total Marks", "Grade");
        for (Student student : students) {
            if (student != null) {
                student.displayGrade();
            }
        }

        scanner.close();
    }
    
}
