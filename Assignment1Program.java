import java.util.Scanner;

class Assignment1Program {

    static final double FIXED_CHARGE = 75.00;
    static final double SURCHARGE_RATE = 0.05;

    record Bill(double energyCharge, double fixedCharge, double surcharge) {

        static Bill forUnits(int units) {
            var energy = energyChargeFor(units);
            return new Bill(energy, FIXED_CHARGE, (energy + FIXED_CHARGE) * SURCHARGE_RATE);
        }

        double total() {
            return energyCharge + fixedCharge + surcharge;
        }
    }

    static double energyChargeFor(int units) {
        if (units <= 100) {
            return units * 1.50;
        }
        if (units <= 200) {
            return (100 * 1.50) + ((units - 100) * 2.50);
        }
        if (units <= 500) {
            return (100 * 1.50) + (100 * 2.50) + ((units - 200) * 4.00);
        }
        return (100 * 1.50) + (100 * 2.50) + (300 * 4.00) + ((units - 500) * 6.00);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            System.out.print("Units consumed : ");
            var units = scanner.nextInt();

            if (units < 0) {
                System.out.println("Units consumed cannot be negative.");
                return;
            }

            var bill = Bill.forUnits(units);

            System.out.print("""
                    Energy charge: Rs. %.2f
                    Fixed charge: Rs. %.2f
                    Surcharge: Rs. %.2f
                    Final bill: Rs. %.2f
                    """.formatted(bill.energyCharge(), bill.fixedCharge(), bill.surcharge(), bill.total()));
        }
    }
}
