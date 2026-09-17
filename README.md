# Week 1 Assignments — Part 2

Five console programs in Java. Each one reads its input from the keyboard and
prints the result.

| # | File | Topic |
| - | ---- | ----- |
| 1 | `Assignment1Program.java` | Electricity bill with slab rates |
| 2 | `Assignment2Program.java` | Loan eligibility and interest rate |
| 3 | `Assignment3Program.java` | Prime numbers in a range |
| 4 | `Assignment4Program.java` | Armstrong numbers in a range |
| 5 | `Assignment5Program.java` | Hollow diamond star pattern |

## Compile and run

```sh
javac Assignment1Program.java
java Assignment1Program
```

Replace the number for the other four.

---

## 1. Electricity bill

Reads the units consumed and bills them against four slabs, then adds a fixed
charge of Rs. 75.00 and a surcharge of 5% on everything above.

| Units | Rate per unit |
| ----- | ------------- |
| 1 - 100 | Rs. 1.50 |
| 101 - 200 | Rs. 2.50 |
| 201 - 500 | Rs. 4.00 |
| Above 500 | Rs. 6.00 |

```
Units consumed : 350
Energy charge: Rs. 1000.0
Fixed charge: Rs. 75.0
Surcharge: Rs. 53.75
Final bill: Rs. 1128.75
```

Negative units are rejected.

## 2. Loan eligibility

Reads age, monthly income, credit score, existing EMI and proposed EMI, then
checks the applicant against every rule and reports which ones failed.

Eligibility rules:

- Age between 21 and 60
- Monthly income of at least Rs. 25,000
- Credit score of at least 650
- Existing EMI plus proposed EMI must not exceed 40% of monthly income

Interest rate for an eligible applicant:

| Credit score | Annual rate |
| ------------ | ----------- |
| Above 750 | 8.5% |
| 700 - 750 | 10.0% |
| 650 - 699 | 12.0% |

```
Enter Age : 30
Enter Monthly Income : 50000
Enter Credit score : 760
Enter Existing EMI : 5000
Enter Proposed EMI : 10000
Combined EMI percentage: 30.0%
Applicable annual interest rate: 8.5%
Loan status: Eligible
```

An applicant who fails any rule is told which rule failed, followed by
`Loan status: Not eligible`.

## 3. Prime numbers in a range

Reads a start and an end, prints every prime in that range, how many there are
and what they add up to.

```
Enter Starting number : 1
Enter Ending number : 20
Prime Numbers : 2 3 5 7 11 13 17 19
Number of primes: 8
Sum of primes: 77
```

A start greater than the end is rejected. A range of one number is allowed.

## 4. Armstrong numbers in a range

An Armstrong number equals the sum of its own digits, each raised to the power
of the number of digits. For example 153 = 1^3 + 5^3 + 3^3.

```
Enter Starting number : 100
Enter Ending number : 500
Armstrong Numbers : 153 370 371 407
Number of Armstrong numbers: 4
```

Negative numbers and a start greater than the end are rejected.

## 5. Hollow diamond pattern

Reads N between 2 and 10 and prints a hollow diamond of that height.

```
N: 5
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *
```

Anything outside 2 to 10 prints `Invalid N`.

## Requirements

Java 17 or newer.
