package nowCoder.Class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem03_StackAndQueueConvert {
	// ��������ʵ��ջ����
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

		public int peek() {// ȡ����ɾ
			if (queue.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}
			// ��queue�����г��˶�ͷ��ȫ���ŵ�help������
			// ��ôջ��Ԫ�ؾ���queue������Ψһ�Ķ�β
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);// ȡ����ɾ
			swap();
			return res;
		}

		public int poll() {// ȡ��ɾ
			if (queue.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}
			// ��queue�����г��˶�ͷ��ȫ���ŵ�help������
			// ��ôջ��Ԫ�ؾ���queue������Ψһ�Ķ�β
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
