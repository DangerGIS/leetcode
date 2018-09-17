package Tencent;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int line = in.nextInt();

		int[][] con = new int[line][3];

		for (int i = 0; i < line; i++) {
			con[i][0] = in.nextInt();
			con[i][1] = in.nextInt();
			con[i][2] = in.nextInt();
		}

		boolean[] flags = new boolean[line];

		for (int i = 0; i < line; i++) {
			flags[i] = fun(con[i]);
		}

		for (int i = 0; i < line; i++) {
			if (flags[i]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean fun(int[] lineA) {
		int maxSum = lineA[0] + lineA[1] + lineA[2];

		boolean flag = false;

		int temp = 0;

		for (int i = 0; temp <= (maxSum * 100); i++) {
			temp = lineA[1] * i + lineA[2];

			if (temp % lineA[0] == 0) {
				flag = true;

				break;
			}
		}

		return flag;
	}
}
