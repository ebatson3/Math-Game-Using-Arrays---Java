package ebatson3_lab05_q3; //Package name

import java.util.Scanner; //Need scanner for user input

public class Main {

	static int i, level;// used as a counter for which answer of 10 is one, universal level for numb gen
	static boolean correct[] = new boolean[10]; // Declaring boolean array for the correct values

	public static void main(String[] args) {

		boolean terminate = false; // This decides when to stop running the program
		Scanner input = new Scanner(System.in); // Naming scanner

		System.out.println("*******************************\nPracticing simple math problems\n"
				+ "*******************************\n" + "Lab 5\n" + "Question 3\n" + "Name: Evelyn Batson\n"
				+ "*******************************"); // Outputs this header at beginning of lab

		level = fetchDifficulty(); // Calls the difficulty function

		while (!terminate) {
			switch (fetchProblemType()) {
			case 1: // For when problem type selected was option 1
				for (; i < 10; i++) {
					if (level == 1)
						correct[i] = presentQuestion('+', 0, 10); // For level 1, assigns max and min parameters
					else if (level == 2)
						correct[i] = presentQuestion('+', 0, 100); // For level 1, assigns max and min parameters
					else
						correct[i] = presentQuestion('+', -100, 100); // For level 1, assigns max and min parameters
				}
				followUp(); // Calls the followUp method which counts correct answer
				break; // Exits the switch statement
			case 2: // For when problem type selected was option 2
				for (; i < 10; i++) {
					if (level == 1)
						correct[i] = presentQuestion('-', 0, 10);
					else if (level == 2)
						correct[i] = presentQuestion('-', 0, 100);
					else
						correct[i] = presentQuestion('-', -100, 100);
				}
				followUp(); // Calls the followUp method which counts correct answer
				break; // Exits the switch statement
			case 3: // For when problem type selected was option 3
				for (; i < 10; i++) {
					if (level == 1)
						correct[i] = presentQuestion('*', 0, 10);
					else if (level == 2)
						correct[i] = presentQuestion('*', 0, 100);
					else
						correct[i] = presentQuestion('*', -100, 100);
				}
				followUp(); // Calls the followUp method which counts correct answer
				break; // Exits the switch statement
			case 4: // For when problem type selected was option 4
				for (; i < 10; i++) {
					if (level == 1)
						correct[i] = presentQuestion(0, 10);
					else if (level == 2)
						correct[i] = presentQuestion(0, 100);
					else
						correct[i] = presentQuestion(-100, 100);
				}
				followUp(); // Calls the followUp method which counts correct answer
				break; // Exits the switch statement
			case 5: // For when problem type selected was option 5
				level = fetchDifficulty();
				break; // Exits the switch statement
			case 6:
				terminate = true; // For when problem type selected was option 6, exits program
				break; // Exits the switch statement
			}
			input.close(); // Closing the scanner

		}

		System.out.println("Goodbye!"); // Outputs this to the console
	}

	public static int fetchDifficulty() {
		int level; // Declaring the level value

		Scanner input = new Scanner(System.in); // Naming scanner

		System.out.println("1) Easy: Integers ranging 0 to 10\n" + "2) Medium: Integers ranging 0 to 100\n"
				+ "3) Hard: Integers ranging -100 to 100\n" + "Please input a choice (1-3):");
		/* Outputs this choice menu to the user */
		level = input.nextInt(); // Sets this value for other methods to access
		while (!(level >= 1 && level <= 3)) {
			System.out.println("Invalid difficulty choice!\n" + "Please input a choice (1-3):");
			level = input.nextInt(); // Sets level to the input choice
		}
		input.close(); // Closing the scanner
		return level; // Returns this value to the main method
	}

	public static int fetchProblemType() {

		Scanner input = new Scanner(System.in); // Naming scanner

		System.out.println("\nPlease select the type(s) of problems:\n" + "1. Addition\n" + "2. Subtraction\n"
				+ "3. Multiplication\n" + "4. Random\n" + "5. Change Difficulty\n" + "6. Exit\n"
				+ "Please input a choice (1-6):\n");
		/* Outputs this menu to the user */
		int problem = input.nextInt(); // Sets the users problem type choice to the variable
		while (!(problem >= 1 && problem <= 6)) {
			System.out.println("Invalid difficulty choice!\n" + "Please input a choice (1-3):");
			/* This is output continually when the input is invalid */
			problem = input.nextInt(); // Sets input to problem variable
		}
		input.close(); // Closing the scanner
		return problem; // Returns this value to the main method
	}

	public static boolean presentQuestion(char operationSymbol, int min, int max) {
		int answer, a = randomInt(min, max), b = randomInt(min, max);
		boolean response = false; // Boolean for if their answer is correct

		Scanner input = new Scanner(System.in); // Naming scanner

		switch (operationSymbol) {
		case '+':
			System.out.println("Question " + (i + 1) + "\nWhat is the result of: " + a + " + " + b);// add
			answer = input.nextInt();
			if (answer == (a + b)) {
				response = true; // Sets boolean to true because the answer was correct
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect! The correct answer was: " + (a + b));
			}
			break; // Exits the switch statement
		case '-':
			System.out.println("Question " + (i + 1) + "\nWhat is the result of: " + a + " - " + b);// sub
			answer = input.nextInt();
			if (answer == (a - b)) {
				response = true; // Sets boolean to true because the answer was correct
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect! The correct answer was: " + (a - b));
			}
			break; // Exits the switch statement
		case '*':
			System.out.println("Question " + (i + 1) + "\nWhat is the result of: " + a + " * " + b);// mult
			answer = input.nextInt();
			if (answer == (a * b)) {
				response = true; // Sets boolean to true because the answer was correct
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect! The correct answer was: " + (a * b));
			}
			break; // Exits the switch statement
		}
		input.close(); // Closing the scanner
		return response; // Returns this value to the main method
	}

	public static boolean presentQuestion(int min, int max) {
		int randomSet = (int) (Math.random() * 3 + 1); // Declaring random number set for questions
		int answer, a = randomInt(min, max), b = randomInt(min, max);
		/* Declaring variables that represent the numbers in the binary operations */
		boolean response = false; // Boolean for if their answers are correct

		Scanner input = new Scanner(System.in); // Naming scanner

		switch (randomSet) {
		case 1:
			System.out.println("Question " + (i + 1) + "\nWhat is the result of: " + a + " + " + b);// add
			answer = input.nextInt(); // Assigns input to answer variable
			if (answer == (a + b)) {
				response = true; // Sets boolean to true because the answer was correct
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect! The correct answer was: " + (a + b));
			}
			break; // Exits the switch statement
		case 2:
			System.out.println("Question " + (i + 1) + "\nWhat is the result of: " + a + " - " + b);// sub
			answer = input.nextInt(); // Assigns input to answer variable
			if (answer == (a - b)) {
				response = true; // Sets boolean to true because the answer was correct
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect! The correct answer was: " + (a - b));
			}
			break; // Exits the switch statement
		case 3:
			System.out.println("Question " + (i + 1) + "\nWhat is the result of: " + a + " * " + b);// mult
			answer = input.nextInt(); // Assigns input to answer variable
			if (answer == (a * b)) {
				response = true; // Sets boolean to true because the answer was correct
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect! The correct answer was: " + (a * b));
			}
			break; // Exits the switch statement
		}
		input.close(); // Closing the scanner
		return response; // Returns this value to the main method
	}

	public static int randomInt(int minRange, int maxRange) {
		int num = 0; // Sets input number to zero before other methods are called
		if (minRange == 0) {
			if (maxRange == 10)
				num = (int) (Math.random() * 10 + 1); // Generates number using a max of 10
			else
				num = (int) (Math.random() * 100 + 1); // Generates number when the above is NOT true
		} else {
			num = (int) Math.pow(-1, ((int) (Math.random() * 2 + 1))) * (int) (Math.random() * 100 + 1);
			/* For when the minRange is not zero */

		}
		return num; // Returns this value to the main method
	}

	public static void followUp() {// result and reset method
		int numCorrect = 0; // Initially the user has zero questions correct
		for (int j = 0; j < 10; j++) {
			if (correct[j]) {
				numCorrect++; // Increments the number of correct questions
			}
		}
		System.out.print("You scored " + numCorrect + "/10 questions correctly.\n"); // Outputs the users score
		correct = new boolean[10]; // The correct values stored in the boolean
		i = 0; // Sets level to zero to stop program from repeating
	}
} // End of program
