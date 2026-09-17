import java.util.Scanner;

class Assignment2Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Age : ");
        int age = sc.nextInt();

        System.out.print("Enter Monthly Income : ");
        long income = sc.nextLong();

        System.out.print("Enter Credit score : ");
        int score = sc.nextInt();

        System.out.print("Enter Existing EMI : ");
        long existingEmi = sc.nextLong();

        System.out.print("Enter Proposed EMI : ");
        long proposedEmi = sc.nextLong();

        boolean eligible = true;

        if (age < 21 || age > 60) {
            System.out.println("Rejected: age must be between 21 and 60.");
            eligible = false;
        }
        if (income < 25000) {
            System.out.println("Rejected: monthly income must be at least 25000.");
            eligible = false;
        }
        if (score < 650) {
            System.out.println("Rejected: credit score must be at least 650.");
            eligible = false;
        }

        if (eligible) {
            long emiLimit = income * 40 / 100;
            long totalEmi = existingEmi + proposedEmi;

            double combined = ((double) totalEmi / income) * 100;
            combined = Math.round(combined * 100.0) / 100.0;
            System.out.println("Combined EMI percentage: " + combined + "%");

            if (totalEmi > emiLimit) {
                System.out.println("Rejected: combined EMI exceeds 40% of monthly income.");
                eligible = false;
            }
        }

        if (eligible) {
            double rate;
            if (score > 750) {
                rate = 8.5;
            } else if (score >= 700) {
                rate = 10.0;
            } else {
                rate = 12.0;
            }
            System.out.println("Applicable annual interest rate: " + rate + "%");
            System.out.println("Loan status: Eligible");
        } else {
            System.out.println("Loan status: Not eligible");
        }

        sc.close();
    }
}
