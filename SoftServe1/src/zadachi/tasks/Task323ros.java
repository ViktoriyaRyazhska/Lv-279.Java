package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task323ros implements Command {
    private static int n;


    public void execute() {
        System.out.println("\n\nTask № 323.\nGiven number n. Get all numbers that are less than n and are mutually simple with it.");
        System.out.print("Enter n: ");
        n = new Scanner(System.in).nextInt();
        System.out.print("Mutually simple numbers with " + n + ":\t");
        for (int i = n - 1; i > 0; i--) {
            if (gcd(n, i) == 1) {
                System.out.print(i + "\t");
            }
        }
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
