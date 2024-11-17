/*
1. Define an Employee class with Employee code , name , date of birth , and date of
appointment . The Employee code must have a format of year-designation-number. The
year will be two digit code . The designation is single letter code M for Manager , A for
Administrative , T for Technical Staff , E for Executive Staff . The number is a three
digit number. For Eg.
87-M-123 ( year is 1987 , Designation is Manager and number is 123)
91-T-126
Write a java program to read the employee code , name , date of birth , and date of
appointment and validate the employee code. If the employee code is incorrect a suitable
user defined exception must be thrown . If the date of birth is after date of appointment then
throw another user defined exception.
If all the details are correct then only create the employee object and display detail of
employees and number of years of experience.
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class InvalidEmployeeCodeException extends Exception {
    public InvalidEmployeeCodeException(String message) {
        super(message);
    }
}

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

class Employee {
    private String employeeCode;
    private String name;
    private Date dateOfBirth;
    private Date dateOfAppointment;

    public Employee(String employeeCode, String name, Date dateOfBirth, Date dateOfAppointment) throws InvalidEmployeeCodeException, InvalidDateException {
        if (!isValidEmployeeCode(employeeCode)) {
            throw new InvalidEmployeeCodeException("Invalid employee code format. Please enter in the format yy-D-###");
        }
        
        this.employeeCode = employeeCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAppointment = dateOfAppointment;

        if (dateOfBirth.after(dateOfAppointment)) {
            throw new InvalidDateException("Date of birth cannot be after the date of appointment.");
        }
    }

    private boolean isValidEmployeeCode(String employeeCode) {
        String regex = "^\\d{2}-[MATE]-\\d{3}$";
        return employeeCode.matches(regex);
    }

    public int getYearsOfExperience() {
        Calendar appointmentCal = Calendar.getInstance();
        appointmentCal.setTime(dateOfAppointment);
        Calendar today = Calendar.getInstance();

        int yearsExperience = today.get(Calendar.YEAR) - appointmentCal.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < appointmentCal.get(Calendar.MONTH) || 
            (today.get(Calendar.MONTH) == appointmentCal.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < appointmentCal.get(Calendar.DAY_OF_MONTH))) {
            yearsExperience--;
        }

        return yearsExperience;
    }

    public void displayDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Employee Details:");
        System.out.println("Employee Code: " + employeeCode);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + sdf.format(dateOfBirth));
        System.out.println("Date of Appointment: " + sdf.format(dateOfAppointment));
        System.out.println("Years of Experience: " + getYearsOfExperience());
    }
}

class EmployeeDetailsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Enter Employee Details");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter Employee Code (Format: yy-D-###): ");
                    String employeeCode = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Date of Birth (dd-MM-yyyy): ");
                    String dob = scanner.nextLine();

                    System.out.print("Enter Date of Appointment (dd-MM-yyyy): ");
                    String doa = scanner.nextLine();

                    try {
                        Date dateOfBirth = sdf.parse(dob);
                        Date dateOfAppointment = sdf.parse(doa);

                        Employee employee = new Employee(employeeCode, name, dateOfBirth, dateOfAppointment);
                        employee.displayDetails();

                    } catch (ParseException e) {
                        System.out.println("Invalid date format! Please enter in dd-MM-yyyy format.");
                    } catch (InvalidEmployeeCodeException | InvalidDateException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (choice == 2) {
                    System.out.println("Exiting the program...");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
/*
 Output : 

Menu:
1. Enter Employee Details
2. Exit
Enter your choice: 1
Enter Employee Code (Format: yy-D-###): 91-M-123
Enter Name: Rama Rao
Enter Date of Birth (dd-MM-yyyy): 15-08-1985
Enter Date of Appointment (dd-MM-yyyy): 01-04-2010
Employee Details:
Employee Code: 91-M-123
Name: Rama Rao
Date of Birth: 15-08-1985
Date of Appointment: 01-04-2010
Years of Experience: 14

Menu:
1. Enter Employee Details
2. Exit
Enter your choice: 1
Enter Employee Code (Format: yy-D-###): 91-X-126
Enter Name: Krishna Yadav
Enter Date of Birth (dd-MM-yyyy): 15-08-1988
Enter Date of Appointment (dd-MM-yyyy): 01-05-2015
Invalid employee code format. Please enter in the format yy-D-###

*/
