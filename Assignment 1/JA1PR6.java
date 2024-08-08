/*
Problem 6: BMI Calculator
Create a program that calculates a person's Body Mass Index (BMI) 
and provides an interpretation of
the result. The program should have the following features:

 Prompt the user to enter their height (in meters) and weight (in kilograms).
 Calculate the BMI using the formula: BMI = weight / (height * height).
 Determine the BMI category (underweight, normal, overweight, or obese) based on the
calculated BMI.
 Display the user's BMI value and the corresponding BMI category.

For all men and women 20 years old and older, the BMI
measurement is classified into one of four main weight
categories: Below 18.5: Underweight. 18.5 – 24.9:
Healthy Weight. 25.0 – 29.9: Overweight.
*/

import java.util.Scanner;

class BMI{

    private static void checkIndex(float bmi){
        if(bmi < 18.5){
            System.out.println("You are Underwighted!!");
        }
        else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You are Normal Weighted!!");
        }
        else if (bmi >= 24.9 && bmi <= 29.9){
            System.out.println("You are Overweighted!!");
        }
        else{
            System.out.println("You are Obesed!!");
        }
    }

    private static float calculateBMI(float height,float weight){
        return weight / (height*height);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Your Height in Meters(m) :");
        float height = scan.nextFloat();
        scan.nextLine();
        System.out.print("Enter Your Weight in Kilograms(kgs) :");
        float weight = scan.nextFloat();
        scan.nextLine();
        float bmi = calculateBMI(height,weight);
        checkIndex(bmi);
    }
}

/*
 
Output : 

Z:\Java Testing>java BMI
Enter Your Height in Meters(m) :1.73
Enter Your Weight in Kilograms(kgs) :75
You are Overweighted!!

Z:\Java Testing>java BMI
Enter Your Height in Meters(m) :1.78
Enter Your Weight in Kilograms(kgs) :110
You are Obesed!!
*/