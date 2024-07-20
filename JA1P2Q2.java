import java.util.Scanner;

class BankAccount {
    private static int BankAccId = 100001;
    private int BankAccNumber = 0;
    private String accHolderName;
    private float accBalance;

    void getDetails() {
        System.out.println("Owner : " + accHolderName);
        System.out.println("Account Number : " + BankAccNumber);
        System.out.println("Current Balance : " + accBalance);
    }

    void deposit() {
        Scanner scan = new Scanner(System.in);

        if (BankAccNumber == 0) {
            System.out.print("\nEnter The Name Of Account Holder: ");
            accHolderName = scan.nextLine();
            System.out.print("Enter The Amount You Want To Deposit: ");
            accBalance = scan.nextFloat();
            if (accBalance < 0) {
                System.out.println("Invalid Amount!!");
                return;
            } else if (accBalance > 600000) {
                accBalance = accBalance - (accBalance * 12 / 100);
            }
            BankAccNumber = BankAccId;
            BankAccId++;
        } else {
            float newBal;
            System.out.print("\nEnter The Amount You Want To Deposit: ");
            newBal = scan.nextFloat();
            if (newBal < 0) {
                System.out.println("Invalid Amount!!");
                return;
            }
            accBalance += newBal;
        }
    }

    void withdraw() {
        Scanner scan = new Scanner(System.in);
        float amount;
        System.out.print("\nEnter The Amount You Want To Withdraw: ");
        amount = scan.nextFloat();
        if (amount > accBalance) {
            System.out.println("Insufficient Balance!!");
            return;
        } else if (amount < 0) {
            System.out.println("Invalid Amount!!");
            return;
        }
        accBalance -= amount;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit();  
        account.getDetails();
        account.deposit();
        account.getDetails();
        account.withdraw();
        account.getDetails();
    }
}
/*

Output : 

Enter The Name Of Account Holder: Krishna Bharadwaj
Enter The Amount You Want To Deposit: 56000
Owner : Krishna Bharadwaj
Account Number : 100001
Current Balance : 56000.0

Enter The Amount You Want To Deposit: 25000
Owner : Krishna Bharadwaj
Account Number : 100001
Current Balance : 81000.0

Enter The Amount You Want To Withdraw: 8000
Owner : Krishna Bharadwaj
Account Number : 100001
Current Balance : 73000.0

*/
