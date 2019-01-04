package nowCoder.Class1;

public class Problem06_UniqueBST {

	public static void main(String[] args) {
		System.out.println(process(4));
		System.out.println(numTrees(4));
	}

	public static int process(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int res = 0;
		for (int leftNum = 0; leftNum <= n - 1; leftNum++) {
			int leftWays = process(leftNum);
			int rightWays = process(n - 1 - leftNum);
			res += leftWays * rightWays;
		}
		return res;
	}

	public static int numTrees(int n) {
		if (n < 2) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				num[i] += num[j - 1] * num[i - j];
			}
		}
		return num[n];
	}
}
