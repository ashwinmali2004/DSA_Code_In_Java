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

        // New TreeMap with Integer keys and Integer values
        TreeMap<Integer, Integer> intTreeMap = new TreeMap<>();

        // Adding elements
        intTreeMap.put(10, 100);
        intTreeMap.put(20, 200);
        intTreeMap.put(30, 300);
        intTreeMap.put(40, 400);
        intTreeMap.put(50, 500);

        System.out.println("\nTreeMap with Integer keys and Integer values:");
        for (Map.Entry<Integer, Integer> entry : intTreeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Demonstrating methods like ceilingKey, floorKey, higherKey, lowerKey
        System.out.println("\nMethods with TreeMap<Integer, Integer>:");

        // ceilingKey - Returns the least key greater than or equal to the given key
        System.out.println("Ceiling of 25: " + intTreeMap.ceilingKey(25)); // Should return 30

        // floorKey - Returns the greatest key less than or equal to the given key
        System.out.println("Floor of 25: " + intTreeMap.floorKey(25)); // Should return 20

        // higherKey - Returns the least key strictly greater than the given key
        System.out.println("Higher than 25: " + intTreeMap.higherKey(25)); // Should return 30

        // lowerKey - Returns the greatest key strictly less than the given key
        System.out.println("Lower than 25: " + intTreeMap.lowerKey(25)); // Should return 20
    }
}

// Question no 981. Leetcode which uses above functionality