/**
 * Runs/contains the stack postfix evaluator method
 * 
 * @author Alina Rozenbaum
 *
 */
public class PostfixStack implements PostfixEvaluator{

	private Stack exp;
	PostfixCalculator expression;
	
	private static final String SUB = "-", SUM = "+", MULT = "*", DIV = "/";

	public double evaluate(String[] array) {

		double result;
		double x;
		double y;

		// Creates a new stack
		exp = new Stack();

		expression = new PostfixCalculator();

		/*
		 * If it is a number it gets pushed onto the stack. If it is an operator
		 * the last two values on the stack are popped off and the result is
		 * computed using the operator. Then the result is pushed back onto the
		 * stack.
		 */
		for (int i = 0; i < array.length; i++) {
			if (expression.isNumber(array[i]) == true) {
				exp.push(Double.parseDouble(array[i]));
			} else if (array[i].equals(SUM)) {
				y = exp.pop();
				x = exp.pop();
				result = x + y;
				exp.push(result);
			} else if (array[i].equals(SUB)) {
				y = exp.pop();
				x = exp.pop();
				result = x - y;
				exp.push(result);
			} else if (array[i].equals(MULT)) {
				y = exp.pop();
				x = exp.pop();
				result = x * y;
				exp.push(result);
			} else if (array[i].equals(DIV)) {
				y = exp.pop();
				x = exp.pop();
				result = x / y;
				exp.push(result);
			}

		}

		return exp.pop();
	}

}
