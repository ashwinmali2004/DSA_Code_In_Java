package HashMap;

public class UsingCustomHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Ashwin");
        map.put(2, "Shyam");
        map.put(3, "Radhey");
        map.put(4, "Ram");
        System.out.println(map.get(3));
        System.out.println(map.containsKey(4));
        map.iterate();
        System.out.println(map.isEmpty());
        System.out.println(map.remove(3));
        map.iterate();
    }
}
