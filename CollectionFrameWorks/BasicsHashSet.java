package CollectionFrameWorks;

import java.util.*;

public class BasicsHashSet {
    public static void main(String[] args) {
        //Set are nothing but the keys of the Map--> 

        Set<Integer> mySet = new HashSet<>();
        // Time-complexity-O(1)
        
        // Set<Integer> mySet = new TreeSet<>(Collections.reverseOrder());
        // Time-complexity-O(log(n))

        mySet.add(1);
        mySet.add(1);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        mySet.add(2);

        mySet.remove(1);
        System.out.println(mySet.contains(1));
        System.out.println(mySet.contains(3));
        System.out.println(mySet);

        Iterator<Integer> itr = mySet.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

/* //Printing using the for loop without using the iterator-->
        for (int value : set) {
             System.out.println(value);
        }   
*/
    }

}
