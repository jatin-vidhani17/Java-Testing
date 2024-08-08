import java.util.Scanner;

class Student {
    // Data Members
    private String name;
    private char grade;
    private int age;

    // Constructor
    public Student(String name, char grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    // Method to set the student's name
    public void setName(String name) {
        this.name = name;
    }

    // Method to get the student's grade
    public char getGrade() {
        return grade;
    }

    // Method to increment the student's age by 1
    public void incrementAge() {
        age += 1;
    }

    // Method to print the student's information
    public void printStudentInfo() {
        System.out.println("Name : " + name);
        System.out.println("Grade : " + grade);
        System.out.println("Age : " + age);
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        // Taking Input From User 
        System.out.print("Enter the number of students : ");
        int numberOfStudents = scan.nextInt();
        scan.nextLine();

        // Creating an array of Student objects
        Student[] students = new Student[numberOfStudents];

        // Inserting Values Student objects of array
        for(int i = 0; i < numberOfStudents; i++){
            System.out.print("Enter name for student " + (i + 1) + " : ");
            String name = scan.nextLine();

            System.out.print("Enter grade for student " + (i + 1) + " : ");
            char grade = scan.nextLine().charAt(0);

            System.out.print("Enter age for student " + (i + 1) + " : ");
            int age = scan.nextInt();
            scan.nextLine();

            students[i] = new Student(name,grade,age);
        }

        // Calling printStudentInfo() method for each student
        System.out.println("\nStudent Information : ");
        for (int i = 0; i < numberOfStudents; i++){
            students[i].printStudentInfo();
            System.out.println();
        }

        // Find the student with the highest grade
        Student topStudent = students[0];
        for(int i = 0; i < numberOfStudents; i++){
            if ((int)students[i].getGrade() < (int)topStudent.getGrade()) {
                topStudent = students[i];
            }
        }

        // Printing student with the highest grade
        System.out.println("Student with the highest grade : ");
        topStudent.printStudentInfo();

        scan.close();
    }
}
/*
 
Output :

Enter the number of students : 2
Enter name for student 1 : Krishna Yadav
Enter grade for student 1 : B
Enter age for student 1 : 18
Enter name for student 2 : Balram Yadav
Enter grade for student 2 : A
Enter age for student 2 : 19

Student Information :
Name : Krishna Yadav
Grade : B
Age : 18

Name : Balram Yadav
Grade : A
Age : 19

Student with the highest grade : 
Name : Balram Yadav
Grade : A
Age : 19

*/