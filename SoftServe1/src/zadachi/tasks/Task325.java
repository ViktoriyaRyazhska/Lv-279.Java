package zadachi.tasks;

import zadachi.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task325 implements Command {

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
        System.out.println(findDividersOfTheNumber(number));
    }

    private static ArrayList<Integer> findDividersOfTheNumber(Integer number) {

        List<Integer> resultList = new ArrayList<>();

        List<Integer> dividers;
        dividers = findDividers(number);

        for (int i = 0; i < dividers.size() - 1; i++) {
            if (number % dividers.get(i) == 0) {
                resultList.add(dividers.get(i));
            }
        }
        return (ArrayList<Integer>) resultList;
    }

    private static ArrayList<Integer> findDividers(Integer number) {
        boolean[] isPrime = new boolean[number + 1];
        List<Integer> primeNumb = new ArrayList<>();

        Arrays.fill(isPrime, true);

        isPrime[1] = false;

        for (int i = 2; i * i <= number; i++) {
            if (isPrime[i] == true) {
                for (int k = i * i; k <= number; k += i) {
                    isPrime[k] = false;
                }
            }
        }

        for (int i = 1; i <= number; i++) {
            if (isPrime[i] == true) {
                primeNumb.add(i);
            }
        }

        return (ArrayList<Integer>) primeNumb;
    }


}
