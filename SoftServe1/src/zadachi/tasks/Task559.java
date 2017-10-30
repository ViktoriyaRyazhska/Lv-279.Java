package zadachi.tasks;

import zadachi.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task559 implements Command {

        private static boolean isPrime(long n) {

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }




    @Override
    public void execute() {
        System.out.println("We have a natural number N. Get all Marsen's numbers smaller than N");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));



        System.out.println("Please, enter the value of N");
        String numberS;
        long n;


        while (true) {
            try {
                numberS = bufferedReader.readLine();
                n = Long.parseLong(numberS);
                if (n > 0) break;
                else
                    System.out.println("Entered number does not belong to the set of positive integers, please, try again!");
            }
            catch (IOException e) {
                System.out.println("Entered number does not belong to the set of positive integers, please, try again!");

            }
        }

        long accum = 2;

        for (long i = 2; accum <= n; i++) {
            accum *=2;
            if (isPrime(i))  System.out.print(accum -1 + " ");
        }
    }
}

