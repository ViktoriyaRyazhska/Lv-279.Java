package zadachi.tasks;

import zadachi.Command;
import java.util.Random;
import java.util.Scanner;

public class Task182 implements Command {
    private int n;
    private int[] a;
    private int count;
    private int sum;


    private void generateA() {
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rnd.nextInt(100);
            System.out.print(a[i] + "\t");
        }

    }

    private void serch() {
        for (int i : a) {
            if ((i % 5 == 0) && (i % 7 != 0)) {
                count++;
                sum += i;
            }
        }
    }

    public void execute() {
        System.out.println("\n\nTask №182.\nGiven a natural number and integer numbers a1 ... an. Find the number and amount of those members of the sequence, which are divided into 5 and do not divide by 7");
        System.out.print("Enter n: ");
        n = new Scanner(System.in).nextInt();
        a = new int[n];
        generateA();
        serch();
        System.out.println("\nThe number of such numbers: " + count);
        System.out.println("The sum of these numbers: " + sum);

    }
}
