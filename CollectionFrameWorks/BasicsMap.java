package CollectionFrameWorks;
import java.util.*;

public class BasicsMap {
    public static void main(String[] args) {
        Map<Integer, String> classMap = new HashMap<>();

        // Map<Integer, String> classMap = new LinkedHashMap<>();
        // Above LinkedHashMap uses the Hashing+LinkedList technique.

        // Map<Integer, String> classMap = new TreeMap<>();
        // It Automatically sorts on the basis of the key
        // Above TreeMap uses the Hashing+TreeMap(BST+Red Hat Tree) technique.

        classMap.put(1, "Ashwin");
        classMap.put(7, "Ayush");
        // System.out.println(classMap);
        classMap.putIfAbsent(3, "Pavleen");
        // System.out.println(classMap);
        classMap.putIfAbsent(2, "Aashray");
        // System.out.println(classMap);
        classMap.putIfAbsent(11, "Tridib");
    
        System.out.println(classMap);
        classMap.put(1,classMap.getOrDefault(1,"Ashwin")+" Mali");
        classMap.put(6,classMap.getOrDefault(6,"Radhey")+" Shyam");
        System.out.println(classMap);

        System.out.println(classMap.containsKey(4) );
        System.out.println(classMap.containsValue("Aashray"));
        for( Map.Entry<Integer, String> entry : classMap.entrySet())
        {
            System.out.print( "Key: " + entry.getKey() );
            System.out.println( " Value: " + entry.getValue() );
        }
    
    
        for( Integer key : classMap.keySet() )
        {
            System.out.println( "Key: " + key );
        }
    
        for( String value : classMap.values() )
        {
            System.out.println( "Value: " + value );
        }
    
        // Frequency Count
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr= {1,2,3,1,5};
        System.out.println("Frequency Count in an array-->");
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        for( Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            System.out.print( "Key: " + entry.getKey() );
            System.out.println( " Value: " + entry.getValue() );
        }

    }
}
