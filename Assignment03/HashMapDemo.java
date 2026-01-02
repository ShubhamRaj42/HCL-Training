import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        // -------- Constructor 1 --------
        HashMap<Integer, String> map1 = new HashMap<>();

        // put()
        map1.put(1, "Apple");
        map1.put(2, "Banana");
        map1.put(3, "Mango");
        System.out.println("map1 : " + map1);

        // get()
        System.out.println("Value for key 2: " + map1.get(2));

        // remove()
        map1.remove(3);
        System.out.println("After remove(): " + map1);

        // containsKey()
        System.out.println("Contains key 1? " + map1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Banana? " + map1.containsValue("Banana"));

        // size()
        System.out.println("Size of map1: " + map1.size());

        // isEmpty()
        System.out.println("Is map1 empty? " + map1.isEmpty());

        // keySet()
        System.out.println("Keys: " + map1.keySet());

        // values()
        System.out.println("Values: " + map1.values());

        // entrySet()
        System.out.println("Entries: " + map1.entrySet());

        // -------- Constructor 2 --------
        HashMap<Integer, String> map2 = new HashMap<>(5);
        map2.put(4, "Orange");
        map2.put(5, "Grapes");
        System.out.println("map2 : " + map2);

        // -------- Constructor 3 --------
        HashMap<Integer, String> map3 = new HashMap<>(5, 0.75f);
        map3.put(6, "Papaya");
        map3.put(7, "Pineapple");
        System.out.println("map3 : " + map3);

        // -------- Constructor 4 --------
        HashMap<Integer, String> map4 = new HashMap<>(map1);
        System.out.println("map4 : " + map4);

        // putAll()
        map4.putAll(map2);
        System.out.println("After putAll(): " + map4);

        // replace()
        map4.replace(1, "Green Apple");
        System.out.println("After replace(): " + map4);

        // getOrDefault()
        System.out.println("Value for key 10: " + map4.getOrDefault(10, "Not Found"));

        // toString()
        System.out.println("Using toString(): " + map4.toString());

        // clear()
        map4.clear();
        System.out.println("After clear(): " + map4);
    }
}
