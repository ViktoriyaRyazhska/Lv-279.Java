package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task89B implements Command {
    private long userNumber;

    public long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(long userNumber) {
        this.userNumber = userNumber;
    }

    public void getSum() {
        System.out.print("Hi!!! If you want to find out what the sum of digits of number N, just give it to me:  ");
        boolean check = false;
        long sum = 0;

        do {
            getNumber();
            long number = getUserNumber();
            if (number >= 0) {
                if (number == 0) {
                    sum = 0;
                    check = true;
                } else {
                    while (number > 0) {
                        sum = sum + number % 10;
                        number = number / 10;
                    }
                    check = true;
                }
            } else {
                System.out.print("Sorry!!! But this number isn't a natural number. Please give me a natural number:  ");
            }
        } while (!check);
        System.out.println("The sum of digits of number is: " + sum);
    }

    public void getNumber() {
        boolean check = false;
        do {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLong()) {
                long num = sc.nextLong();
                setUserNumber(num);
                check = true;
            } else {
                System.out.print("The value you have input is not a valid integer. Please give me a natural number:  ");
            }
        } while (!check);
    }

    @Override
    public void execute() {
        getSum();
    }
}
