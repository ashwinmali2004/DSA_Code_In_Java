package CollectionFrameWorks;

import java.util.*;

class ComparablePair implements Comparable<ComparablePair> {
    private String key;
    private int value;

    public ComparablePair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(ComparablePair o) {
        return this.key.compareTo(o.key); // Sorting by key (String)
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

public class TreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap with natural ordering of String keys
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Adding elements
        treeMap.put("Apple", 50);
        treeMap.put("Banana", 30);
        treeMap.put("Mango", 70);
        treeMap.put("Orange", 40);

        // Display TreeMap
        System.out.println("TreeMap Elements:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Checking existence of a key
        System.out.println("Contains Mango? " + treeMap.containsKey("Mango"));

        // Fetching a value
        System.out.println("Value of Banana: " + treeMap.get("Banana"));

        // Removing an element
        treeMap.remove("Apple");
        System.out.println("After removing Apple: " + treeMap);

        // Using TreeMap with ComparablePair
        TreeMap<ComparablePair, String> customTreeMap = new TreeMap<>();
        customTreeMap.put(new ComparablePair("Zebra", 100), "Animal");
        customTreeMap.put(new ComparablePair("Lion", 50), "Wild");
        customTreeMap.put(new ComparablePair("Dog", 20), "Pet");

        System.out.println("\nTreeMap with ComparablePair:");
        for (Map.Entry<ComparablePair, String> entry : customTreeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}