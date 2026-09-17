import java.util.Scanner;

class Assignment4Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Starting number : ");
        int startNum = sc.nextInt();

        System.out.print("Enter Ending number : ");
        int endNum = sc.nextInt();

        if (startNum < 0 || endNum < 0) {
            System.out.println("Range must not contain negative numbers.");
            sc.close();
            return;
        }
        if (startNum > endNum) {
            System.out.println("Starting number must not be greater than ending number.");
            sc.close();
            return;
        }

        int count = 0;

        System.out.print("Armstrong Numbers : ");
        for (int i = startNum; i <= endNum; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();

        System.out.println("Number of Armstrong numbers: " + count);

        sc.close();
    }

    static boolean isArmstrong(int n) {
        int digits = countDigits(n);
        int temp = n;
        long sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += power(digit, digits);
            temp = temp / 10;
        }

        return sum == n;
    }

    static int countDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int digits = 0;
        while (n != 0) {
            digits++;
            n = n / 10;
        }
        return digits;
    }

    static long power(int base, int exponent) {
        long result = 1;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }
}
