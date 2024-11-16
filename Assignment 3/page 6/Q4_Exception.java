/*
4. Write a program which creates an array of Date in form (dd/mm/yy). Analyze each
element and check whether the date is correct or not. If the date is wrong then throw a
User defined Exception DateException and display the appropriate message. If the Date
is correct then display the date in this format. For example, if the date is 9/9/06 then
display the date like 9th September 2006. You are able to display all the dates in the
given String and for the date which is not proper, display the appropriate message.
*/

import java.util.Scanner;

class DateException extends Exception {
    public DateException(String message) {
        super(message);
    }
}

class DateValidator {

    public static String validateDate(String date) throws DateException {
        String[] dateParts = date.split("/");

        if (dateParts.length != 3) {
            throw new DateException("Invalid date format. Correct format is dd/mm/yy.");
        }

        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]) + 2000;
        if (month < 1 || month > 12) {
            throw new DateException("Invalid month: " + month);
        }

        if (day < 1 || day > getMaxDaysInMonth(month, year)) {
            throw new DateException("Invalid day: " + day + " for the month " + month);
        }

        return formatDate(day, month, year);
    }

    public static int getMaxDaysInMonth(int month, int year) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        if (month == 2 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
            return 29;
        }
        
        return daysInMonth[month - 1];
    }

    public static String formatDate(int day, int month, int year) {
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

        String daySuffix = getDaySuffix(day);
        return day + daySuffix + " " + months[month - 1] + " " + year;
    }

    public static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dates = new String[5];

        System.out.println("Enter 5 dates in the format dd/mm/yy:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter date " + (i + 1) + ": ");
            dates[i] = scanner.nextLine();
        }

        for (int i = 0; i < 5; i++) {
            try {
                String formattedDate = validateDate(dates[i]);
                System.out.println("Valid date: " + formattedDate);
            } catch (DateException e) {
                System.out.println("Invalid date (" + dates[i] + "): " + e.getMessage());
            }
        }

        scanner.close();
    }
}
/*

Output :

Enter 5 dates in the format dd/mm/yy:
Enter date 1: 9/9/06
Valid date: 9th September 2006
Enter date 2: 30/2/06
Invalid date (30/2/06): Invalid day: 30 for the month 2
Enter date 3: 29/2/20
Valid date: 29th February 2020
Enter date 4: 31/4/06
Invalid date (31/4/06): Invalid day: 31 for the month 4
Enter date 5: 15/13/05
Invalid date (15/13/05): Invalid month: 13

*/