package HashMap;

import java.util.*;
// import java.util.HashSet;
// import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(2);
        set.add(4);
        set.add(72);
        set.add(28);
        set.add(5);
        set.add(25);
        System.out.println(set);
        set.remove(1);  //remove at the name of the key
        set.remove(2);
        System.out.println(set);
        System.out.println(set.contains(25));

        for (Integer i:set) {
            System.out.println(i);
//            set.remove(i);
        }

        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }

        System.out.println(set);
    }
}
