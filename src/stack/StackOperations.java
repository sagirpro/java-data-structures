package stack;




public class StackOperations {
	private final int ARRAY_SIZE = 9;
	private String[] movies = new String[ARRAY_SIZE]; // Hold movie titles
	private int top = 0;

	/**
	 * Constructor
	 * 
	 * @param moviesIn
	 * @return 
	 * @return 
	 */

	public void Stack(String[] moviesIn) {
		movies = moviesIn;
	}

	/**
	 * Test for full stack
	 * @return 
	 */

	public void push(String moviesIn) {
		if (top >= movies.length)
			System.out.println("ERROR: Stack is full");

		top++;
		movies[top] = moviesIn;
	}

	/**
	 * Test for empty stack
	 */

	public String pop() {
		if (top == 0) {
			System.out.println("ERROR: Stack is empty");
			return " ";
		}

		top--;
		return movies[top];
	}

	public void peek() {
		// ???
	}
}