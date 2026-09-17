import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Assignment3Program {

    static boolean isPrime(int n) {
        return n >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Enter Starting number : ");
            var startNum = scanner.nextInt();

            System.out.print("Enter Ending number : ");
            var endNum = scanner.nextInt();

            if (startNum > endNum) {
                System.out.println("Starting number must not be greater than ending number.");
                return;
            }

            var primes = IntStream.rangeClosed(startNum, endNum)
                    .filter(Assignment3Program::isPrime)
                    .boxed()
                    .toList();

            var listed = primes.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println("Prime Numbers : " + listed);
            System.out.println("Number of primes: " + primes.size());
            System.out.println("Sum of primes: " + primes.stream().mapToLong(Integer::longValue).sum());
        }
    }
}
