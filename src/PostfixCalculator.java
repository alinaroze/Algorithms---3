import java.util.Scanner;

/**
 * The main class for the Postfix Calculator that runs the evaluator classes,
 * and prompts the user to input the expression into the calculators
 * 
 * @author Alina Rozenbaum
 * 
 */
public class PostfixCalculator {

	private String[] postExp;
	private PostfixRecursive recursiveExp;
	private PostfixStack stackExp;
	private static final String SUB = "-", SUM = "+", MULT = "*", DIV = "/";

	/**
	 * Runs the program
	 * 
	 */
	public static void main(String[] args) throws Exception {

		// Builds a calculator object
		PostfixCalculator expression = new PostfixCalculator();

		// Welcomes the user, and runs the calculator
		expression.welcome();
		expression.run();

	}// end main

	/**
	 * The instructions for the calculator
	 */
	private void welcome() {
		System.out
				.println("Hello an welcome to the postfix calculator.\n\n"
						+ "This program allows you to evaluate a POSTFIX expression.\n"
						+ "You must enter an expression using numbers and +,-,* or /. \n"
						+ "Please make sure it is postfix and space the numbers correctly.\n\n"
						+ "How please enter your first postfix expression:\n\n");
	}// end welcome

	/**
	 * Transfers the user input into a string array
	 * 
	 * @param expression
	 *            - User input to be transfered to an array
	 * @return The array of the postfix expression
	 */
	private String[] retrieveExp(String expression) {

		postExp = expression.split(" ");
		return postExp;

	}// end retrieve expression

	/**
	 * Checks if the string is a number
	 * 
	 * @param s
	 *            - String to be checked
	 * @return True if it is and false if it's not
	 */
	protected boolean isNumber(String s) {
		// tries to parse the string into a double
		// if it isn't a double the program returns false
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}// end catch
	}// end isNumber

	/**
	 * Checks if the array is a postfix expression
	 * 
	 * @param array
	 *            - The array to be checked
	 * @return True if it is and false if it is not
	 */
	protected boolean isPostfix(String[] array) {
		int counter = 0;
		boolean flag = false;

		// uses a counter to check if the expression is postfix
		for (int i = 0; i < array.length; i++) {

			if (array.length == 1 && isNumber(array[0]) == true) {
				flag = true;
				return flag;
			} else if (array.length == 1 && isNumber(array[0]) == false) {
				return flag;
			} else if (isNumber(array[1]) == false) {
				return flag;
			} else if (array[i].equals(SUB)) {
				counter = counter - 1;
			} else if (array[i].equals(SUM)) {
				counter = counter - 1;
			} else if (array[i].equals(MULT)) {
				counter = counter - 1;
			} else if (array[i].equals(DIV)) {
				counter = counter - 1;
			} else if (isNumber(array[i]) == true) {
				counter++;
			} else {
				return flag;
			}

		}

		// if the counter is 1, then it is
		if (counter == 1) {
			flag = true;
			return flag;

		} else
			return flag;

	}// end isPostfix

	/**
	 * Runs the program and then asks the user if the want to quit
	 * 
	 * @throws Exception
	 */
	private void run() throws Exception {

		boolean flag;
		recursiveExp = new PostfixRecursive();
		stackExp = new PostfixStack();

		// input from the user for the expression
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();

		// changes the expression into an array
		postExp = retrieveExp(expression);

		flag = isPostfix(postExp);

		// loops and prompts the user as long as the input wasn't a postfix
		while (flag == false) {
			System.out
					.println("I'm sorry, that is an invalid postfix expression, please enter one again:");

			expression = input.nextLine();

			postExp = retrieveExp(expression);
			flag = isPostfix(postExp);
		}// end while

		// evaluates the expression
		String eval1 = "" + recursiveExp.evaluate(postExp);
		String eval2 = "" + stackExp.evaluate(postExp);

		// Prints out the expression entered along with the answer
		System.out.println("Here is your expression: " + expression);
		System.out.println("And here is the recursive evaluation answer: "
				+ eval1);
		System.out.println("And here is the stack evaluation answer: " + eval2);

		if (!eval1.equals(eval2)) {
			throw new Exception("The values do not match!");
		}

		quit();
	}// end run

	/**
	 * Prompts the user to quit or not If yes, ends the program and if not, runs
	 * the calculator again
	 * 
	 * @throws Exception
	 */
	private void quit() throws Exception {

		// asks the user if they want to quit the program
		System.out.println("Would you like to quit the program? ");
		Scanner input = new Scanner(System.in);
		String answer = input.next();

		// does the correct action/response based on the user's entry
		if (answer.equalsIgnoreCase("no")) {
			System.out.println("Please enter a postfix expression:");
			run();
		} else if (answer.equalsIgnoreCase("yes")) {
			System.out.println("Goodbye!!");
			System.exit(0);
		} else {
			System.out.println("I'm sorry that's not a correct response.\n");
			// user's response wasn't within the bounds so they're prompted
			// again
			quit();
		}// end else

	}// end quit

}
