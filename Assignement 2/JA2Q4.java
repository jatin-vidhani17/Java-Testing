import java.util.Scanner;

class stringOperation{
    private String str;

    void setString(String str1){
        this.str = str1;
    }

    int[] charOccurence(char ch){
        int count = 0,index =0;
        for(int i = 0 ; i<str.length() ;i++){
            if(str.charAt(i) == ch){
                index = i;
                count++;
            }
        }
        int[] arrayCount = {index,count};
        return (arrayCount);
    }

    String decreaseSpaces(){
        return str.trim().replaceAll("\\s+"," ");
    }

    void lastTenChar(){
        for(int i = str.length() - 10;i< str.length();i++){
            System.out.print(str.charAt(i));
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Valid String : ");
        String input = scan.nextLine();
        stringOperation str1 = new stringOperation();
        str1.setString(input);
        System.out.print("Enter a character you want to search : ");
        char ch = scan.nextLine().charAt(0);
        int[] result = str1.charOccurence(ch);
        System.out.println("Last occurrence index of '" + ch + "': " + result[0]);
        System.out.println("Number of occurrences of '" + ch + "': " + result[1]);

        String newStr = str1.decreaseSpaces();
        System.out.print("String After Decreasing Unecessary Space : " + newStr);
        System.out.print("\nSubstring formed by the last ten characters is : ");
        str1.lastTenChar();

    }
}

/*
 
Output : 

Enter a Valid String : Okay Chaliye     ek      Valid String Boliye!!
Enter a character you want to search : a
Last occurrence index of 'a': 26
Number of occurrences of 'a': 3
String After Decreasing Unecessary Space : Okay Chaliye ek Valid String Boliye!!
Substring formed by the last ten characters is : g Boliye!!
 */
