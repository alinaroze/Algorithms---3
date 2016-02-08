/**
 * An array based stack
 * 
 * @author Alina Rozenbaum
 * 
 */

public class Stack {

	final int MAX = 20; // maximum size of stack
	private double[] stack;
	private int top;

	/**
	 * Default Stack constructor
	 */
	public Stack() {
		stack = new double[MAX];
		top = -1;
	} // end default constructor

	/**
	 * Checks if the stack is empty
	 * 
	 * @return True if it is and false if it is not
	 */
	public boolean isEmpty() {
		if (top < 0)
			return true;
		else
			return false;
	} // end isEmpty

	public boolean isFull() {
		if (top == MAX - 1)
			return true;
		else
			return false;
	} // end isFull

	/**
	 * Push the specified item onto the stack
	 * 
	 * @param newItem - The item to be pushed onto the stack
	 * @throws StackException
	 */
	public void push(double newItem) throws StackException {
		if (!isFull()) {
			stack[++top] = newItem;
		} else {
			throw new StackException("StackException on push: stack full");
		} // end if
	} // end push

	/**
	 * Pops out all the elements in the stack
	 */
	public void popAll() {
		stack = new double[MAX];
		top = -1;
	} // end popAll

	/**
	 * Pops off the top element in the stack
	 * 
	 * @return The top element that was popped off
	 * @throws StackException
	 */
	public double pop() throws StackException {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			throw new StackException("StackException on pop: stack empty");
		} // end if
	} // end pop

	/**
	 * Allows the user to peek at the top element on the stack
	 * 
	 * @return The top element on the stack
	 * @throws StackException
	 */
	public double peek() throws StackException {
		if (!isEmpty()) {
			return stack[top];
		} else {
			throw new StackException("Stack exception on "
					+ "peek - stack empty");
		} // end if
	} // end peek

}
