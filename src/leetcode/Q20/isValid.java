package leetcode.Q20;

import java.util.Stack;

public class isValid {
	// ≈–∂œ¿®∫≈ «∑Ò∆•≈‰
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '{' || c == '[' || c == '(')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				if (c == ')' && stack.peek() != '(')
					return false;
				if (c == ']' && stack.peek() != '[')
					return false;
				if (c == '}' && stack.peek() != '{')
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{)}"));
	}

}
