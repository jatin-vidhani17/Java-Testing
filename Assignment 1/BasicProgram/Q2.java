/*
 2) Write a program that reads a distance in kilometers from the keyboard and output the distance
as miles.

 */
class KilometersToMiles{
    
    public static void main(String[] args) {
        if (args.length == 1) {
            double kilometers = Double.parseDouble(args[0]);
            double miles = kilometers * 0.621371;
            System.out.println(kilometers + " kilometers is equal to " + miles + " miles.");
        } else {
            System.out.println("Please provide a distance in kilometers as a command-line argument.");
        }
    }
}
/*
 
Output : 

C:\Assignment 1\BasicProgram> java KilometersToMiles 10     
10.0 kilometers is equal to 6.21371 miles.
 */