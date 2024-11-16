import java.util.Scanner;

class Account {
    private String accountNumber;
    private String name;
    private double balance;
    private final Object lock = new Object();

    public Account(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void transaction(double amount, String transactionCode) {
        synchronized (lock) {
            if (transactionCode.equalsIgnoreCase("deposit")) {
                balance += amount;
                System.out.println(name + "'s account (" + accountNumber + "): Deposited Rupees " + amount + ". New balance: Rupees " + balance);
            } else if (transactionCode.equalsIgnoreCase("withdrawal")) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println(name + "'s account (" + accountNumber + "): Withdrew Rupees " + amount + ". New balance: Rupees " + balance);
                } else {
                    System.out.println(name + "'s account (" + accountNumber + "): Insufficient balance. Current balance: Rupees " + balance);
                }
            } else {
                System.out.println("Invalid transaction code.");
            }
        }
    }
}

class Teller extends Thread {
    private String tellerName;
    private Account account;
    private double amount;
    private String transactionCode;

    public Teller(String tellerName, Account account, double amount, String transactionCode) {
        this.tellerName = tellerName;
        this.account = account;
        this.amount = amount;
        this.transactionCode = transactionCode;
    }

    @Override
    public void run() {
        System.out.println("Teller " + tellerName + " is processing a " + transactionCode + " for " + account.getName() + "...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.transaction(amount, transactionCode);
    }
}

class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account accountA = new Account("A001", "Customer A", 1000);
        Account accountB = new Account("B001", "Customer B", 1500);
        Account accountC = new Account("C001", "Customer C", 2000);

        while (true) {
            System.out.println("\nEnter the customer name (A, B, or C) to process transactions, or type 'exit' to quit :");
            String customerChoice = scanner.nextLine().toUpperCase();
            if (customerChoice.equals("EXIT")) {
                break;
            }

            Account selectedAccount = null;
            if (customerChoice.equals("A")) {
                selectedAccount = accountA;
            } else if (customerChoice.equals("B")) {
                selectedAccount = accountB;
            } else if (customerChoice.equals("C")) {
                selectedAccount = accountC;
            } else {
                System.out.println("Invalid customer choice. Please choose A, B, or C.");
                continue;
            }

            System.out.println("Enter transaction type (deposit/withdrawal) :");
            String transactionType = scanner.nextLine().toLowerCase();

            System.out.println("Enter transaction amount :");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            Teller teller = new Teller("Teller1", selectedAccount, amount, transactionType);
            teller.start();
            try {
                teller.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Bank system closed.");
        scanner.close();
    }
}
/*
 
Output : 

Enter the customer name (A, B, or C) to process transactions, or type 'exit' to quit :
A
Enter transaction type (deposit/withdrawal) :
d
Enter transaction amount :
10000
Teller Teller1 is processing a d for Customer A...
Invalid transaction code.

Enter the customer name (A, B, or C) to process transactions, or type 'exit' to quit :
B
Enter transaction type (deposit/withdrawal) :
deposit
Enter transaction amount :
1000
Teller Teller1 is processing a deposit for Customer B...
Customer B's account (B001): Deposited Rupees 1000.0. New balance: Rupees 2500.0

Enter the customer name (A, B, or C) to process transactions, or type 'exit' to quit :
C
Enter transaction type (deposit/withdrawal) :
deposit
Enter transaction amount :
500
Teller Teller1 is processing a deposit for Customer C...
Customer C's account (C001): Deposited Rupees 500.0. New balance: Rupees 2500.0

Enter the customer name (A, B, or C) to process transactions, or type 'exit' to quit :
exit
Bank system closed.


*/