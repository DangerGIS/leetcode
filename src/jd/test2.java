package jd;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		int a[][] = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] str = scanner.nextLine().split(" ");
			a[i][0] = Integer.parseInt(str[0]);
			a[i][1] = Integer.parseInt(str[1]);
			a[i][2] = Integer.parseInt(str[2]);

		}
		int res = fun(n, a);
		System.out.println(res);

	}

	public static int fun(int n, int[][] a) {
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[j][0] > a[i][0] && a[j][1] > a[i][1] && a[j][2] > a[i][2]) {
					res++;
					break;
				}
			}
		}
		return res;
	}

}
