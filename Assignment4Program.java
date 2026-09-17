import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Assignment4Program {

    static boolean isArmstrong(int n) {
        var digits = String.valueOf(n);
        var sum = digits.chars()
                .mapToLong(digit -> (long) Math.pow(digit - '0', digits.length()))
                .sum();
        return sum == n;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Enter Starting number : ");
            var startNum = scanner.nextInt();

            System.out.print("Enter Ending number : ");
            var endNum = scanner.nextInt();

            if (startNum < 0 || endNum < 0) {
                System.out.println("Range must not contain negative numbers.");
                return;
            }
            if (startNum > endNum) {
                System.out.println("Starting number must not be greater than ending number.");
                return;
            }

            var armstrongs = IntStream.rangeClosed(startNum, endNum)
                    .filter(Assignment4Program::isArmstrong)
                    .boxed()
                    .toList();

            var listed = armstrongs.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println("Armstrong Numbers : " + listed);
            System.out.println("Number of Armstrong numbers: " + armstrongs.size());
        }
    }
}
