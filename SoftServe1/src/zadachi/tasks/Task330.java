package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task330 implements Command {
    private long userNumber;

    public Task330() {
    }

    public long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(long userNumber) {
        this.userNumber = userNumber;
    }

    public void getNumber() {
        System.out.print("Hi!!! If you want to find out what number are perfect please write the natural number that will be the last number in range from 1 to N:  ");
        boolean check = false;

        do {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLong()) {
                long num = sc.nextLong();
                setUserNumber(num);
                check = true;
            } else {
                System.out.print("The value you have input is not a valid integer. Please give me a valid number:  ");
            }
        } while (!check);
    }

    public void givePerfectNumber() {
        for (long i = 1; i <= getUserNumber(); i++) {
            if (isPerfectNumber(i)) {
                System.out.print("Perfect number is: ");
                System.out.println(i);
            }
        }
    }

    public boolean isPerfectNumber(long number) {
        int temp = 0;
        for (long i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                temp += i;
            }
        }
        if (temp == number) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void execute() {
        getNumber();
        givePerfectNumber();
    }
}
