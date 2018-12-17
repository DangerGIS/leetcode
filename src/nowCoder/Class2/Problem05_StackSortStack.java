package nowCoder.Class2;

import java.util.Stack;

public class Problem05_StackSortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(6);
		stack.push(8);
		stack.push(4);
		stack.push(5);
		stack.push(0);
		stack.push(2);
		sortStackByStack(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<>();

		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!help.isEmpty() && help.peek() < temp) {
				stack.push(help.pop());
			}
			help.push(temp);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

}
