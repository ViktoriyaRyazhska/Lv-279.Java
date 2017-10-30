package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task89A implements Command {
    private long userNumber;

    public long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(long userNumber) {
        this.userNumber = userNumber;
    }

    public Task89A() {

    }

    public void getSize() {
        System.out.print("Hi!!! If you want to find out how many digits are in the number N, just give it to me:  ");

        boolean check = false;
        int length = 0;

        do {
            getNumber();
            long number = getUserNumber();
            if (number >= 0) {
                if (number == 0) {
                    length = 1;
                    check = true;
                } else {
                    length = (int) (Math.log10(number) + 1);
                    check = true;
                }
            } else {
                System.out.print("Sorry!!! But this number isn't a natural number. Please give me a natural number:  ");
            }
        } while (!check);
        System.out.println("This number contains " + length + " digit(s)");
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
        getSize();
    }
}
