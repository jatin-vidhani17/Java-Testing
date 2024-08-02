import java.util.Scanner;

class CurrencyConverter {

    float amount;

    void inrToUsd() 
    {
        float value = amount * 0.01218f;
        System.out.printf("Rs. %.2f = %.2f $%n", amount, value);
    }


    void usdToInr() 
    {
        float value = amount * 82.19f; // Example conversion rate
        System.out.printf("$%.2f = Rs. %.2f%n", amount, value);
    }


   void eurToInr()
   {
        float value = amount * 90.19f; // Example conversion rate
        System.out.printf("€%.2f = Rs. %.2f%n", amount, value);
   }


    void inrToEur() {
        float value = amount * 0.01114f;
        System.out.printf("Rs. %.2f = %.2f Euros%n", amount, value);
    }

    void jpyToInr() 
    {
        float value = amount * 0.61f; // Example conversion rate
        System.out.printf("¥%.2f = Rs. %.2f%n", amount, value);
    }

    void inrToJpy() 
    {
        float value = amount * 1.7258f;
        System.out.printf("Rs. %.2f = %.2f Yens%n", amount, value);
    }

    void gbpToInr() 
    {
        float value = amount * 101.27f; // Example conversion rate
        System.out.printf("£%.2f = Rs. %.2f%n", amount, value);
    }

    void inrToGbp() 
    {
        float value = amount * 0.0095f;
        System.out.printf("Rs. %.2f = %.2f Pounds%n", amount, value);
    }

    void usdToEur() 
    {
        float value = amount * 0.92f; // Example conversion rate
        System.out.printf("$%.2f = %.2f Euros%n", amount, value);
    }

    void eurToUsd() 
    {
        float value = amount * 1.09f; // Example conversion rate
        System.out.printf("€%.2f = $%.2f%n", amount, value);
    }

    void usdToJpy() 
    {
        float value = amount * 143.90f; // Example conversion rate
        System.out.printf("$%.2f = ¥%.2f%n", amount, value);
    }

    void jpyToUsd() 
    {
        float value = amount * 0.0069f; // Example conversion rate
        System.out.printf("¥%.2f = $%.2f%n", amount, value);
    }

    void eurToJpy() 
    {
        float value = amount * 158.22f; // Example conversion rate
        System.out.printf("€%.2f = ¥%.2f%n", amount, value);
    }

    void jpyToEur() 
    {
        float value = amount * 0.0063f; // Example conversion rate
        System.out.printf("¥%.2f = €%.2f%n", amount, value);
    }

    void gbpToUsd() 
    {
        float value = amount * 1.23f; // Example conversion rate
        System.out.printf("£%.2f = $%.2f%n", amount, value);
    }

    void usdToGbp() 
    {
        float value = amount * 0.81f; // Example conversion rate
        System.out.printf("$%.2f = £%.2f%n", amount, value);
    }

    void gbpToEur() 
    {
        float value = amount * 1.14f; // Example conversion rate
        System.out.printf("£%.2f = %.2f Euros%n", amount, value);
    }

    void eurToGbp() 
    {
        float value = amount * 0.88f; // Example conversion rate
        System.out.printf("€%.2f = £%.2f%n", amount, value);
    }
    void gbpToJpy() 
    {
        float value = amount * 176.15f; // Example conversion rate
        System.out.printf("£%.2f = ¥%.2f%n", amount, value);
    }

    void jpyToGbp() 
    {
        float value = amount * 0.0057f; // Example conversion rate
        System.out.printf("¥%.2f = £%.2f%n", amount, value);
    }

     
    void setAmount(float value) 
    {
        amount = value;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sourceCurrency, targetCurrency;
        float value;

        System.out.println("Enter the amount:");
        value = scan.nextFloat();

        CurrencyConverter converter = new CurrencyConverter();
        converter.setAmount(value);

        System.out.println("Select the source currency:");
        System.out.println("1) INR \n2) USD \n3) EUR \n4) JPY \n5) GBP");
        sourceCurrency = scan.nextInt();

        System.out.println("Select the target currency:");
        System.out.println("1) INR \n2) USD \n3) EUR \n4) JPY \n5) GBP ");
        targetCurrency = scan.nextInt();

        switch (sourceCurrency) {
            case 1: // INR
                switch (targetCurrency) {
                    case 1:
                        System.out.printf("Rs. %.2f = Rs. %.2f%n", value, value);
                        break;
                    case 2:
                        converter.inrToUsd();
                        break;
                    case 3:
                        converter.inrToEur();
                        break;
                    case 4:
                        converter.inrToJpy();
                        break;
                    case 5:
                        converter.inrToGbp();
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        break;
                }
                break;
            case 2: // USD
                switch (targetCurrency) {
                    case 1:
                        converter.usdToInr();
                        break;
                    case 2:
                        System.out.printf("$%.2f = $%.2f%n", value, value);
                        break;
                    case 3:
                        converter.usdToEur();
                        break;
                    case 4:
                        converter.usdToJpy();
                        break;
                    case 5:
                        converter.usdToGbp();
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        break;
                }
                break;
            case 3: // EUR
                switch (targetCurrency) {
                    case 1:
                        converter.eurToInr();
                        break;
                    case 2:
                        converter.eurToUsd();
                        break;
                    case 3:
                        System.out.printf("€%.2f = €%.2f%n", value, value);
                        break;
                    case 4:
                        converter.eurToJpy();
                        break;
                    case 5:
                        converter.eurToGbp();
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        break;
                }
                break;
            case 4: // JPY
                switch (targetCurrency) {
                    case 1:
                        converter.jpyToInr();
                        break;
                    case 2:
                        converter.jpyToUsd();
                        break;
                    case 3:
                        converter.jpyToEur();
                        break;
                    case 4:
                        System.out.printf("¥%.2f = ¥%.2f%n", value, value);
                        break;
                    case 5:
                        converter.jpyToGbp();
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        break;
                }
                break;
            case 5: // GBP
                switch (targetCurrency) {
                    case 1:
                        converter.gbpToInr();
                        break;
                    case 2:
                        converter.gbpToUsd();
                        break;
                    case 3:
                        converter.gbpToEur();
                        break;
                    case 4:
                        converter.gbpToJpy();
                        break;
                    case 5:
                        System.out.printf("£%.2f = £%.2f%n", value, value);
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                        break;
                }
                break;
            default:
                System.out.println("Invalid source currency.");
                break;
        }

        scan.close();
    }
}
/*

Output : 

PS C:\TP> java Main
Enter the amount:
100000
Select the source currency:
1) INR
2) USD
3) EUR
5) GBP
2
Select the target currency:
1) INR
2) USD
3) EUR
4) JPY
5) GBP
1
$100000.00 = Rs. 8219000.00
PS C:\TP> java Main
Enter the amount:
50 
Select the source currency:
1) INR
2) USD
3) EUR
4) JPY
5) GBP
3
Select the target currency:
1) INR
2) USD
3) EUR
4) JPY
5) GBP
4
â?¬50.00 = ?¥7911.00
PS C:\TP>

*/