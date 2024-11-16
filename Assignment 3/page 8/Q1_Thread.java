import java.util.Scanner;

class PrimeThread extends Thread {
    private long sleepTime;
    private T1Thread t1Thread;
    private boolean isRunning = true;
    
    public PrimeThread(long sleepTime, T1Thread t1Thread) {
        this.sleepTime = sleepTime;
        this.t1Thread = t1Thread;
    }

    @Override
    public void run() {
        long num = 2;
        while (isRunning) {
            if (isPrime(num)) {
                System.out.println("Prime Number: " + num);
                if (num == 13) {
                    try {
                        System.out.println("Prime thread printed 13. T1 going to wait...");
                        synchronized (t1Thread) {
                            t1Thread.wait();  // T1 goes into wait mode when prime thread prints 13
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num == 79) {
                    synchronized (t1Thread) {
                        t1Thread.notify();  // Resume T1 when prime thread prints 79
                    }
                    System.out.println("Prime thread printed 79. T1 resumed.");
                }
            }
            num++;
            try {
                Thread.sleep(sleepTime);  // Sleep for the user-defined time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper function to check if a number is prime
    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void stopThread() {
        isRunning = false;
    }
}

class T1Thread extends Thread {
    private boolean stopRequested = false;

    public void stopThread() {
        stopRequested = true;
    }

    @Override
    public void run() {
        while (!stopRequested) {
            System.out.println("T1 is doing work...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T1 thread stopped.");
    }
}

class T2Thread extends Thread {
    private boolean stopRequested = false;

    public void stopThread() {
        stopRequested = true;
    }

    @Override
    public void run() {
        while (!stopRequested) {
            System.out.println("T2 is doing work...");
            try {
                Thread.sleep(2000);  // T2 does work every 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T2 thread stopped.");
    }
}

class MultiThreadedPrime {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long mainThreadSleepTime = 500;
        long primeThreadSleepTime = 1000;

        T1Thread t1Thread = new T1Thread();
        T2Thread t2Thread = new T2Thread();
        PrimeThread primeThread = new PrimeThread(primeThreadSleepTime, t1Thread);

        boolean exitProgram = false;
        while (!exitProgram) {

            System.out.println("\n----- Menu -----");
            System.out.println("1. Start Prime Number Generator Thread");
            System.out.println("2. Start T1 Thread");
            System.out.println("3. Start T2 Thread");
            System.out.println("4. Stop Prime Number Generator Thread");
            System.out.println("5. Stop T1 Thread");
            System.out.println("6. Stop T2 Thread");
            System.out.println("7. Set Sleep Time for Threads");
            System.out.println("8. Exit Program");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    if (!primeThread.isAlive()) {
                        primeThread.start();
                        System.out.println("Prime Number Generator Thread started.");
                    } else {
                        System.out.println("Prime Number Generator Thread is already running.");
                    }
                    break;

                case 2:
                    if (!t1Thread.isAlive()) {
                        t1Thread.start();
                        System.out.println("T1 Thread started.");
                    } else {
                        System.out.println("T1 Thread is already running.");
                    }
                    break;

                case 3:
                    if (!t2Thread.isAlive()) {
                        t2Thread.start();
                        System.out.println("T2 Thread started.");
                    } else {
                        System.out.println("T2 Thread is already running.");
                    }
                    break;

                case 4:
                    if (primeThread.isAlive()) {
                        primeThread.stopThread();
                        System.out.println("Prime Number Generator Thread stopped.");
                    } else {
                        System.out.println("Prime Number Generator Thread is not running.");
                    }
                    break;

                case 5:
                    if (t1Thread.isAlive()) {
                        t1Thread.stopThread();
                        System.out.println("T1 Thread stopped.");
                    } else {
                        System.out.println("T1 Thread is not running.");
                    }
                    break;

                case 6:
                    if (t2Thread.isAlive()) {
                        t2Thread.stopThread();
                        System.out.println("T2 Thread stopped.");
                    } else {
                        System.out.println("T2 Thread is not running.");
                    }
                    break;

                case 7:
                    System.out.print("Enter sleep time for main thread (in milliseconds): ");
                    mainThreadSleepTime = scan.nextLong();
                    System.out.print("Enter sleep time for prime number thread (in milliseconds): ");
                    primeThreadSleepTime = scan.nextLong();
                    primeThread = new PrimeThread(primeThreadSleepTime, t1Thread);
                    System.out.println("Sleep times updated.");
                    break;

                case 8:

                    exitProgram = true;
                    if (primeThread.isAlive()) {
                        primeThread.stopThread();
                    }
                    if (t1Thread.isAlive()) {
                        t1Thread.stopThread();
                    }
                    if (t2Thread.isAlive()) {
                        t2Thread.stopThread();
                    }
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }

        try {
            if (primeThread.isAlive()){
                primeThread.join();
            } if (t1Thread.isAlive()){
                t1Thread.join();
            } if (t2Thread.isAlive()){
                t2Thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/*
 
Output : 

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 1
Prime Number Generator Thread started.

Prime Number: 2
Prime Number: 3
Prime Number: 5
Prime Number: 7
Prime Number: 11
Prime Number: 13
Prime thread printed 13. T1 going to wait...
Prime Number: 17
Prime Number: 19

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 2
T1 Thread started.

T1 is doing work...
T1 is doing work...
T1 is doing work...
T1 is doing work...

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 3
T2 Thread started.

T2 is doing work...
T2 is doing work...

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 7
Enter sleep time for main thread (in milliseconds): 800
Enter sleep time for prime number thread (in milliseconds): 1200
Sleep times updated.

Prime Number: 23
Prime Number: 29
Prime Number: 31
Prime Number: 37
Prime Number: 41
Prime Number: 43
Prime Number: 47

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 4
Prime Number Generator Thread stopped.

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 5
T1 Thread stopped.

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 6
T2 Thread stopped.

----- Menu -----
1. Start Prime Number Generator Thread
2. Start T1 Thread
3. Start T2 Thread
4. Stop Prime Number Generator Thread
5. Stop T1 Thread
6. Stop T2 Thread
7. Set Sleep Time for Threads
8. Exit Program
Choose an option: 8
Exiting program.

*/