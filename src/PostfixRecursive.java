import java.util.Arrays;

/**
 * Runs/contains the recursive postfix evaluator method
 * 
 * @author Alina Rozenbaum
 * 
 */
public class PostfixRecursive implements PostfixEvaluator {

	private static final String SUB = "-", SUM = "+", MULT = "*";

	public double evaluate(String[] array) {

		PostfixCalculator expression = new PostfixCalculator();
		int i = array.length - 2;

		if (array.length == 1) {
			return Double.parseDouble(array[0]);
		} else {
			String operator = array[array.length - 1];

			// Find exp2
			for (; i >= 0; i--) {

				String[] exp2 = Arrays.copyOfRange(array, i, array.length - 1);
				if (expression.isPostfix(exp2) == true)
					break;

			}// end for

			String[] exp2 = Arrays.copyOfRange(array, i, array.length - 1);
			String[] exp1 = Arrays.copyOfRange(array, 0, i);

			if (operator.equals(SUM)) {
				return evaluate(exp1) + evaluate(exp2);
			} else if (operator.equals(SUB)) {
				return evaluate(exp1) - evaluate(exp2);
			} else if (operator.equals(MULT)) {
				return evaluate(exp1) * evaluate(exp2);
			} else {
				return evaluate(exp1) / evaluate(exp2);
			}
		}// end else
	}// end evaluate

}// end RecursivePostfix