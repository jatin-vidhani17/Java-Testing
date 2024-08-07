import java.util.Scanner;

class arrayfunc{
    private double[] arr;

    arrayfunc(){
    }
    
    arrayfunc(arrayfunc arr1){ // Copy Constructor
		this.arr = new double[arr1.arr.length];
        for(int i=0; i<arr1.arr.length; i++){
            this.arr[i] = arr1.arr[i];
        }
    }
	
    private void setValues(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of the array : ");
        int num = scan.nextInt();
        scan.nextLine();
        if(num <= 0){
            System.out.print("Invalid Length!!");
            return;
        }
        arr = new double[num];
        for(int i = 0;i<num;i++){
            System.out.print("Enter the value at "+ (i+1) +" : ");
            arr[i] = scan.nextDouble();
            scan.nextLine();
        }
    }
    
    // private void getArray(){
    //     System.out.println("\nThe length Of array is : " + arr.length);
    //     System.out.print("Values are : ");
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i]+" ");      
    //     }
    //     System.out.println();
    // }

    private void getValues(){
        System.out.println("\nThe length Of array is : " + arr.length);
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

    private void insertionSort(int order){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;
            if (order == 1) {
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
            else if (order == 2) {
                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
    }
    

    private void bubbleSort(int order){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for(int j=0;j<n-i-1;j++){
               if (order == 1) {
                    if (arr[j] > arr[j + 1]) {
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else if (order == 2) {
                    if (arr[j] < arr[j + 1]) {
                        double temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    private double meanOfArray(){
        double mean = 0;
        for (int i = 0; i < arr.length; i++) {
            mean += arr[i];    
        }
        mean = mean/arr.length;
        return mean;
    }

    private void chooseSortingTechnique(int order){
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the sorting technique for the array : \n(1) Insertion Sort.\n(2) Bubble Sort.\nEnter Choice : ");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            insertionSort(order);
        }
        else if (choice == 2) {
            bubbleSort(order);
        }
        else{
            System.out.println("Invalid Choice!!");
        }
    }

    private double medianOfArray(){
        this.insertionSort(1);
        return arr[(int)arr.length/2];
    }

    private int linearSearch(double value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void reverseArray(){
        double temp;
        for(int i=0;i<arr.length/2;i++){
            temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i -1] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arrayfunc arr1 = new arrayfunc();
        arr1.setValues();
        arr1.getValues();
        // arr1.getArray();
        System.out.println("The Sum Of the squares of array is : " + arr1.sumSquare());
        System.out.print("\nEnter an Order of sorting the array : \nPress 1 For Ascending.\nPress 2 For Descending.\nEnter Choice : ");
        int order = scan.nextInt();
        scan.nextLine();
        arr1.chooseSortingTechnique(order);
        arr1.getValues();
        System.out.println("The Mean of array is : " + arr1.meanOfArray());
        System.out.println("The Median of array is : " + arr1.medianOfArray());
        System.out.print("Enter a value to be searched in the array : ");
        double num = scan.nextDouble();
        scan.nextLine();
        int index = arr1.linearSearch(num);
        if(index == -1){
            System.out.println("The Number "+ num +" is not Found In The Array.");
        }
        else{
            System.out.println("The Number "+num+" is Found at " + index+".");
        }
        
        arrayfunc arr2 = new arrayfunc(arr1); // Array Copied
        arr2.getValues();
        arr2.reverseArray();
        arr2.getValues();
    }
}
