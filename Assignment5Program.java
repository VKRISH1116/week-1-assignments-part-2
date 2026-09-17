import java.util.Scanner;

class Assignment5Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N: ");
        int n = sc.nextInt();

        if (n < 2 || n > 10) {
            System.out.println("Invalid N");
            sc.close();
            return;
        }

        for (int row = 1; row <= n; row++) {
            printRow(n, row);
        }
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }

        sc.close();
    }

    static void printRow(int n, int row) {
        for (int i = 1; i <= n - row; i++) {
            System.out.print(" ");
        }

        int width = 2 * row - 1;
        for (int i = 1; i <= width; i++) {
            if (i == 1 || i == width) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
