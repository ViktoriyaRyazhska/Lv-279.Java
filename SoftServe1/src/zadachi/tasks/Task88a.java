package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task88a implements Command{
    @Override
    public void execute() {
        System.out.println("Task 88 a:\n" +
                "Given a natural number n. Find out if n^2 contain's '3'.");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String input = in.next();
        int number;
        if (input.matches("[0-9]*")) {
            number=(int)Math.pow(Integer.valueOf(input),2);
            if ((number+"").contains("3")) {
                System.out.println("3 is included in the n^2");
            }else {
                System.out.println("3 is not included in the n^2");
            }
        }else {
            System.out.println("Invalid input. Try again");
        }
    }
}
