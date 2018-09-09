package Qleetcode.Q371;

import java.util.Scanner;

public class solution {
	// 不用“+”求两数之和
	// 不用“-”求两数之差
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(getSum(a, b));
		System.out.println(getSubtract(a, b));
		System.out.println(getNegate(a));
		System.out.println(getSubtract2(a, b));
	}

	public static int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return getSum(sum, carry);
	}

	public static int getSubtract(int a, int b) {
		if (b == 0) {
			return a;
		}
		int subtract = a ^ b;
		int borrow = ((~a) & b) << 1;
		return getSubtract(subtract, borrow);

	}

	// 求负数
	public static int getNegate(int a) {
		return ~a + 1;
	}

	// 通过负数求和
	public static int getSubtract2(int a, int b) {
		return getSum(a, getNegate(b));
	}
}
