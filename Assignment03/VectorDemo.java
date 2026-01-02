import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {

        // Constructor 1
        Vector<String> v1 = new Vector<>();

        // add()
        v1.add("Apple");
        v1.add("Banana");
        v1.add("Mango");
        System.out.println("v1 : " + v1);

        // addElement()
        v1.addElement("Orange");
        System.out.println("After addElement(): " + v1);

        // get()
        System.out.println("Element at index 1: " + v1.get(1));

        // set()
        v1.set(0, "Grapes");
        System.out.println("After set(): " + v1);

        // remove()
        v1.remove(2);
        System.out.println("After remove(index): " + v1);

        // removeElement()
        v1.removeElement("Orange");
        System.out.println("After removeElement(): " + v1);

        // size()
        System.out.println("Size of v1: " + v1.size());

        // capacity()
        System.out.println("Capacity of v1: " + v1.capacity());

        // contains()
        System.out.println("Contains Banana? " + v1.contains("Banana"));

        // indexOf()
        System.out.println("Index of Banana: " + v1.indexOf("Banana"));

        // isEmpty()
        System.out.println("Is v1 empty? " + v1.isEmpty());

        // Constructor 2
        Vector<String> v2 = new Vector<>(5);
        v2.add("Banana");
        v2.add("Apple");
        System.out.println("v2 : " + v2);

        // addAll()
        v1.addAll(v2);
        System.out.println("After addAll(): " + v1);

        // Constructor 3
        Vector<String> v3 = new Vector<>(3, 2);
        v3.add("Apple");
        v3.add("Banana");
        v3.add("Mango");
        System.out.println("v3 : " + v3);
        System.out.println("v3 capacity: " + v3.capacity());

        // Constructor 4
        Vector<String> v4 = new Vector<>(v1);
        System.out.println("v4 : " + v4);

        // removeAll()
        v4.removeAll(v2);
        System.out.println("After removeAll(): " + v4);

        // retainAll()
        v1.retainAll(v2);
        System.out.println("After retainAll(): " + v1);

        // clear()
        v1.clear();
        System.out.println("After clear(): " + v1);
    }
}
