package zadachi.tasks;

import zadachi.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task107 implements Command {


    public void doTask_107() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the number: ");
        int number = Integer.parseInt(bf.readLine());
        System.out.println(ex_107(number));
    }


    private int ex_107(int m) {
        if (m < 1) {
            System.out.println(("m < 1"));
        }

        int k = 1;
        while (Math.pow(4, k) <= m) {
            k++;
        }
        return --k;
    }


    @Override
    public void execute() {
        try {
            doTask_107();
        } catch (IOException e) {
            System.err.println("Bad input");
            e.printStackTrace();
        }
    }
}
