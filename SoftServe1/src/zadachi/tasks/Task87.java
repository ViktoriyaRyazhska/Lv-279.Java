package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task87 implements Command {




    @Override
    public void execute() {
        System.out.println("There are two natural numbers M and N. Get the sum of N last digits of M.");
        Scanner in = new Scanner(System.in);


        System.out.println("Please, enter the value of M");
        int m;
        while (true) {
            m = in.nextInt();
            if (m > 0) break;
            else
                System.out.println("Entered number does not belong to the set of positive integers, please, try again!");

        }

        System.out.println("Please, enter the value of N");

        int n;
        while (true) {
            n = in.nextInt();
            if (n > 0) break;
            else
                System.out.println("Entered number does not belong to the set of positive integers, please, try again!");

        }

        int sum = 0;
        while (n >= 1 && m >= 0) {
            sum += m % 10;
            m /= 10;
            n--;
        }
        System.out.println(sum);
    }
}
