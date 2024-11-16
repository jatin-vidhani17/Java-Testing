package PFPack;

import PersonPack.Person;
import FlatPack.Flat;

public class PFDemo {
    public static void main(String[] args) {
        Person person = new Person(1001, "Rajesh Gulatti");
        Flat flat = new Flat("Sunrise Apartments", "A101", 2);
        person.setFlat(flat);
        Person.displayOwnershipInfo(person.getPIDNumber());
    }
}

/*
 
Output : 

Ownership Information for PID Number: 1001
Person : Rajesh Gulatti
PID Number : 1001
Apartment Name : Sunrise Apartments
Flat Number : A101
Number of Bedrooms : 2

*/