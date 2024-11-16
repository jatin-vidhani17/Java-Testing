/*
1. Write a program to read employee detail and store the employee object in linkedlist. Sort the
list based on salary.
a. Create class- Employee (Attributes- empid, name , dob , salary : Methods: setDetails,
getDetails and constructures )
b. Employee class must implement comparable interface
c. Create another class TestEmployee, here create the linkedlist of employees and sort the
list.
*/


import java.util.*;

class Employee implements Comparable<Employee> {
    private int empid;
    private String name;
    private String dob;
    private double salary;

    public Employee(int empid, String name, String dob, double salary) {
        this.empid = empid;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void getDetails() {
        System.out.println("Employee ID: " + empid);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Salary: $" + salary);
    }

    
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
}

class TestEmployee {
    public void process() {
        
        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Vishal", "28-8-1995", 55000.2));
        employees.add(new Employee(2, "Raj", "28-8-1995", 45000.0));
        employees.add(new Employee(3, "Anita", "28-8-1995", 60000.5));
        employees.add(new Employee(4, "John", "28-8-1995", 50000.3));

        Collections.sort(employees);

        System.out.println("Employees sorted by salary (ascending):");
        for (Employee emp : employees) {
            emp.getDetails();
            System.out.println();
        }


        for (Employee emp : employees) {
            emp.getDetails();
            System.out.println();
        }
    }
}

class firstCollection{
    public static void main(String... args) {
        TestEmployee test = new TestEmployee();
        test.process();
    }
}

/*

Output : 

Employees sorted by salary (ascending):
Employee ID: 2
Name: Raj
Date of Birth: 28-8-1995
Salary: $45000.0

Employee ID: 4
Name: John
Date of Birth: 28-8-1995
Salary: $50000.3

Employee ID: 1
Name: Vishal
Date of Birth: 28-8-1995
Salary: $55000.2

Employee ID: 3
Name: Anita
Date of Birth: 28-8-1995
Salary: $60000.5

Employee ID: 2
Name: Raj
Date of Birth: 28-8-1995
Salary: $45000.0

Employee ID: 4
Name: John
Date of Birth: 28-8-1995
Salary: $50000.3

Employee ID: 1
Name: Vishal
Date of Birth: 28-8-1995
Salary: $55000.2

Employee ID: 3
Name: Anita
Date of Birth: 28-8-1995
Salary: $60000.5

 */