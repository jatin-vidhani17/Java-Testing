
/*
    2. (II) Read an IP address from user in the form of - 192.11.12.112.
    Separate each part from ‘.’ and store it in an array using StringTokenizer.

*/

import java.util.Scanner;
import java.util.StringTokenizer;

public class IPAddress {
    private String ipAddr;

    public IPAddress(String ip){
        this.ipAddr = ip;
    }

    public boolean validateIPAddress(){
        try {
            String num = "";
            int dotCounter = 0;

            for (int i = 0; i < this.ipAddr.length(); i++) {
                char currentChar = this.ipAddr.charAt(i);
                
                if (currentChar != '.') {
                    num += currentChar;
                } else {
                    // Check if there is an empty octet between dots
                    if (num.isEmpty()) {
                        return false;
                    }
                    int val = Integer.parseInt(num);
                    // Validate the value of the octet
                    if (val < 0 || val > 255) {
                        return false;
                    }
                    // Check for leading zeros
                    if (num.length() > 1 && num.charAt(0) == '0') {
                        return false;
                    }
                    num = "";  // Reset for the next octet
                    dotCounter++;
                }
            }

            // Process the last octet after the last dot
            if (num.isEmpty()) {
                return false;
            }

            int lastVal = Integer.parseInt(num);
            if (lastVal < 0 || lastVal > 255) {
                return false;
            }
            // Check for leading zeros in the last part
            if (num.length() > 1 && num.charAt(0) == '0') {
                return false;
            }

            // Ensure exactly 3 dots (4 octets)
            if (dotCounter != 3) {
                return false;
            }

            return true;
        } catch (Exception e) {
            // If parsing fails or any exception occurs, return false
            return false;
        }
    }

    public void displayIPAddressInArray(){
        StringTokenizer tokenizer = new StringTokenizer(ipAddr, ".");
        String[] ipParts = new String[4];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            ipParts[i] = tokenizer.nextToken();
            i++;
        }

        System.out.println("The parts of the IP address are:");
        for (String part : ipParts) {
            System.out.println(part);
        }
        

        
    }


    public static void main(String[] args){
        System.out.print("Enter IP Address in format (0-255.0-255.0-255.0-255): ");
        Scanner input = new Scanner(System.in);

        String IP = input.nextLine();

        IPAddress ipObj = new IPAddress(IP);
        if (!ipObj.validateIPAddress()){
            System.out.println("You have entered invalid IP Address");
        }else{
            ipObj.displayIPAddressInArray();
        }
    }
}
