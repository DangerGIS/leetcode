package nowCoder.Class2.Test;

import java.util.Scanner;

public class Problem02_Chess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			int x1 = s.charAt(0);
			int y1 = s.charAt(1);
			s = sc.next();
			int x2 = s.charAt(0);
			int y2 = s.charAt(1);
			if (x1 == x2 && y1 == y2) {
				System.out.println("0 0 0 0");
			}
			System.out.println(King(x1, y1, x2, y2) + " " + Queen(x1, y1, x2, y2) + " " + Car(x1, y1, x2, y2) + " "
					+ Elephant(x1, y1, x2, y2));
		}
	}

	public static int King(int x1, int y1, int x2, int y2) {
		int x = Math.abs(x1 - x2);
		int y = Math.abs(y1 - y2);
		return x > y ? x : y;
	}

	public static int Queen(int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			return 1;
		} else {
			return 2;
		}
	}

	public static int Car(int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2) {
			return 1;
		} else {
			return 2;
		}
	}

	public static String Elephant(int x1, int y1, int x2, int y2) {
		if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			return "1";
		}
		if (Math.abs(Math.abs(x1 - x2) - Math.abs(y1 - y2)) % 2 != 0) {// 由于黑象只能走黑格，白象只走白格。所以如果起点与终点的颜色不同输出Inf
			return "Inf";
		}
		return "2";
	}

}
