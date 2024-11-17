/*
9) Write a java program to calculate Simple Interest using Command Line Arguments. (Hint use
Wrapper classes)
*/
class simpleInterest{
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide Principal, Rate, and Time as command line arguments.");
            return;
        }

        double principal = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        double time = Double.parseDouble(args[2]);
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest : " + simpleInterest);
    
    }
}
/*

output : 

C:\Assignment 1\BasicProgram> java simpleInterest 1050 15  10 
Simple Interest : 1575.0
 
*/