// Create two hash sets {"George", "Jim", "John", "Blake", "Kevin", "Michael"} and {"George", "Katie",
// "Kevin", "Michelle", "Ryan"}, and find their union, difference, and intersection.

import java.util.HashSet;

class HashSetOperations {

    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        HashSet<String> set2 = new HashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        HashSet<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        HashSet<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (Set 1 - Set 2): " + difference);

        HashSet<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
    }
}

/*

Output : 

Set 1: [George, Jim, John, Blake, Kevin, Michael]
Set 2: [George, Katie, Kevin, Michelle, Ryan]
Union: [Jim, John, Blake, Katie, Kevin, Michelle, George, Michael, Ryan]
Difference (Set 1 - Set 2): [Blake, Jim, John, Michael]
Intersection: [George, Kevin]

*/