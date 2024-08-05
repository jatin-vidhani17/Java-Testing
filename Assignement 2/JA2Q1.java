import java.util.Scanner;
class arrayfunc{
    private double[] arr;

    private void setValues(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter The Length Of the Array : ");
        int num = scan.nextInt();
        scan.nextLine();
        if(num <= 0){
            System.out.print("Invalid Length!!");
            return;
        }
        arr = new double[num];
        for(int i = 0;i<num;i++){
            System.out.print("Enter The Value At "+ (i+1) +" : ");
            arr[i] = scan.nextDouble();
            scan.nextLine();
        }
    }
    
    private void getValues(){
        System.out.println("\nThe Length Of Array is : " + arr.length);
        System.out.print("Values are : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");      
        }
        System.out.println();
    }

    private void getArray(){
        System.out.print("\nValues are : ");
        for (double element : arr) {
            System.out.print(element + " ");      
        }
        System.out.println();
    }

    private double sumSquare(){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr[i];
        }
        return sum;
    }

    private void meanMedian(){
        double mean = 0;
        for (int i = 0; i < arr.length; i++) {
            mean += arr[i];    
        }
        mean = mean/arr.length;
        
    }
    public static void main(String[] args) {
        arrayfunc arr1 = new arrayfunc();
        arr1.setValues();
        arr1.getValues();
        arr1.getArray();
        System.out.println("The Sum Of The Squares of Array is : " + arr1.sumSquare());
    }
}