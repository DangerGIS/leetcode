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
			else {// ������������ţ���������Ԫ�ز��Ӷ�ջ�Ķ���Ԫ���м�ȥ��ǰԪ�ص�������������˵�ǰ��������Ч�����ַ����ĳ���
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
