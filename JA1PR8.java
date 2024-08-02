import java.util.Scanner;

class CoinToss {

    private static final int HEADS = 0;
    private static final int TAILS = 1;

    private int flip() {
        return (int) (Math.random() * 2);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of coin tosses you want to perform:");
        int totalTosses = scan.nextInt();
        if (totalTosses <= 0) {
            System.out.println("The number of tosses must be a positive integer.");
            scan.close();
            return;
        }

        int headsCount = 0;
        int tailsCount = 0;

        CoinToss coinToss = new CoinToss();

        for (int i = 0; i < totalTosses; i++) {
            int result = coinToss.flip();
            if (result == HEADS) {
                headsCount++;
            } else {
                tailsCount++;
            }
        }

        double headsPercentage = (double) headsCount / totalTosses * 100;
        double tailsPercentage = (double) tailsCount / totalTosses * 100;

        System.out.println("Number of Heads: " + headsCount);
        System.out.println("Number of Tails: " + tailsCount);
        System.out.printf("Percentage of Heads: %.2f%%\n", headsPercentage);
        System.out.printf("Percentage of Tails: %.2f%%\n", tailsPercentage);

        scan.close();
    }
}

/*

Output:

Enter the number of coin tosses you want to perform:
100
Number of Heads: 52
Number of Tails: 48
Percentage of Heads: 52.00%
Percentage of Tails: 48.00%

*/