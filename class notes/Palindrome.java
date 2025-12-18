import java.util.*;

class Palindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int rev = 0;
        while (n > 0) {
            int b = n % 10;
            rev = rev * 10 + b;
            n /= 10;
        }
        if (rev == n) {

            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a Palindrome");
        }
    }
}