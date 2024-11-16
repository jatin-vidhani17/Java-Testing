/*
3. Implement three classes: Storage, Counter, and Printer.
 The Storage class should store an integer.
 The Counter class should create a thread that starts counting from 0 (0, 1, 2, 3 ...) and
stores each value in the Storage class.
 The Printer class should create a thread that keeps reading the value in the Storage class
and printing it.
 Write a program that creates an instance of the Storage class and sets up a Counter and
a Printer object to operate on it. Ensure that each number is printed exactly once, by
adding suitable synchronization
 */

import java.util.Scanner;

class Storage {
    private int value = 0;
    private boolean isUpdated = false;

    public synchronized void setValue(int value) {
        while (isUpdated) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.value = value;
        isUpdated = true;
        notify();
    }

    public synchronized int getValue() {
        while (!isUpdated) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isUpdated = false;
        notify();
        return value;
    }
}

class Counter extends Thread {
    private Storage storage;
    private int limit;

    public Counter(Storage storage, int limit) {
        this.storage = storage;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            storage.setValue(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Printer extends Thread {
    private Storage storage;
    private int limit;

    public Printer(Storage storage, int limit) {
        this.storage = storage;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            int value = storage.getValue();
            System.out.println("Printed value: " + value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class continuousFlowLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage();
        Counter counter = null;
        Printer printer = null;
        int limit = 0;
        boolean processRunning = false;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Start counting and printing");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of counts/prints: ");
                    limit = scanner.nextInt();

                    if (processRunning) {
                        System.out.println("A counting and printing process is already running. Please wait.");
                        break;
                    }

                    counter = new Counter(storage, limit);
                    printer = new Printer(storage, limit);

                    processRunning = true;
                    counter.start();
                    printer.start();

                    try {
                        counter.join();
                        printer.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    processRunning = false;
                    break;

                case 2:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/*
 
Output : 

Menu:
1. Start counting and printing
2. Exit
Enter your choice: 1
Enter the number of counts/prints: 5
Printed value: 0
Printed value: 1
Printed value: 2
Printed value: 3
Printed value: 4

Menu:
1. Start counting and printing
2. Exit
Enter your choice: 1
Enter the number of counts/prints: 3
Printed value: 5
Printed value: 6
Printed value: 7

Menu:
1. Start counting and printing
2. Exit
Enter your choice: 2
Exiting the program.

*/