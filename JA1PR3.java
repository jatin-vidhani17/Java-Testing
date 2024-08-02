import java.util.Scanner;

class Student {

    private static int id = 10001;
    private String studName;
    private int studId;
    private int marks[] = new int[5];

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

    int getAvg() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += this.marks[i];
        }
        return sum / 5;
    }

    void updateDetails() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter New Name for Student " + this.studId + ": ");
        this.studName = scan.nextLine();

        System.out.println("Enter " + this.studName + " Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Grade " + (i + 1) + ": ");
            this.marks[i] = scan.nextInt();
        }
    }
	
	void displayDetails() {
        System.out.println("Student ID: " + this.studId);
        System.out.println("Student Name: " + this.studName);
        System.out.print("Student Marks: ");
        for (int i = 0;i<5;i++) {
            System.out.print(this.marks[i] + " ");
        }
        System.out.println();
        System.out.println("Student Average : " + getAvg());
    }

    static Student findTopStudent(Student[] students,int num) {
        Student topStudent = students[0];
        for(int i=0 ; i<num ;i++) {
            if (students[i].getAvg() > topStudent.getAvg()) {
                topStudent = students[i];
            }
        }
        return topStudent;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of students you want to Manage : ");
        int num = scan.nextInt();
        scan.nextLine();

        Student[] students = new Student[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            students[i].setDetails();
        }

        for (int i = 0; i < num; i++) {
            System.out.println("Details of student " + (i + 1) + ":");
            students[i].displayDetails();
        }

		System.out.print("Enter the ID of the student you want to update : ");
        int studentIdToUpdate = scan.nextInt();
        scan.nextLine();

		Student studentToUpdate = null;
        for(int i = 0;i<num;i++){
			if(students[i].studId == studentIdToUpdate){
				studentToUpdate = students[i];
				break;
			}
		}
        
		if (studentToUpdate != null) {
            System.out.println("Updating details for student with ID " + studentIdToUpdate + ":");
            studentToUpdate.updateDetails();
            System.out.println("Updated details of student with ID " + studentIdToUpdate + ":");
            studentToUpdate.displayDetails();
        } else {
            System.out.println("No student found with ID " + studentIdToUpdate);
        }

        Student topStudent = findTopStudent(students,num);
        System.out.println("Student with the highest average grade : ");
        topStudent.displayDetails();
    }
}
