package StudentGrade;

abstract class Student implements Grade {
    String firstName;
    String lastName;
    int id;
    String course;
    int[] marks;
    String grade;
    int totalMarks;

    public Student(String firstName, String lastName, int id, String course, int[] marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    public abstract void calculateGrade();
}

class McaStudent extends Student {

    public McaStudent(String firstName, String lastName, int id, int[] marks) {
        super(firstName, lastName, id, "MCA", marks);
    }

    @Override
    public void calculateGrade() {
        totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        int average = totalMarks / marks.length;

        // Calculate grade based on MCA criteria
        if (average > 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 50) grade = "C";
        else grade = "D";
    }

    @Override
    public void displayGrade() {
        System.out.printf("%s%-10d %-5s %-10s %-10s %-15d %-5s\n", course, id, course, firstName, lastName, totalMarks, grade);
    }

    @Override
    public int countGrade(int[] marks) {
        calculateGrade();
        return totalMarks;
    }
}

class DcaStudent extends Student {

    public DcaStudent(String firstName, String lastName, int id, int[] marks) {
        super(firstName, lastName, id, "DCA", marks);
    }

    @Override
    public void calculateGrade() {
        totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        int average = totalMarks / marks.length;

        // Calculate grade based on DCA criteria
        if (average > 75) grade = "A";
        else if (average >= 60) grade = "B";
        else if (average >= 50) grade = "C";
        else grade = "D";
    }

    @Override
    public void displayGrade() {
        System.out.printf("%s%-10d %-5s %-10s %-10s %-15d %-5s\n",course, id, course, firstName, lastName, totalMarks, grade);
    }

    @Override
    public int countGrade(int[] marks) {
        calculateGrade();
        return totalMarks;
    }
}
