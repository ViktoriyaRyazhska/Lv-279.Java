package zadachi.tasks;

import zadachi.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task561 implements Command {

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(findAutomorphicNumbers(number));

    }

    private static ArrayList<Long> findAutomorphicNumbers(Integer number) {

        boolean test = true;
        List<Long> resultList = new ArrayList<>();
        resultList.add(0l);
        resultList.add(1l);
        resultList.add(5l);
        resultList.add(6l);
        if (resultList.get(resultList.size() - 1) > number) {
            int i = 0;
            while (resultList.get(i) < number) {
                resultList.add(resultList.get(i++));
            }
            return (ArrayList<Long>) resultList;
        } else {
            int k = 2;
            label:
            while (resultList.get(resultList.size() - 1) < number) {
                for (int i = 1; i < 10; i++) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(i);
                    builder.append(resultList.get(k));
                    Long testNumber = Long.parseLong(builder.toString());
                    String square = Long.toString(testNumber * testNumber);
                    if (square.endsWith(builder.toString())) {
                        resultList.add(Long.parseLong(builder.toString()));
                    }
                }

                for(int i = 1; i < 10; i++){
                    StringBuilder builder = new StringBuilder();
                    builder.append(i);
                    builder.append(0);
                    builder.append(resultList.get(k));
                    Long testNumber = Long.parseLong(builder.toString());
                    String square = Long.toString(testNumber * testNumber);
                    if (square.endsWith(builder.toString())) {
                        resultList.add(Long.parseLong(builder.toString()));
                    }
                }

                resultList.sort(new ResultListComparator());
                k++;
            }

        }
        resultList.remove(resultList.size() - 1);

        return (ArrayList<Long>) resultList;
    }

}
