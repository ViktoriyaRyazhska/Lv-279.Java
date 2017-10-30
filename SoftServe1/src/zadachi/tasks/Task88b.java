package zadachi.tasks;

import zadachi.Command;

import java.util.Scanner;

public class Task88b implements Command {
    @Override
    public void execute() {
        System.out.println("Task 88 b:\n" +
                "Given a natural number n. Print reversed order of n.");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter some number: ");
        String input = in.next();
        if (input.matches("[0-9]*")) {
            StringBuilder sb=new StringBuilder(input);
            System.out.println(sb.reverse());
        }else {
            System.out.println("Invalid input. Try again");
        }
    }
}
