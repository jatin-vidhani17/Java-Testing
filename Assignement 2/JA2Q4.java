// 4) Write and run a JAVA program that reads a string from the user and perform the following.
//  counts number of occurance of a given character (for example, " a") in a string.
//  searches the last occurance of a character in a string.
//  removes the unneccessary spaces from a string : leading and trailing spaces.
//  displays the substring formed by the last ten characters of a string

import java.util.Scanner;

class stringOperation{
    private String str;

    void setString(String str1){
        this.str = str1;
    }

    int[] charOccurence(char ch){
        int count = 0,index =0;
        for(int i = 0 ; i<str.length ;i++){
            if(str.charAt(i) == ch){
                index = i;
                count++;
            }
        }
        int[] arrayCount = {index,count};
        return (arrayCount);
    }

    String[] decreaseSpaces(){
        String[] strArray;
        for (int i = 0; i < str.length; i++) {
            
        }
    }
}
