import java.util.Scanner;

class passwordVallidator {

    public static String validate(String password){
        int digits = 0,chars = 0,specialchars=0,length = password.length();
        boolean hasUppercase = false;
        String temp = password;
        
        for(int i = 0 ; i<length;i++){
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                digits++;
            }else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                chars++;
                hasUppercase = true;
            }
            else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                chars++;
            }else if(password.charAt(i) != ' ' && password.charAt(i) != '\t'){
                specialchars++;
            }
        }
        password = "";
        if (length < 5) {
            password += "Password Should Contain at least 5 Characters.\n";
        }
        else{
            if(digits == 0){
                password += "Password Should Contain at least One Digits.\n";
            }if (chars == 0){
                password += "Password Should Contain at least One Characters.\n";
            }if (!hasUppercase) {
                password += "Password Should Contain at least One Uppercase Character.\n";
            }if (specialchars == 0) {
                password += "Password Should Contain at least One Special Character.\n";
            }else{
                password = temp;
            }
        }

        return password;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Valid Password : ");
        String password = scan.nextLine();
        String temp = password;
        password  = validate(password);
        if (password == temp) {
            System.out.println("Password is Accepted!");
        }else{
            System.out.println("Password is Not Accepted!\n"+password);
        }
    }
}
/*

Output : 

Z://Java Testing
$ java passwordVallidator
Enter a Valid Password : er
Password is Not Accepted!
Password Should Contain at least 5 Characters.

Z://Java Testing
$ java passwordVallidator
Enter a Valid Password : 56566
Password is Not Accepted!
Password Should Contain at least One Characters.
Password Should Contain at least One Uppercase Character.
Password Should Contain at least One Special Character.

*/