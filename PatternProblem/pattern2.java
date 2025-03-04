package PatternProblem;

import java.util.Scanner;

public class pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Value of n : ");
        int n = sc.nextInt();

        // Pattern 7
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 8
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 9
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 10
        int odd = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }

            for (int k = 1; k <= 2 * n - odd; k++) {
                System.out.print("* ");
            }
            odd += 2;
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 11
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= n - i + 1; k++) {
                System.out.print("*   ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 12
        int inSpace = 1;
        int inBelowSpace = 2 * n - 5;

        for (int row = 1; row <= 2 * n - 1; row++) {
            int totalColumns = 1;
            if (row != 1 && row != 2 * n - 1)
                totalColumns = 2;

            int totalSpaces = row > n ? row - n : n - row;
            for (int space = 1; space <= totalSpaces; space++) {
                System.out.print(" ");
            }

            for (int column = 1; column <= totalColumns; column++) {
                System.out.print("*");
                if (row > 1 && row <= n) {
                    for (int space = 1; space <= inSpace; space++) {
                        System.out.print(" ");
                    }
                    inSpace += 1;
                }
                if (row > n) {
                    for (int space = 1; space <= inBelowSpace; space++) {
                        System.out.print(" ");
                    }
                    inBelowSpace--;
                }

            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 13
        for (int row = 1; row <= n; row++) {
            for (int spaces = 1; spaces <= n - row; spaces++) {
                System.out.print("  ");
            }
            int c = 1;
            for (int column = 1; column <= row; column++) {
                System.out.print(c + "   ");
                c = c * (row - column) / column;
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        // Pattern 14
        for (int row = 1; row < 2 * n; row++) {
            int c = row > n ? 2 * n - row : row;
            int spaces = n - c;
            for (int i = 0; i < spaces; i++) {
                System.out.print("  ");
            }

            for (int column = c; column >= 1; column--) {
                System.out.print(column + " ");
            }
            for (int column = 2; column <= c; column++) {
                System.out.print(column + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
