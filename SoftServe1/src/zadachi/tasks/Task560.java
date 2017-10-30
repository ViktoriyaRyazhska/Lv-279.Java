package zadachi.tasks;

import zadachi.Command;

public class Task560 implements Command {
    private int a;
    private int b;
    private static int firstNumber = 200;
    private static int endNumber = 300;


    public void execute() {
        System.out.println("\n\nTask № 560\n Two positive integers are called friendly,\n" +
                "if each of them is equal to the sum of all divisors other than the number itself.\"\n" +
                "Find all couples of friendly numbers in the range from 200 to 300.");
        for (int i = firstNumber; i < endNumber; i++) {
            for (int j = i + 1; j <= endNumber; j++) {
                if ((i == sumOfDividers(j)) && (sumOfDividers(i) == j)) {
                    System.out.println("\n" + i + " and " + j + " friendly numbers");
                }
            }
        }
    }

    public int sumOfDividers(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }

        }
        return sum;
    }
}
