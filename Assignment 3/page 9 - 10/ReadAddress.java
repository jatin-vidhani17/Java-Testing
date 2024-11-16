/*

3.(II) Create a java program to read the address from command line arguments, separate the
address by ‘,’ and store the values in variables. (using String tokenizer)

 */

import java.util.StringTokenizer;

public class ReadAddress {
    public static void main(String[] args){
        String address = "";
        for (String addr : args){
            address += addr;
        }

        StringTokenizer addressTokenizer = new StringTokenizer(address, ",");

        String street = null;
        String city = null;
        String state = null;
        String zipCode = null;

        if (addressTokenizer.hasMoreTokens()) street = addressTokenizer.nextToken().trim();
        if (addressTokenizer.hasMoreTokens()) city = addressTokenizer.nextToken().trim();
        if (addressTokenizer.hasMoreTokens()) state = addressTokenizer.nextToken().trim();
        if (addressTokenizer.hasMoreTokens()) zipCode = addressTokenizer.nextToken().trim();


        System.out.println("Street : " + street);
        System.out.println("City : " + city);
        System.out.println("State : " + state);
        System.out.println("Zip Code : " + zipCode);





    }
}
