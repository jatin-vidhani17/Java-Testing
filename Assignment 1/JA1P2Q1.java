import java.util.Scanner;

class Person {
    private static int nextId = 10001;
    private int id;
    private String name;
    private int age;
    private String gender;
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }

    public void getDetails() {
        System.out.println("\nPerson ID : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Gender : " + this.gender);
    }
    
    public void setDetails(){
        int userAge;
        id = nextId++;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Name : ");
        name = scan.nextLine();
        System.out.print("Enter Age : ");
        userAge = scan.nextInt();
        age = userAge;
        System.out.print("Enter Gender : ");
        gender = scan.next();
        scan.close();
    }

    public static void main(String[] args){
        Person p1 = new Person();
        p1.setDetails();
        p1.getDetails();
    }
}
/*

Output : 

Enter Name : Umar Shaikh
Enter Age : 20
Enter Gender : male

Person ID : 10001
Name : Umar Shaikh
Age : 20
Gender : male

*/