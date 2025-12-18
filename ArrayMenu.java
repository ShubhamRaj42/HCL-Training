import java.util.Scanner;

class ArrayMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array:");
        int p = sc.nextInt();
        int arr[] = new int[p];
        int n = 0;
        int choice;

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert Element");
            System.out.println("2. Delete Element");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum Value");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
             System.out.println("8. Program exited.");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: // Insert
                    System.out.print("Enter element to insert: ");
                    arr[n] = sc.nextInt();
                    n++;
                    break;

                case 2: // Delete
                    System.out.print("Enter element to delete: ");
                    int del = sc.nextInt();
                    int pos = -1;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] == del) {
                            pos = i;
                            break;
                        }
                    }

                    if (pos != -1) {
                        for (int i = pos; i < n - 1; i++) {
                            arr[i] = arr[i + 1];
                        }
                        n--;
                        System.out.println("Element deleted.");
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 3: // Linear Search
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] == key) {
                            System.out.println("Element found at position " + (i + 1));
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Element not found.");
                    break;

                case 4: // Binary Search (array must be sorted)
                    System.out.print("Enter element to search: ");
                    int bkey = sc.nextInt();

                    int low = 0, high = n - 1;
                    boolean bfound = false;

                    while (low <= high) {
                        int mid = (low + high) / 2;

                        if (arr[mid] == bkey) {
                            System.out.println("Element found at position " + (mid + 1));
                            bfound = true;
                            break;
                        } else if (arr[mid] < bkey) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }

                    if (!bfound)
                        System.out.println("Element not found.");
                    break;

                case 5: // Find Maximum
                    int max = arr[0];
                    for (int i = 1; i < n; i++) {
                        if (arr[i] > max)
                            max = arr[i];
                    }
                    System.out.println("Maximum value = " + max);
                    break;

                case 6: // Count Even & Odd
                    int even = 0, odd = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0)
                            even++;
                        else
                            odd++;
                    }
                    System.out.println("Even count = " + even);
                    System.out.println("Odd count = " + odd);
                    break;

                case 7: // Insertion Sort
                    for (int i = 1; i < n; i++) {
                        int temp = arr[i];
                        int j = i - 1;

                        while (j >= 0 && arr[j] > temp) {
                            arr[j + 1] = arr[j];
                            j--;
                        }
                        arr[j + 1] = temp;
                    }
                    System.out.println("Array sorted using Insertion Sort.");
                    break;
                case 8:
                    System.out.println("Program exited.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
}
