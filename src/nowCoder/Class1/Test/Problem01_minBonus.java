package nowCoder.Class1.Test;

import java.util.Scanner;

public class Problem01_minBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// while (sc.hasNext()) {
		//
		// }
		int n = sc.nextInt();
		int[] grades = new int[n];
		int[] money = new int[n];
		for (int i = 0; i < n; i++) {
			grades[i] = sc.nextInt();
			money[i] = 1;
		}
		System.out.println(minBonus1(n, grades, money));
	}

	public static int minBonus(int n, int[] grades, int[] money) {

		for (int i = 0; i < n - 1; i++) {
			if (grades[i] < grades[i + 1]) {
				money[i + 1] = money[i] + 1;
			} else if (grades[i] > grades[i + 1]) {
				if (money[i] == 1) {
					int k = i;
					while (k >= 0 && grades[k] > grades[k + 1] && money[k] <= money[k + 1]) {
						money[k] = money[k + 1] + 1;
						k--;
					}
				}
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++)
			res += money[i];
		return res;
	}

	// 从前往后来一遍，后面比前面大就++；再从后往前一遍 ，前面比后面大就++
	public static int minBonus1(int n, int[] grades, int[] money) {
		for (int i = 1; i < n; i++) {
			if (grades[i] > grades[i - 1]) {
				money[i] = money[i - 1] + 1;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (grades[i] > grades[i + 1] && money[i] <= money[i + 1]) {
				money[i] = money[i + 1] + 1;
			}
		}
		int res = 0;
		for (int i = 0; i < n; i++)
			res += money[i];
		return res;
	}

}
