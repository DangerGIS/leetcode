package leetcode.Q32;

import java.util.Stack;

public class longestValidParentheses {

	public static int longestValidParentheses(String s) {
		int maxlen = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			// ������������ţ��򽫵�ǰ�±�ѹ��ջ
			if (s.charAt(i) == '(')
				stack.push(i);
			else {// ������������ţ������ǰջΪ�գ�����һ������λ�ü�¼��start�����ջ��Ϊ�գ���ջ��Ԫ��ȡ��
				stack.pop();
				if (stack.isEmpty())
					stack.push(i);
				else {
					maxlen = Math.max(maxlen, i - stack.peek());
				}
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("))()())"));
	}

}
