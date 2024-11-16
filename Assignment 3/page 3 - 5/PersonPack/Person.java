package PersonPack;

import FlatPack.Flat;

public class Person {
    private int PIDNumber;
    private String name;
    private Flat flat;
    
    public Person(int PIDNumber, String name) {
        this.PIDNumber = PIDNumber;
        this.name = name;
        this.flat = null;
    }

    public int getPIDNumber() {
        return PIDNumber;
    }

    public void setPIDNumber(int PIDNumber) {
        this.PIDNumber = PIDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public static void displayOwnershipInfo(int PIDNumber) {
        
        System.out.println("Ownership Information for PID Number: " + PIDNumber);
    
        Person p = new Person(1001, "Rajesh Gulatti");
        Flat f = new Flat("Sunrise Apartments", "A101", 2);
        p.setFlat(f);

        System.out.println("Person : " + p.getName());
        System.out.println("PID Number : " + p.getPIDNumber());
        f.dispFlatInfo();
    }
}
