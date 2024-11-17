/*
 6) WAP in JAVA that calculates the VAT on an amount of sale. The program takes amount of
    sales and VAT rate as input and outputs the total amount
    inclusive of VAT.
*/
class vatPercent {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the amount of sale and VAT rate as command line arguments.");
            return;
        }
        double amountOfSale = Double.parseDouble(args[0]);
        double vatRate = Double.parseDouble(args[1]);
        double vatAmount = (vatRate / 100) * amountOfSale;
        double totalAmount = amountOfSale + vatAmount;
        System.out.println("VAT Amount : " + vatAmount);
        System.out.println("Total Amount (inclusive of VAT) : " + totalAmount);
    }
}
/*

Output : 

C:\Assignment 1\BasicProgram> java vatPercent 656 15
VAT Amount : 98.39999999999999
Total Amount (inclusive of VAT) : 754.4

*/