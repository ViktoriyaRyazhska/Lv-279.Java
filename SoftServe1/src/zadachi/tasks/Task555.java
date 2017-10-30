package zadachi.tasks;

import java.util.Scanner;

import zadachi.Command;

public class Task555 implements Command {

	private int n;

	public Task555(int n) {
		this.n = n;
	}

	public Task555() {
		n = 0;
	}

	@Override
	public void execute() {
		
		printTask();
		
		if (n == 0)
			setParameters();

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - i; j++)
				System.out.print("\t");

			for (int j = 0; j <= i; j++) {
				int r = factorial(i) / (factorial(j) * factorial(i - j));
				System.out.print(r + "\t\t");
			}

			System.out.println();

		}
		
		n = 0;

	}
	
	private int factorial(int n) {
		int res = 1;
		for(int i=2; i<=n; i++) res*=i;
		return res;
	}

	public void setParameters() {
		System.out.print("Please enter the height of triangle: ");

		do {
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
				if (n < 1)
					System.out.print("The height cannot be less than 1: ");
				break;
			} else
				System.out.print("This is not number. Please try again: ");
		} while (true);

	}
	
	private void printTask() {
		System.out.println("\n---------------------------------------------------------------------");
		System.out.println("Given a natural n.\nGet the first n lines of the Pascal triangle.");
		System.out.println("---------------------------------------------------------------------\n");
	}

}
