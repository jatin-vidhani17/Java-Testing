class Statistics{
    static double average(double []arr){
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        return avg/arr.length;
    }
}
class TemperatureClass{
    public static void main(String[] args) {
        double[][] temperatures = {
            {15.5, 16.0, 14.8, 15.2, 15.6, 16.5, 17.0}, // Week 1
            {16.5, 17.2, 16.0, 15.8, 16.1, 16.7, 15.9}, // Week 2
            {14.0, 14.5, 15.1, 14.8, 15.2, 14.9, 15.0}, // Week 3
            {17.0, 16.8, 17.2, 17.5, 16.9, 17.1, 17.4}  // Week 4
        };

        for (int i = 0; i < temperatures.length; i++) {
            System.out.println("The Average of Week " + (i+1) + " is : " + Statistics.average(temperatures[i]));
        }
    }
}

/*

Output : 

The Average of Week 1 is : 15.799999999999999
The Average of Week 2 is : 16.314285714285713
The Average of Week 3 is : 14.785714285714288
The Average of Week 4 is : 17.12857142857143

*/