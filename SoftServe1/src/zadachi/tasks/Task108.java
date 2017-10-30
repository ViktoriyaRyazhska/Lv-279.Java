package zadachi.tasks;

import zadachi.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task108 implements Command {

    @Override
    public void execute() {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(findMinNumber(number));
    }

    private static int findMinNumber(Integer number) {

        double foundLog = Math.log(number) / Math.log(2);
        int roundToMax = (int) Math.ceil(foundLog);

        return (int) (Math.pow(2, roundToMax));
    }


}
