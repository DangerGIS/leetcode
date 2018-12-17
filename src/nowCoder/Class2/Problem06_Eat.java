package nowCoder.Class2;

public class Problem06_Eat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 50; i++) {
			if (winner1(i) == winner2(i)) {
				System.out.println(i + " true");
			} else {
				System.out.println(i + " false");
			}
		}

	}

	// 暴力解
	public static String winner1(int n) {
		if (n < 5) {
			return (n == 0 || n == 2) ? "后手" : "先手";
		}
		int base = 1;// 吃几份
		// 试吃
		while (base <= n) {
			// 我先手之后，在后手的子过程中，我变成后手
			if (winner1(n - base).equals("后手")) {
				return "先手";
			}
			// 防止溢出
			if (base > n / 4) {
				break;
			}
			base *= 4;
		}
		return "后手";
	}

	public static String winner2(int n) {
		if (n % 5 == 0 || n % 5 == 2) {
			return "后手";
		}
		return "先手";
	}

}
