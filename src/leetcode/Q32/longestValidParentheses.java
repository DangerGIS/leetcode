package leetcode.Q32;

import java.util.Stack;

public class longestValidParentheses {

	public static int longestValidParentheses(String s) {
		int maxlen = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			// 如果遇到左括号，则将当前下标压入栈
			if (s.charAt(i) == '(')
				stack.push(i);
			else {// 如果遇到右括号，弹出最顶层的元素并从堆栈的顶部元素中减去当前元素的索引，这给出了当前遇到的有效括号字符串的长度
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
