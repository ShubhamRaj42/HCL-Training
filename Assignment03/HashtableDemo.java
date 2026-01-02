import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Map;

public class HashtableDemo {

    public static void main(String[] args) {

        // Constructor 1
        Hashtable<Integer, String> h1 = new Hashtable<>();

        // put()
        h1.put(1, "Apple");
        h1.put(2, "Banana");
        h1.put(3, "Mango");
        System.out.println("h1 : " + h1);

        // get()
        System.out.println("Value for key 2: " + h1.get(2));

        // remove()
        h1.remove(3);
        System.out.println("After remove(): " + h1);

        // containsKey()
        System.out.println("Contains key 1? " + h1.containsKey(1));

        // containsValue()
        System.out.println("Contains value Banana? " + h1.containsValue("Banana"));

        // size()
        System.out.println("Size of h1: " + h1.size());

        // isEmpty()
        System.out.println("Is h1 empty? " + h1.isEmpty());

        // keys()
        Enumeration<Integer> k = h1.keys();
        System.out.print("Keys using keys(): ");
        while (k.hasMoreElements()) {
            System.out.print(k.nextElement() + " ");
        }
        System.out.println();

        // elements()
        Enumeration<String> v = h1.elements();
        System.out.print("Values using elements(): ");
        while (v.hasMoreElements()) {
            System.out.print(v.nextElement() + " ");
        }
        System.out.println();

        // keySet()
        System.out.println("KeySet: " + h1.keySet());

        // values()
        System.out.println("Values: " + h1.values());

        // entrySet()
        System.out.println("EntrySet: " + h1.entrySet());

        // Constructor 2
        Hashtable<Integer, String> h2 = new Hashtable<>(5);
        h2.put(4, "Orange");
        h2.put(5, "Grapes");
        System.out.println("h2 : " + h2);

        // Constructor 3
        Hashtable<Integer, String> h3 = new Hashtable<>(5, 0.75f);
        h3.put(6, "Papaya");
        h3.put(7, "Pineapple");
        System.out.println("h3 : " + h3);

        // Constructor 4
        Hashtable<Integer, String> h4 = new Hashtable<>(h1);
        System.out.println("h4 : " + h4);

        // putAll()
        h4.putAll(h2);
        System.out.println("After putAll(): " + h4);

        // replace()
        h4.replace(1, "Green Apple");
        System.out.println("After replace(): " + h4);

        // clear()
        h4.clear();
        System.out.println("After clear(): " + h4);
    }
}
