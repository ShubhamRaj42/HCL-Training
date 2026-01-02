
import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();

        // add()
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Mango");
        System.out.println("list1 : " + list1);

        // add(index, element)
        list1.add(1, "Orange");
        System.out.println("After add(index): " + list1);

        // get()
        System.out.println("Element at index 2: " + list1.get(2));

        // set()
        list1.set(0, "Grapes");
        System.out.println("After set(): " + list1);

        // remove(index)
        list1.remove(1);
        System.out.println("After remove(index): " + list1);

        // remove(object)
        list1.remove("Mango");
        System.out.println("After remove(object): " + list1);

        // size()
        System.out.println("Size of list1: " + list1.size());

        // contains()
        System.out.println("Contains Banana? " + list1.contains("Banana"));

        // indexOf()
        System.out.println("Index of Banana: " + list1.indexOf("Banana"));

        // isEmpty()
        System.out.println("Is list1 empty? " + list1.isEmpty());

        // -------- Constructor 2 --------
        ArrayList<String> list2 = new ArrayList<>(5);
        list2.add("Banana");
        list2.add("Apple");
        System.out.println("list2 : " + list2);

        // addAll()
        list1.addAll(list2);
        System.out.println("After addAll(): " + list1);

        // -------- Constructor 3 --------
        ArrayList<String> list3 = new ArrayList<>(list1);
        System.out.println("list3 : " + list3);

        // removeAll()
        list3.removeAll(list2);
        System.out.println("After removeAll(): " + list3);

        // retainAll()
        list1.retainAll(list2);
        System.out.println("After retainAll(): " + list1);

        // toString()
        System.out.println("Using toString(): " + list1.toString());

        // clear()
        list1.clear();
        System.out.println("After clear(): " + list1);
    }
}
