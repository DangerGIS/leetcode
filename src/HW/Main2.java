package HW;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		Stack<Integer> stack = new Stack<Integer>();

		String res = "";

		for (int i = 0; i < line.length(); i++) {

			int charAt = line.charAt(i);

			if (charAt != 32) {
				stack.push(charAt);
			} else {
				while (!stack.empty()) {
					int pop = stack.pop();
					char aaa = (char) pop;
					res += aaa;
				}
				res += " ";
			}
		}

		while (!stack.empty()) {
			int pop = stack.pop();
			char aaa = (char) pop;
			res += aaa;
		}
		// res += " ";
		res.trim();
		System.out.println(res);

	}

}
