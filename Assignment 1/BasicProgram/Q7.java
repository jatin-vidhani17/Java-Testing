/*
 7) Use While loop to generate random numbers and maintain a running sum of these values.
    Terminate when the sum exceeds 20. (Note: use Math. random() method to obtain numbers.)
*/

class randomNum {
    public static void main(String[] args) {
        double sum = 0;
        while (sum <= 20) {
            double randomNumber = Math.random();
            sum += randomNumber;
            System.out.println("Generated number: " + randomNumber + ", Running sum: " + sum);
        }
        System.out.println("Final sum: " + sum);
    }
}
/*

Output : 

C:\Assignment 1\BasicProgram> java randomNum 
Generated number: 0.9152932730565116, Running sum: 0.9152932730565116
Generated number: 0.07332914682177183, Running sum: 0.9886224198782835
Generated number: 0.9255364265249999, Running sum: 1.9141588464032835
Generated number: 0.9856235624268317, Running sum: 2.899782408830115
Generated number: 0.7296310398696352, Running sum: 3.6294134486997502
Generated number: 0.6644586789736365, Running sum: 4.293872127673387
Generated number: 0.6289222092601503, Running sum: 4.922794336933537
Generated number: 0.20556169806538194, Running sum: 5.128356034998919
Generated number: 0.0759993041196495, Running sum: 5.204355339118568
Generated number: 0.6908796650991802, Running sum: 5.895235004217748
Generated number: 0.3669444607016549, Running sum: 6.262179464919403
Generated number: 0.16183505925617392, Running sum: 6.424014524175577
Generated number: 0.10801367018870833, Running sum: 6.532028194364286
Generated number: 0.048772511763121806, Running sum: 6.580800706127408
Generated number: 0.7749723924992886, Running sum: 7.355773098626697
Generated number: 0.6189841766103578, Running sum: 7.974757275237055
Generated number: 0.6283194701655939, Running sum: 8.60307674540265
Generated number: 0.460386569945213, Running sum: 9.063463315347862
Generated number: 0.9837202762065449, Running sum: 10.047183591554408
Generated number: 0.69190651510286, Running sum: 10.739090106657267
Generated number: 0.005736637843511527, Running sum: 10.744826744500779
Generated number: 0.3530814394608047, Running sum: 11.097908183961584
Generated number: 0.45161125495213583, Running sum: 11.54951943891372
Generated number: 0.7830797868656116, Running sum: 12.332599225779331
Generated number: 0.06329207105482504, Running sum: 12.395891296834156
Generated number: 0.1527139191508291, Running sum: 12.548605215984985
Generated number: 0.0285417467456075, Running sum: 12.577146962730593
Generated number: 0.202090797560739, Running sum: 12.779237760291332
Generated number: 0.3099721540550662, Running sum: 13.089209914346398
Generated number: 0.5919871140083159, Running sum: 13.681197028354713
Generated number: 0.893899092128165, Running sum: 14.575096120482879
Generated number: 0.6701368113925597, Running sum: 15.245232931875439
Generated number: 0.6243808461943505, Running sum: 15.86961377806979
Generated number: 0.34629234888410876, Running sum: 16.215906126953897
Generated number: 0.2626617337464846, Running sum: 16.47856786070038
Generated number: 0.7647058314031173, Running sum: 17.243273692103497
Generated number: 0.5150890436285939, Running sum: 17.758362735732092
Generated number: 0.5527383774697928, Running sum: 18.311101113201886
Generated number: 0.7856381059420053, Running sum: 19.096739219143892
Generated number: 0.24343099838787263, Running sum: 19.340170217531764
Generated number: 0.3803137941157858, Running sum: 19.72048401164755
Generated number: 0.5424764066292943, Running sum: 20.262960418276844
Final sum: 20.262960418276844

*/