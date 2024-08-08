import java.util.Scanner;
class temperature{
    
    public static double calculateAverage(double[] temperatures) {
        double sum = 0;
        for (int i = 0; i< temperatures.length; i++){
            double temp = temperatures[i];
            sum += temp;
        }
        return sum / temperatures.length;
    }

    public static double findHighest(double[] temperatures) {
        double highest = temperatures[0];
        for (int i = 1; i< temperatures.length; i++){
            double temp = temperatures[i];
            if (temp > highest) {
                highest = temp;
            }
        }
        return highest;
    }

    
    public static double findLowest(double[] temperatures){
        double lowest = temperatures[0];
        for (int i = 1; i< temperatures.length; i++){
            double temp = temperatures[i];
            if (temp < lowest) {
                lowest = temp;
            }
        }
        return lowest;
    }

    public static void categorizeTemperatures(double[] temperatures) {
        int coldCount = 0, mildCount = 0, hotCount = 0;
        for (int i = 1; i< temperatures.length; i++){
            double temp = temperatures[i];
            if (temp < 10) {
                coldCount++;
            } else if (temp >= 10 && temp <= 25) {
                mildCount++;
            } else {
                hotCount++;
            }
        }
        System.out.println("\nTemperature Categories:");
        System.out.println("------------------------------");
        System.out.println("Cold (< 10 degree Celsius): " + coldCount);
        System.out.println("Mild (10 degree Celsius - 25 degree Celsius): " + mildCount);
        System.out.println("Hot (> 25 degree Celsius): " + hotCount);

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter The Number Of Temperatures You Want To Insert : ");
        int numOfTemperature = scan.nextInt();
        scan.nextLine();
        double[] temperatures = new double[numOfTemperature];

        for(int i = 0;i<numOfTemperature;i++){
            System.out.print("Enter Temperature for "+ (int)(i+1) +" in Celsius : ");
            double temp = scan.nextDouble();
            scan.nextLine();
            temperatures[i] = temp;
        }

        double averageTemperature = calculateAverage(temperatures),highestTemperature = findHighest(temperatures);
        double lowestTemperature = findLowest(temperatures);

        System.out.println("\nTemperature Analysis Report:");
        System.out.println("------------------------------");
        System.out.println("Average Temperature : "+averageTemperature+ " degree Celsius");
        System.out.println("Highest Temperature : "+highestTemperature+" degree Celsius");
        System.out.println("Lowest Temperature : "+lowestTemperature+" degree Celsius");
        categorizeTemperatures(temperatures);
        scan.close();
    }
}
/*

Output :

Enter The Number Of Temperatures You Want To Insert : 5
Enter Temperature for 1 in Celsius : 25
Enter Temperature for 2 in Celsius : 48
Enter Temperature for 3 in Celsius : 50
Enter Temperature for 4 in Celsius : 36
Enter Temperature for 5 in Celsius : 16

Temperature Analysis Report:
------------------------------
Average Temperature : 35.0 degree Celsius
Highest Temperature : 50.0 degree Celsius
Lowest Temperature : 16.0 degree Celsius

Temperature Categories:
------------------------------
Cold (< 10 degree Celsius): 0
Mild (10 degree Celsius - 25 degree Celsius): 1
Hot (> 25 degree Celsius): 3

*/
