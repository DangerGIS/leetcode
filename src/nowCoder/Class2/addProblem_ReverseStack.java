package nowCoder.Class2;

import java.util.Stack;

public class addProblem_ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		reverse(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = g(stack);
		reverse(stack);
		stack.push(i);
	}

	// 移除掉并返回栈底元素，其他顺序不变
	public static int g(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = g(stack);
			stack.push(result);
			return last;
		}
	}

}
