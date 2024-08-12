import java.util.Scanner;

class arrayClass{
    private int[] arr;

    arrayClass(){
    }

    void menu(){
        System.out.print("\n-------------MENU-------------\n(1) Add an Element at a Location.\n(2) Display Elements.\n(3) Flush the array.\n(4) Exit.\nEnter Choice : ");
    }

    private void setRange(int range){
        arr = new int[range];
    }

    private void addElement(int loc, int data){
        if (loc > arr.length) {
            System.out.println("Index Out Of Bounds.");
        } else if(arr[loc] != 0){
            System.out.println("The Index is already ocuupied.");
		} else{
			arr[loc] = data;
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
        int choice;
        do{
            arr1.menu();
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter the location where you want to put the data : ");
                    int loc = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter the data you want to add on location (" + loc + ") : ");
                    int data = scan.nextInt();
                    scan.nextLine();
                    arr1.addElement(loc-1, data);
                    break;
                case 2:
                    arr1.getValues();
                    break;
                case 3:
                    arr1.setRange(0);
                    System.out.println("Array flushed.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while(choice != 4);
        
    }
}

/*

Output : 

Enter the range of the array : 5

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 1
Enter the location where you want to put the data : 5
Enter the data you want to add on location (5) : 96

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 1
Enter the location where you want to put the data : 1
Enter the data you want to add on location (1) : -5

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 2

The length Of array is : 5

Values are : -5 0 0 0 96

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 1
Enter the location where you want to put the data : 3
Enter the data you want to add on location (3) : 98

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 2

The length Of array is : 5

Values are : -5 0 98 0 96

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 3
Array flushed.

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 2

The length Of array is : 0

Values are :

-------------MENU-------------
(1) Add an Element at a Location.
(2) Display Elements.
(3) Flush the array.
(4) Exit.
Enter Choice : 4
Exiting...

*/
