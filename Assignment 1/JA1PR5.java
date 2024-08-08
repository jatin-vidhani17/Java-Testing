import java.util.Scanner;

class pallindromeCheck{

    static boolean checkPalindrome(String str) {
        str = str.replaceAll("\\s+", ""); 
        str = str.toLowerCase();
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome :");
        String input = scan.nextLine();
        boolean isPalindrome = checkPalindrome(input);

        if (isPalindrome){
            System.out.println("The string \"" + input + "\" is a palindrome.");
        }else{
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }
        scan.close();
    }
}

/*

Output : 

C:\Java Programming>java pallindromeCheck
Enter a string to check if it's a palindrome: 1         2       3       2                                               1
The string "1           2       3       2                                               1       " is a palindrome.

C:\Java Programming>java pallindromeCheck
Enter a string to check if it's a palindrome: sdcdfv
The string "sdcdfv" is not a palindrome.

*/