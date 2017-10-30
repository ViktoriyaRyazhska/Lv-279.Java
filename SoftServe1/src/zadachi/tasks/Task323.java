package zadachi.tasks;

import zadachi.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task323 implements Command {

    private static int nod(int a, int b) {
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }




    @Override
    public void execute() {
        System.out.println("We have a natural number N. Get all natural numbers smaller than N, are mutually simple to that number");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Please, enter the value of N");
        String s;
        int n;
        while (true) {
            try {
                s = bufferedReader.readLine();
                n = Integer.parseInt(s);
                if (n > 0) break;
                else
                    System.out.println("Entered number does not belong to the set of positive integers, please, try again!");
            }
            catch (IOException e) {
                System.out.println("Entered number does not belong to the set of positive integers, please, try again!");

            }

        }

        for (int i = 1; i < n; i++) {
            if(nod(i,n) == 1) System.out.print(i+" ");

        }
    }
}
