package nowCoder.Class4.Test;

import java.util.Scanner;

public class Problem01_shuixianhua {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			StringBuffer str = new StringBuffer();

			for (int i = m; i <= n; i++) {
				int a = i / 100;// 百位
				int b = (i - a * 100) / 10;// 十位
				int c = i % 10;

				if (a * a * a + b * b * b + c * c * c == i) {
					str.append(i + " ");
				}

			}
			if (str.toString().equals("")) {
				System.out.println("no");
			} else {
				str.deleteCharAt(str.length() - 1);
				System.out.println(str.toString());
			}
		}
	}

}
