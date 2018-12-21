package nowCoder.Class4;

import java.util.Stack;

public class Problem02_GetMinStack {
	public static class MyStack {
		private Stack<Integer> dataStack;
		private Stack<Integer> minStack;

		public MyStack() {
			this.dataStack = new Stack<>();
			this.minStack = new Stack<>();
		}

		public void push(int num) {
			if (this.minStack.isEmpty()) {
				this.minStack.push(num);
			} else if (num < this.minStack.peek()) {
				this.minStack.push(num);
			}
			this.dataStack.push(num);

		}

		public int pop() {
			if (this.dataStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty");
			}
			int value = this.dataStack.pop();
			this.minStack.pop();
			return value;
		}

		public int getMin() {
			if (this.minStack.isEmpty()) {
				throw new RuntimeException("Your stack is empty");
			}
			return this.minStack.peek();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack1 = new MyStack();
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());
	}

}
