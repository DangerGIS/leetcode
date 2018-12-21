package nowCoder.Class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem03_StackAndQueueConvert {
	// 两个队列实现栈功能
	public static class TwoQueueStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueueStack() {
			queue = new LinkedList<>();
			help = new LinkedList<>();
		}

		public void push(int value) {
			queue.add(value);
		}

		public int peek() {// 取而不删
			if (queue.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}
			// 将queue队列中除了队头，全部放到help队列中
			// 那么栈顶元素就是queue队列中唯一的队尾
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);// 取而不删
			swap();
			return res;
		}

		public int poll() {// 取且删
			if (queue.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}
			// 将queue队列中除了队头，全部放到help队列中
			// 那么栈顶元素就是queue队列中唯一的队尾
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}

		public void swap() {
			Queue<Integer> temp = queue;
			queue = help;
			help = temp;
		}
	}

	public static void main(String[] args) {
		TwoQueueStack a = new TwoQueueStack();
		a.push(2);
		a.push(3);
		a.push(4);
		System.out.println(a.poll());
		System.out.println(a.poll());
		System.out.println(a.poll());

		System.out.println("===============");
		TwoStackQueue b = new TwoStackQueue();
		b.add(1);
		b.add(2);
		b.add(3);
		System.out.println(b.peek());
		System.out.println(b.poll());
		System.out.println(b.poll());
		System.out.println(b.poll());
	}

	public static class TwoStackQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStackQueue() {
			stackPush = new Stack<>();
			stackPop = new Stack<>();
		}

		public void add(int value) {
			stackPush.push(value);
		}

		public int peek() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty");
			}
			if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}

		public int poll() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty");
			}
			if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

	}
}
