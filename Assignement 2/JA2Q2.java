import java.util.Scanner;

class arrayClass{
    private int[] arr;

    arrayClass(){
    }

    void menu(){
        System.out.print("-------------MENU-------------\n(1) Add an Element at a Location.\n(2) Display Elements.\n
        (3) Flush the array.\n(4) Exit.\nEnter Choice : ");
    }

    private void setRange(int range){
        arr = new int[range];
    }

    private void addElement(int loc, int data){
        if (loc > arr.length) {
            System.out.println("Index Out Of Bounds.");
        } else if(arr[loc] == null){
            System.out.println("The Index is already ocuupied.");
		} else{
			
		}
	}

    private void getValues(){
        System.out.println("\nThe length Of array is : " + arr.length);
        System.out.print("\nValues are : ");
        for (int element : arr) {
            System.out.print(element + " ");      
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arrayClass arr1 = new arrayClass();
        System.out.print("Enter the range of the array : ");
        int range = scan.nextInt();
        scan.nextLine();
		arr1.setRange(range);
        arr1.menu();
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Enter the location where you want to put the data : ");
                int loc = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter the data you want to add on location (" + loc + ") : ");
                int data = scan.nextInt();
                scan.nextLine();
                arr1.addElement(loc, data);
                break;
        
            default:
                break;
        }
    }
}
