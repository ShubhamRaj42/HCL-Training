import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

public class TreeMapDemo {

    public static void main(String[] args) {

        // Constructor 1
        TreeMap<Integer, String> t1 = new TreeMap<>();

        // put()
        t1.put(3, "Mango");
        t1.put(1, "Apple");
        t1.put(2, "Banana");
        System.out.println("t1 : " + t1);

        // get()
        System.out.println("Value for key 2: " + t1.get(2));

        // remove()
        t1.remove(3);
        System.out.println("After remove(): " + t1);

        // containsKey()
        System.out.println("Contains key 1? " + t1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Banana? " + t1.containsValue("Banana"));

        // size()
        System.out.println("Size of t1: " + t1.size());

        // isEmpty()
        System.out.println("Is t1 empty? " + t1.isEmpty());

        // firstKey()
        System.out.println("First Key: " + t1.firstKey());

        // lastKey()
        System.out.println("Last Key: " + t1.lastKey());

        // keySet()
        System.out.println("Keys: " + t1.keySet());

        // values()
        System.out.println("Values: " + t1.values());

        // entrySet()
        System.out.println("Entries: " + t1.entrySet());

        // Constructor 2
        TreeMap<Integer, String> t2 = new TreeMap<>(Comparator.reverseOrder());
        t2.put(1, "One");
        t2.put(2, "Two");
        t2.put(3, "Three");
        System.out.println("t2 (Reverse Order): " + t2);

        // Constructor 3
        TreeMap<Integer, String> t3 = new TreeMap<>(t1);
        System.out.println("t3 : " + t3);

        // Constructor 4
        SortedMap<Integer, String> sm = new TreeMap<>();
        sm.put(5, "Orange");
        sm.put(6, "Grapes");

        TreeMap<Integer, String> t4 = new TreeMap<>(sm);
        System.out.println("t4 : " + t4);

        // putAll()
        t3.putAll(t4);
        System.out.println("After putAll(): " + t3);

        // higherKey()
        System.out.println("Higher key than 2: " + t3.higherKey(2));

        // clear()
        t3.clear();
        System.out.println("After clear(): " + t3);
    }
}
