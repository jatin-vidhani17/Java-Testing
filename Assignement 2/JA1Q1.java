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
        for (int i = 0; i < arr.length; i++) {
            double temp;
            if (arr[i] > arr[i+1] && order == 1) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = arr[i];
            }
            else if (arr[i] < arr[i+1] && order == 2){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = arr[i];
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
        System.out.print("Enter The Sorting Technique For The Array : \n(1) Insertion Sort.\n(2) Bubble Sort.\nEnter Choice : ");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            insertionSort(order);
        }
        else if (choice == 2) {
            
        }
    }

    private double medianOfArray(){
        this.insertionSort(1);
        return arr[(int)arr.length/2];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arrayfunc arr1 = new arrayfunc();
        arr1.setValues();
        arr1.getValues();
        arr1.getArray();
        System.out.println("The Sum Of The Squares of Array is : " + arr1.sumSquare());
        System.out.print("Enter an Order of Sorting the Array : \nPress 1 For Ascending.\nPress 2 For Descending.\nEnter Choice : ");
        int order = scan.nextInt();
        scan.nextLine();
        arr1.chooseSortingTechnique(order);
        System.out.println("The Mean of Array is : " + arr1.meanOfArray());
        System.out.println("The Median of Array is : " + arr1.medianOfArray());

    }
}