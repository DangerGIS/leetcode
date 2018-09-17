package Tencent;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int lcm = 1;
		int lcm2 = 1;
		int m = 0;
		for (int i = 1; i <= n; i++) {
			lcm = getSmallMul(lcm, i);
		}
		for (int i = n + 1; i > 0; i++) {
			lcm2 = getSmallMul(lcm2, i);
			if (lcm2 % lcm == 0) {
				m = i;
				break;
			}
		}
		System.out.println(m);

	}

	public static int getBigDiv(int a, int b) {// �������������Լ��
		if (b == 0)
			return a;
		return getBigDiv(b, a % b);
	}

	public static int getSmallMul(int a, int b) {// ������������С������
		return (a * b) / getBigDiv(a, b);
	}

	public static int getMoreSmallMul(int num[], int n) {// ����������С������
		if (n == 1)
			return num[n - 1];
		return getSmallMul(num[n - 1], getMoreSmallMul(num, n - 1));
	}

}
