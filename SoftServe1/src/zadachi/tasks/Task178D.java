package zadachi.tasks;

import java.util.Random;
import java.util.Scanner;

import zadachi.Command;

public class Task178D implements Command{

	private int n;	
	private int[] a;
	
	@Override
	public void execute() {
		
		printTask();
		
		if (n == 0 || a == null) setParameters();

		int count = 0;
		for(int i = 1; i < a.length-1; i++) {
			if(a[i] < (double) (a[i-1]+a[i+1])/2 ) count++;
		}
		System.out.println("\nFound " + count + " elements.");
		a = null; n = 0;
	}
	
	public Task178D(int n, int[] a){
		this.n = n;
		this.a = a;
	}
	
	public Task178D() {
		n = 0;
		a = null;
	}


	public void setParameters() {
		System.out.print("Please enter the number of elements: ");

		Scanner scanner;
		do {
			scanner = new Scanner(System.in);
			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
				break;
			} else
				System.out.print("This is not number. Please try again: ");
		} while (true);
		
		char ch = 0;
		do {
			System.out.print("Would you like to set random values (Y/N): ");
			scanner = new Scanner(System.in);
			String line = scanner.nextLine().toLowerCase();
			if(!line.isEmpty() && line.length()==1) ch = line.charAt(0);
		} while (ch != 'n' && ch!='y');
		
		switch(ch) {
		case 'y':
			setArrayDefault();
			break;
		case 'n':
			setArray();
			break;
		}
		System.out.println("\nThe array contains next elements:");
		for(int k : a)System.out.print(k + " ");
		System.out.println();
	}
	
	private void setArrayDefault() {
		a = new int[n];
		Random r = new Random();
		for(int i=0; i<n; i++)
			a[i] = r.nextInt(100);
	}
	
	private void setArray() {
		a = new int[n];
		Scanner scanner = null;
		for(int i=0; i<n; i++) {
			do {
				System.out.print("a["+i+"]= ");
				scanner = new Scanner(System.in);
				if (scanner.hasNextInt()) {
					a[i] = scanner.nextInt();
					break;
				} else
					System.out.println("This is not number. Please try again!");
			} while (true);
		}
	}
	
	private void printTask() {
		System.out.println("\n---------------------------------------------------------------------");
		System.out.println("Given are natural numbers n, a [1], ..., a [n].\n"
				+ "Determine the number of members a [k] of the sequences a [1], ..., a [n]\n"
				+ "satisfying the condition: a[k] < (a[k-1] + a[k+1]) / 2");
		System.out.println("---------------------------------------------------------------------\n");
	}
	
}
