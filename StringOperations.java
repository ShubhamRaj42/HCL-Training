class StringOperations {

    public static void main(String[] args) {
           /*
==================== String vs StringBuffer vs StringBuilder ====================

1) String
--------------------------------------------------------------------------
- Immutable (cannot be changed once created)
- Any modification creates a new object
- Thread-safe because it is immutable


Example:
String s = "Hello";
s = s.concat(" World"); // creates a new object


2) StringBuffer
--------------------------------------------------------------------------
- Mutable (can be changed)
- Thread-safe (methods are synchronized)
- Slower than StringBuilder due to synchronization
- Best used in multi-threaded environments

Example:
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World"); // modifies same object


3) StringBuilder
--------------------------------------------------------------------------
- Mutable (can be changed)
- Not thread-safe
- Best used in single-threaded applications

Example:
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // fastest

*/

        String s1 = "  Hello World  ";
        String s2 = "Hello World";
        String s3 = "Hello";

        // length()
        System.out.println("Length: " + s1.length());

        // isEmpty()
        System.out.println("Is Empty: " + s1.isEmpty());

        // charAt()
        System.out.println("Character at index 1: " + s2.charAt(1));

        // toString()
        StringBuffer sb = new StringBuffer("Java");
        System.out.println("toString(): " + sb.toString());

        // equals()
        System.out.println("Equals: " + s2.equals(s1.trim()));

        // compareTo()
        System.out.println("CompareTo: " + s3.compareTo("Hello"));

        // contains()
        System.out.println("Contains 'Java': " + s2.contains("Java"));

        // indexOf()
        System.out.println("IndexOf 'Java': " + s2.indexOf("Hello"));

        // lastIndexOf()
        System.out.println("LastIndexOf 'o': " + s2.lastIndexOf("o"));

        // startsWith()
        System.out.println("StartsWith 'Hello': " + s2.startsWith("Hello"));

        // endsWith()
        System.out.println("EndsWith 'World': " + s2.endsWith("World"));

        // matches()
        System.out.println("Matches regex: " + s2.matches("[A-Za-z ]+"));

        // substring()
        System.out.println("Substring: " + s2.substring(6, 10));

        // toLowerCase()
        System.out.println("Lowercase: " + s2.toLowerCase());

        // trim()
        System.out.println("Trimmed: '" + s1.trim() + "'");

        // replace()
        System.out.println("Replace: " + s2.replace("Hello", "Bye"));

        // split()
        String words[] = s2.split(" ");
        System.out.println("Split words:");
        for (String w : words) {
            System.out.println(w);
        }

        // join()
        String joined = String.join("-", "Java", "is", "easy");
        System.out.println("Joined String: " + joined);

        // valueOf()
        int num = 100;
        String strNum = String.valueOf(num);
        System.out.println("ValueOf: " + strNum);
    }
}

