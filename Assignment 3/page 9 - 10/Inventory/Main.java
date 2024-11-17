/*
3. (I) Write a program for Inventory.
Create a class Item having attributes:

-> itemId
-> description
-> price
Define the necessary constructors and display methods.

Create a subclass Bill_Item having attributes:

-> quantity
-> amount (amount = quantity * price)
Define the necessary constructors, display methods, and other required methods.

Create a Main class which creates at least 5 items.
Display details of all the items along with the total bill.


*/



package Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("Enter number of Items : ");
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        Item I[] = new Item[size];
        

        for (int i=0; i<size; i++){
            input.nextLine();    
            System.out.printf("Item - %d \n", i+1);
            
            System.out.print("Enter Description : ");
            String descrption = input.nextLine();
            System.out.print("Enter no. of quantity : ");
            int quantity = input.nextInt();
            System.out.print("Enter Item Price : ");
            float price = input.nextFloat();
            
            I[i] = new Item(descrption, price, quantity);
            
            
        }
        int itemCounter = 0;
        System.out.println();
        System.out.println();

        for(Item Items : I){
            System.out.printf("Item - %d Details : \n", itemCounter+1);
            System.out.printf("Item ID : %d \n", Items.getItemId());
            System.out.printf("Item Descrption : %s \n", Items.getItemDescrption());
            System.out.printf("Item Price : %.2f \n", Items.getItemPrice());
            System.out.printf("Item Quantity : %d \n", Items.getItemQuantity());
            System.out.printf("Total Bill Amount for Item ID - %d  : %.2f \n", Items.getItemId(), Items.getBillAmount());
            itemCounter++;
            System.out.println();
            
        }


    }
}
