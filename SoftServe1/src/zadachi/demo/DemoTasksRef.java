package zadachi.demo;

import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import zadachi.Command;
import zadachi.classutils.ClassUtil;

public class DemoTasksRef {

	public static void main(String[] args)
			throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {

		Class<?>[] classes = ClassUtil.getClasses("zadachi");
		Map<String, Command> commands = new HashMap<>();
		List<String> namesList = new ArrayList<>();
	
		for (Class<?> cls : classes) {
			for (AnnotatedType at : cls.getAnnotatedInterfaces()) {
				if (at.getType().toString().contains("zadachi.Command")) {
					namesList.add(cls.getSimpleName());
					commands.put(cls.getSimpleName().toLowerCase(), (Command) cls.newInstance());
				}
			}
		}

		Command cmd;


		do {
			
			String taskName = menu(namesList);
			
			cmd = commands.get(taskName.toLowerCase());

			if (taskName.equalsIgnoreCase("exit"))
				break;

			if (cmd != null) {
				cmd.execute();
			}

		} while (true);

		System.out.println("Bye bye");

	}
	
	private static String menu(List<String> list) {
		System.out.println("----------------------------------------------------");
		System.out.println("List of tasks:");
		for (String s : list) System.out.println("\t" + s);
		System.out.print("Enter the task name (type \'exit\' for quit): ");
		
		Scanner scanner = new Scanner(System.in);
		String res;
		
		do {
			if (scanner.hasNext()) {
				res = scanner.next();
				break;
			}
		} while (true);
		
		return res;
	}

}