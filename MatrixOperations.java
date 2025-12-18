import java.util.Scanner;

class MatrixOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int a[][] = new int[r][c];
        int b[][] = new int[r][c];
        int result[][] = new int[r][c];

        // Input first matrix
        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // Input second matrix
        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        // Addition
        System.out.println("\nAddition of matrices:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = a[i][j] + b[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        // Subtraction
        System.out.println("\nSubtraction of matrices:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = a[i][j] - b[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        // Multiplication
        if (r == c) {
            System.out.println("\nMultiplication of matrices:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < c; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nMultiplication not possible.");
        }

        // Transpose of first matrix
        System.out.println("\nTranspose of first matrix:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(a[j][i] + " ");
            }
            System.out.println();
        }

        // Check square matrix
        if (r == c) {
            System.out.println("\nMatrix is a Square Matrix.");

            // Check diagonal matrix
            boolean diagonal = true;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i != j && a[i][j] != 0) {
                        diagonal = false;
                        break;
                    }
                }
            }

            if (diagonal)
                System.out.println("Matrix is a Diagonal Matrix.");
            else
                System.out.println("Matrix is NOT a Diagonal Matrix.");

            // Check identity matrix
            boolean identity = true;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0)) {
                        identity = false;
                        break;
                    }
                }
            }

            if (identity)
                System.out.println("Matrix is an Identity Matrix.");
            else
                System.out.println("Matrix is NOT an Identity Matrix.");

        } else {
            System.out.println("\nMatrix is NOT a Square Matrix.");
        }
    }
}
