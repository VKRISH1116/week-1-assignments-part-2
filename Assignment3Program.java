import java.util.Scanner;

class Assignment3Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Starting number : ");
        int startNum = sc.nextInt();

        System.out.print("Enter Ending number : ");
        int endNum = sc.nextInt();

        if (startNum > endNum) {
            System.out.println("Starting number must not be greater than ending number.");
            sc.close();
            return;
        }

        int count = 0;
        long sum = 0;

        System.out.print("Prime Numbers : ");
        for (int i = startNum; i <= endNum; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
                sum += i;
            }
        }
        System.out.println();

        System.out.println("Number of primes: " + count);
        System.out.println("Sum of primes: " + sum);

        sc.close();
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
