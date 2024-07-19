import java.util.Scanner;

class BankAccount{
       private static int BankAccId = 100001;
       private int BankAccNumber = 0;
       private String accHolderName;
       private float accBalance;

       void getDetails(){
              System.out.println("Owner : "+accHolderName);
              System.out.println("Acoount Number : "+BankAccNumber);
              System.out.println("Current Balance : "+accBalance);
       }

       void deposit(){
              Scanner scan = new Scanner(System.in);
              if(BankAccNumber == 0){
                     System.out.print("Enter The Name Of Account Holder : ");
                     accHolderName = scan.nextLine();
                     System.out.print("Enter The Amount You Want To Deposit : ");
                     accBalance = scan.nextFloat();
                     if(accBalance < 0){
                            System.out.println("Invalid Amount!!");
                            return ;
                     }
                     else if(accBalance > 600000){
                            accBalance = accBalance - (accBalance*12/100);
                     }
                     BankAccNumber = BankAccId;
                     BankAccId++;
              }
              else if(accBalance!=0){
                     float newBal;
                     System.out.print("Enter The Amount You Want To Deposit : ");
                     newBal = scan.nextFloat();
                     accBalance += newBal; 
              }
              else{
                     System.out.print("Account Doesn't Exists!!\n");
              }
              scan.close();
       }

       void withdraw(){
              Scanner scan = new Scanner(System.in);
              float amount;
              System.out.print("Enter The Amount You Want To Withdraw : ");
              amount = scan.nextFloat();
              if(amount>accBalance){
                     System.out.print("Insufficient Balance!!");
                     return;
              }
              else{
                     accBalance = accBalance - amount;
              }
              scan.close();
       }

       
       public static void main(String[] args){
              
       }
}