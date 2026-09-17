import java.util.Scanner;
import java.util.stream.IntStream;

class Assignment5Program {

    static String row(int n, int starsRow) {
        var padding = " ".repeat(n - starsRow);
        var width = 2 * starsRow - 1;
        var body = width == 1 ? "*" : "*" + " ".repeat(width - 2) + "*";
        return padding + body;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("N: ");
            var n = scanner.nextInt();

            if (n < 2 || n > 10) {
                System.out.println("Invalid N");
                return;
            }

            IntStream.concat(
                            IntStream.rangeClosed(1, n),
                            IntStream.iterate(n - 1, i -> i >= 1, i -> i - 1))
                    .mapToObj(starsRow -> row(n, starsRow))
                    .forEach(System.out::println);
        }
    }
}
