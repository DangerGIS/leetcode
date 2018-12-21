package nowCoder.Class5;

public class Problem02_DeleteWood {
	public static int minDelete(int n) {
		if (n < 4) {
			return 0;
		}
		int a = 2;
		int b = 3;
		int num = 3;// 已经有三个数符合条件了（1，2，3）
		// 斐波那契数列
		while (a + b <= n) {
			num++;
			b = a + b;
			a = b - a;
		}
		return n - num;

	}

	public static void main(String[] args) {
		int test = 8;
		System.out.println(minDelete(test));
		System.out.println(minDelete2(test));
	}

	public static int minDelete2(int m) {
		if (m < 4) {
			return 0;
		}
		int k_2 = 2;
		int k_1 = 3;
		int num = 3;
		while (k_2 + k_1 <= m) {
			num++;
			k_1 += k_2;
			k_2 = k_1 - k_2;
		}
		return m - num;
	}
}
