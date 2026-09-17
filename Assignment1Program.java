import java.util.Scanner;

class Assignment1Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Units consumed : ");
        int units = sc.nextInt();

        if (units < 0) {
            System.out.println("Units consumed cannot be negative.");
            sc.close();
            return;
        }

        double energyCharge = 0;

        if (units <= 100) {
            energyCharge = units * 1.50;
        } else if (units <= 200) {
            energyCharge = (100 * 1.50) + ((units - 100) * 2.50);
        } else if (units <= 500) {
            energyCharge = (100 * 1.50) + (100 * 2.50) + ((units - 200) * 4.00);
        } else {
            energyCharge = (100 * 1.50) + (100 * 2.50) + (300 * 4.00) + ((units - 500) * 6.00);
        }

        double fixedCharge = 75.00;
        double surcharge = (energyCharge + fixedCharge) * 0.05;
        double finalBill = energyCharge + fixedCharge + surcharge;

        System.out.println("Energy charge: Rs. " + round2(energyCharge));
        System.out.println("Fixed charge: Rs. " + round2(fixedCharge));
        System.out.println("Surcharge: Rs. " + round2(surcharge));
        System.out.println("Final bill: Rs. " + round2(finalBill));

        sc.close();
    }

    static double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
