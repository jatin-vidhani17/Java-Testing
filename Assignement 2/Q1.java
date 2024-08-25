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
	
    public void setValues(){
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
    
    // public void getArray(){
    //     System.out.println("\nThe length Of array is : " + arr.length);
    //     System.out.print("Values are : ");
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i]+" ");      
    //     }
    //     System.out.println();
    // }

    public void getValues(){
        System.out.println("\nThe length Of array is : " + arr.length);
        System.out.print("\nValues are : ");
        for (double element : arr) {
            System.out.print(element + " ");      
        }
        System.out.println();
    }

    public double sumSquare(){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr[i];
        }
        return sum;
    }

    public void insertionSort(int order){
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
    

    public void bubbleSort(int order){
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

    public double meanOfArray(){
        double mean = 0;
        for (int i = 0; i < arr.length; i++) {
            mean += arr[i];    
        }
        mean = mean/arr.length;
        return mean;
    }

    public void chooseSortingTechnique(int order){
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

    public double medianOfArray() {
        this.insertionSort(1);
        int length = arr.length;
        int middle = length / 2;
        if (length % 2 == 0) {
            return (arr[middle - 1] + arr[middle]) / 2.0;
        } else {
            return arr[middle];
        }
    }

    public int linearSearch(double value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void reverseArray(){
        double temp;
        for(int i=0;i<arr.length/2;i++){
            temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i -1] = temp;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arrayfunc arr1 = new arrayfunc();
        arr1.setValues();
        
        boolean running = true;
        
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display array values");
            System.out.println("2. Sum of squares");
            System.out.println("3. Sort array");
            System.out.println("4. Calculate Mean");
            System.out.println("5. Calculate Median");
            System.out.println("6. Search value");
            System.out.println("7. Reverse array");
            System.out.println("8. Exit");
            System.out.print("Enter Choice : ");

            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    arr1.getValues();
                    break;

                case 2:
                    System.out.println("The Sum Of the squares of the array is: " + arr1.sumSquare());
                    break;

                case 3:
                    System.out.print("Enter an Order of sorting the array: \nPress 1 for Ascending.\nPress 2 for Descending.\nEnter Choice: ");
                    int order = scan.nextInt();
                    scan.nextLine(); // Consume newline character
                    arr1.chooseSortingTechnique(order);
                    arr1.getValues();
                    break;

                case 4:
                    System.out.println("The Mean of the array is: " + arr1.meanOfArray());
                    break;

                case 5:
                    System.out.println("The Median of the array is: " + arr1.medianOfArray());
                    break;

                case 6:
                    System.out.print("Enter a value to be searched in the array: ");
                    double num = scan.nextDouble();
                    scan.nextLine(); // Consume newline character
                    int index = arr1.linearSearch(num);
                    if (index == -1) {
                        System.out.println("The Number " + num + " is not Found In The Array.");
                    } else {
                        System.out.println("The Number " + num + " is Found at index " + index + ".");
                    }
                    break;

                case 7:
                    arrayfunc arr2 = new arrayfunc(arr1); // Array Copied
                    arr2.reverseArray();
                    arr2.getValues();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        }
        
        scan.close();
    }
}
/*

Output : 

Enter the length of the array : 7
Enter the value at 1 : 15000
Enter the value at 2 : 32400
Enter the value at 3 : 25255.03
Enter the value at 4 : 400.99
Enter the value at 5 : 123.321
Enter the value at 6 : -565.55
Enter the value at 7 : -650.56

Select an option:      
1. Display array values
2. Sum of squares
3. Sort array
4. Calculate Mean
5. Calculate Median
6. Search value
7. Reverse array
8. Exit
Enter Choice : 7

The length Of array is : 7

Values are : -650.56 -565.55 123.321 400.99 25255.03 32400.0 15000.0

Select an option:
1. Display array values
2. Sum of squares
3. Sort array
4. Calculate Mean
5. Calculate Median
6. Search value
7. Reverse array
8. Exit
Enter Choice : 5
The Median of the array is: 400.99

Select an option:
1. Display array values
2. Sum of squares
3. Sort array
4. Calculate Mean
5. Calculate Median
6. Search value
7. Reverse array
8. Exit
Enter Choice : 1

The length Of array is : 7

Values are : -650.56 -565.55 123.321 400.99 15000.0 25255.03 32400.0

Select an option:
1. Display array values
2. Sum of squares
3. Sort array
4. Calculate Mean
5. Calculate Median
6. Search value
7. Reverse array
8. Exit
Enter Choice : 6
Enter a value to be searched in the array: 1500 
The Number 1500.0 is not Found In The Array.

Select an option:
1. Display array values
2. Sum of squares
3. Sort array
4. Calculate Mean
5. Calculate Median
6. Search value
7. Reverse array
8. Exit
Enter Choice : 3
Enter an Order of sorting the array: 
Press 1 for Ascending.
Press 2 for Descending.
Enter Choice: 2

Enter the sorting technique for the array :
(1) Insertion Sort.
(2) Bubble Sort.
Enter Choice : 1 

The length Of array is : 7

Values are : 32400.0 25255.03 15000.0 400.99 123.321 -565.55 -650.56

Select an option:
1. Display array values
2. Sum of squares
3. Sort array
4. Calculate Mean
5. Calculate Median
6. Search value
7. Reverse array
8. Exit
Enter Choice : 8
Exiting...

*/
