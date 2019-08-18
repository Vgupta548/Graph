package stackDS;

import java.util.Stack;

public class BalancedParentheses {

	/* driver program to test above functions */
	public static void main(String[] args) {
		char exp[] = { '{', '(', ')', '}', '[', ']' };
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
		
		char exp1[] = { '{', '(', ')', '}', ']', ']' };
		if (areParenthesisBalanced(exp1))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
		
		
	}

	/*
	 * Return true if expression has balanced Parenthesis
	 */
	static boolean areParenthesisBalanced(char exp[]) {
		/* Declare an empty character stack */
		Stack<Character> st = new Stack();

		/*
		 * Traverse the given expression to check matching parenthesis
		 */
		for (int i = 0; i < exp.length; i++) {

			/*
			 * If the exp[i] is a starting parenthesis then push it
			 */
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				st.push(exp[i]);

			/*
			 * If exp[i] is an ending parenthesis then pop from stack and check if the
			 * popped parenthesis is a matching pair
			 */
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {

				/*
				 * If we see an ending parenthesis without a pair then return false
				 */
				if (st.isEmpty()) {
					return false;
				}

				/*
				 * Pop the top element from stack, if it is not a pair parenthesis of character
				 * then there is a mismatch. This happens for expressions like {(})
				 */
				else if (!isMatchingPair(st.pop(), exp[i])) {
					return false;
				}
			}

		}

		/*
		 * If there is something left in expression then there is a starting parenthesis
		 * without a closing parenthesis
		 */

		if (st.isEmpty())
			return true; /* balanced */
		else { /* not balanced */
			return false;
		}
	}

	/*
	 * Returns true if character1 and character2 are matching left and right
	 * Parenthesis
	 */
	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}
}
