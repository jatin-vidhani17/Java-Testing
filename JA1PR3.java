import java.util.Scanner;

class Student {

    private static int id = 10001;
    private String studName;
    private int studId;
    private int[] marks = new int[5];

    void setDetails() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Student's Name: ");
        this.studName = scan.nextLine();

        System.out.println("Enter " + this.studName + " Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Grade " + (i + 1) + ": ");
            this.marks[i] = scan.nextInt();
        }
        this.studId = id;
        id++;
    }

    float getAvg() {
        float sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += this.marks[i];
        }
        return sum / marks.length;
    }

    void updateDetails() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter New Name for Student " + this.studId + " : ");
        this.studName = scan.nextLine();

        System.out.println("Enter " + this.studName + " Marks : ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Grade " + (i + 1) + ": ");
            this.marks[i] = scan.nextInt();
        }
    }

    void displayDetails() {
        System.out.println("Student ID : " + this.studId);
        System.out.println("Student Name : " + this.studName);
        System.out.print("Student Marks : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(this.marks[i] + " ");
        }
        System.out.println();
        System.out.println("Student Average : " + getAvg());
    }

    static Student findTopStudent(Student[] students, int num) {
        if (students == null || num == 0) return null;
        
        Student topStudent = students[0];
        for (int i = 1; i < num; i++) {
            if (students[i].getAvg() > topStudent.getAvg()) {
                topStudent = students[i];
            }
        }
        return topStudent;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the number of students you want to Manage : ");
        int num = scan.nextInt();
        scan.nextLine();

        Student[] students = new Student[num];

        for (int i = 0; i < num; i++) {
            students[i] = new Student();
            System.out.println("\nEnter details for student " + (i + 1) + " : ");
            students[i].setDetails();
        }

        for (int i = 0; i < num; i++) {
            System.out.println("\nDetails of student " + (i + 1) + ":");
            students[i].displayDetails();
        }

        System.out.print("\nEnter the ID of the student you want to update : ");
        int studentIdToUpdate = scan.nextInt();
        scan.nextLine();

        Student studentToUpdate = null;
        for (int i = 0; i < num; i++) {
            if (students[i].studId == studentIdToUpdate) {
                studentToUpdate = students[i];
                break;
            }
        }

        if (studentToUpdate != null) {
            System.out.println("\nUpdating details for student with ID " + studentIdToUpdate + " : ");
            studentToUpdate.updateDetails();
            System.out.println("\nUpdated details of student with ID " + studentIdToUpdate + " : ");
            studentToUpdate.displayDetails();
        } else {
            System.out.println("No student found with ID " + studentIdToUpdate);
        }

        Student topStudent = findTopStudent(students, num);
        if (topStudent != null) {
            System.out.println("\nStudent with the highest average grade : ");
            topStudent.displayDetails();
        } else {
            System.out.println("No students to display.");
        }
        
        scan.close(); 
    }
}

/*

Output : 

PS C:\TP> java Student     

Enter the number of students you want to Manage : 3

Enter details for student 1 :
Enter Student's Name: Mohit Dadwani
Enter Mohit Dadwani Marks:
Enter Grade 1: 77
Enter Grade 2: 70
Enter Grade 3: 56
Enter Grade 4: 89
Enter Grade 5: 92

Enter details for student 2 :
Enter Student's Name: Dev Makwana
Enter Dev Makwana Marks:
Enter Grade 1: 82
Enter Grade 2: 87
Enter Grade 3: 77
Enter Grade 4: 89
Enter Grade 5: 75

Enter details for student 3 :
Enter Student's Name: Jatin Vidhani
Enter Jatin Vidhani Marks:
Enter Grade 1: 89
Enter Grade 2: 62
Enter Grade 3: 97
Enter Grade 4: 45
Enter Grade 5: 77

Details of student 1:
Student ID : 10001
Student Name : Mohit Dadwani
Student Marks : 77 70 56 89 92
Student Average : 76.8

Details of student 2:
Student ID : 10002
Student Name : Dev Makwana
Student Marks : 82 87 77 89 75
Student Average : 82.0

Details of student 3:
Student ID : 10003
Student Name : Jatin Vidhani
Student Marks : 89 62 97 45 77
Student Average : 74.0

Enter the ID of the student you want to update : 10003

Updating details for student with ID 10003 : 
Enter New Name for Student 10003 : Vishal Baghel
Enter Vishal Baghel Marks : 
Enter Grade 1: 67
Enter Grade 2: 26
Enter Grade 3: 15
Enter Grade 4: 92
Enter Grade 5: 45

Updated details of student with ID 10003 : 
Student ID : 10003
Student Name : Vishal Baghel
Student Marks : 67 26 15 92 45
Student Average : 49.0

Student with the highest average grade :
Student ID : 10002
Student Name : Dev Makwana
Student Marks : 82 87 77 89 75
Student Average : 82.0

*/