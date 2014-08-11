package stack;

import java.util.Stack;


public class StackOperations {
	public static void main(String args[]) {
		
		
		// creating stack
		Stack<Integer> st = new Stack<Integer>();

		// populating stack
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);																																																																								
		
		//check last element of the stack without removing it
		 System.out.println("Last Element in the stack: " + st.peek());

		// Pop operation
		System.out.println("Removed object is: " + st.pop());
		
		//check last element of the stack without removing it
		 System.out.println("Last Element in the stack: " + st.peek());
		 
		// Push operation
		System.out.println("Elements after remove: " + st);
		
		// Search the position of the object
		System.out.println("The position of the object : 2 is (from top) =  " + st.search(2));
		
		// to check weather the stack is empty or not
		System.out.println("Empty ?  =  " + st.empty());
		
		
	}

}