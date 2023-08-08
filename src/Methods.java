/*
 * Methods
 * Basic program using methods
 * Author: Michael Muehlberger
 * Last Change: 23.11.2022
 */

import java.util.Locale;
import java.util.Scanner;

public class Methods {

    //scanning a number
    static int scanFunction(Scanner scanner) {

        int num = -1;

        while (true) {

            System.out.print("Enter a positive number: ");

            if (scanner.hasNextInt()) {

                num = scanner.nextInt();

                if (scanner.nextLine().equals("") && num > 0) {
                    break;
                }
            } else {
                scanner.nextLine();
            }
        }
        return num;
    }

    //computes minimum of 2 values
    static int minFunction(int a, int b) {
        int min;

        if (a < b) {
            min = a;
        } else {
            min = b;
        }
        return min;
    }

    //computes maximum of 2 values
    static int maxFunction(int a, int b) {
        int max;

        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        return max;
    }

    //computes the sum of 2 values
    static int sumFunction(int a, int b) {
        int sum;
        sum = a + b;
        return sum;
    }

    //computes the sum of all integers between the minimum and the maximum
    static int sumMinMaxFunction(int num1, int num2) {
        int sumMinMax = 0;
        int min = minFunction(num1, num2);
        int max = maxFunction(num1, num2);
        int i;

        for (i = min; i <= max; i++) {
            sumMinMax += i;
        }
        return sumMinMax;
    }

    //computes the delta of num1 and num2
    static int deltaFunction(int num1, int num2) {
        int delta;
        delta = num1 - num2;
        return delta;
    }

    //computes the mean of num1 and num2
    static double meanFunction(double num1, double num2) {
        double mean;
        mean = (num1 + num2) / 2;
        return mean;
    }

    //computes the gcd (greatest common divisor)
    static int ggTFunction(int num1, int num2) {
        int min = minFunction(num1, num2);

        for (int i = min; i >= 2; i--) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                return i;
            }
        }
        return 1;
    }

    // computes the lcm (least common multiple)
    static int kgVFunction(int num1, int num2) {

        int num = num1;
        int kgV = num2;

        while (num != kgV) {

            while (kgV < num) {
                kgV += num2;
            }
            while (num < kgV) {
                num += num1;
            }
        }
        return kgV;
    }

    // prints all prime numbers between 2 integers
    static void primeFunction(int num1, int num2) {

        System.out.printf("primes(%d,%d) = {", num1, num2);

        int min = minFunction(num1, num2);
        int max = maxFunction(num1, num2);

        if (min == 1) {
            min = 2;
        }

        boolean primeNo = true;
        boolean begin = true;

        for (int i = min; i <= max; i++) {

            primeNo = true;

            for (int m = 2; m <= (i / 2); m++) {

                if (i % m == 0) {
                    primeNo = false;
                    break;
                }
            }

            if (primeNo) {
                if (begin) {
                    System.out.printf("%d", i);
                    begin = false;
                } else {
                    System.out.printf(", %d", i);
                }
            }
        }
        System.out.print("}");
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        Scanner scanner = new Scanner(System.in);

        int num1 = scanFunction(scanner);
        int num2 = scanFunction(scanner);

        int min = minFunction(num1, num2);
        int max = maxFunction(num1, num2);

        //all the outputs
        System.out.printf("min(%d,%d) = %d\n", num1, num2, min);
        System.out.printf("max(%d,%d) = %d\n", num1, num2, max);

        int sum = sumFunction(num1, num2);
        System.out.printf("sum(%d,%d) = %d\n", num1, num2, sum);

        int sumFromTo = sumMinMaxFunction(num1, num2);
        System.out.printf("sumFromTo(%d,%d) = %d\n", num1, num2, sumFromTo);

        int delta = deltaFunction(num1, num2);
        System.out.printf("delta(%d,%d) = %d\n", num1, num2, delta);

        double mean = meanFunction(num1, num2);
        System.out.printf("mean(%d,%d) = %.2f\n", num1, num2, mean);

        int gcd = ggTFunction(num1, num2);
        System.out.printf("gcd(%d,%d) = %d\n", num1, num2, gcd);

        int lcm = kgVFunction(num1, num2);
        System.out.printf("lcm(%d,%d) = %d\n", num1, num2, lcm);

        primeFunction(num1, num2);
        System.out.println();

    }
}