import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Assignment2Program {

    record Applicant(int age, long income, int score, long existingEmi, long proposedEmi) {

        long totalEmi() {
            return existingEmi + proposedEmi;
        }

        long emiLimit() {
            return income * 40 / 100;
        }

        double emiPercentage() {
            var percentage = ((double) totalEmi() / income) * 100;
            return Math.round(percentage * 100.0) / 100.0;
        }

        double interestRate() {
            if (score > 750) {
                return 8.5;
            }
            if (score >= 700) {
                return 10.0;
            }
            return 12.0;
        }
    }

    sealed interface Decision permits Approved, Rejected {}

    record Approved(double interestRate) implements Decision {}

    record Rejected(List<String> reasons) implements Decision {}

    static List<String> basicChecks(Applicant applicant) {
        var reasons = new ArrayList<String>();
        if (applicant.age() < 21 || applicant.age() > 60) {
            reasons.add("age must be between 21 and 60");
        }
        if (applicant.income() < 25000) {
            reasons.add("monthly income must be at least 25000");
        }
        if (applicant.score() < 650) {
            reasons.add("credit score must be at least 650");
        }
        return reasons;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Enter Age : ");
            var age = scanner.nextInt();

            System.out.print("Enter Monthly Income : ");
            var income = scanner.nextLong();

            System.out.print("Enter Credit score : ");
            var score = scanner.nextInt();

            System.out.print("Enter Existing EMI : ");
            var existingEmi = scanner.nextLong();

            System.out.print("Enter Proposed EMI : ");
            var proposedEmi = scanner.nextLong();

            var applicant = new Applicant(age, income, score, existingEmi, proposedEmi);
            var reasons = basicChecks(applicant);

            if (reasons.isEmpty()) {
                System.out.println("Combined EMI percentage: " + applicant.emiPercentage() + "%");
                if (applicant.totalEmi() > applicant.emiLimit()) {
                    reasons.add("combined EMI exceeds 40% of monthly income");
                }
            }

            Decision decision = reasons.isEmpty()
                    ? new Approved(applicant.interestRate())
                    : new Rejected(List.copyOf(reasons));

            switch (decision) {
                case Approved(double rate) -> {
                    System.out.println("Applicable annual interest rate: " + rate + "%");
                    System.out.println("Loan status: Eligible");
                }
                case Rejected(List<String> why) -> {
                    why.forEach(reason -> System.out.println("Rejected: " + reason + "."));
                    System.out.println("Loan status: Not eligible");
                }
            }
        }
    }
}
