
/* 

1. Write an Application program to generate Employee Payslip.

Create following classes:

Employee - emp_no, emp_name, basic, Des
InvalidBasicException - Class for user defined Exception (if basic is negative or non numeric).
Payslip - do all calculations (da, hra) based on following rules.
If basic <= 5000 then hra = 5% of basic and da = 3% of basic.
If basic >= 15000 then hra = 7.5% of basic and da = 5% of basic.
Else hra = 10% of basic and da = 8% of basic.

Based on that calculate netpay for each employee in Payslip class and generate the formatted pay slip in a file, with filename as <emp_no>_payslip.txt.

Note: emp_no should be generated automatically with prefix EMP, use array of objects.

*/


package EmployeePayslip;
import PayslipGenerator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter number of employees: ");
        int size = input.nextInt();
        input.nextLine();  

        Employee[] employees = new Employee[size];
        Payslip payslipGenerator = new Payslip();

        
        for (int i = 0; i < size; i++) {
            try {
                System.out.println("\nEnter details for Employee " + (i + 1));

             
                System.out.print("Enter Employee Name: ");
                String name = input.nextLine();

             
                System.out.print("Enter Employee Basic Salary: ");
                double basicSalary = input.nextDouble();
                input.nextLine();  

                
                System.out.print("Enter Employee Designation: ");
                String des = input.nextLine();

               
                employees[i] = new Employee(name, basicSalary, des);

               
                payslipGenerator.generatePayslip(employees[i]);

            } catch (InvalidBasicException e) {
                System.out.println("Error : " + e.getMessage());
                break;  
            }
        }

        input.close();
    }
}