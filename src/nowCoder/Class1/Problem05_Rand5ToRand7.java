package nowCoder.Class1;

public class Problem05_Rand5ToRand7 {
	public static void main(String[] args) {
		int[] countArr = new int[11];

		for (int i = 0; i < 2000000; i++) {
			countArr[g(10)]++;

		}
		printCountArray(countArr);
	}

	public static void printCountArray(int[] countArr) {
		for (int i = 0; i != countArr.length; i++) {
			System.out.println(i + " appears " + countArr[i] + " times");
		}
	}

	// 0~5等概率发生器
	public static int f1() {
		return (int) (Math.random() * 6);
	}

	// 变换成0~1等概率发生器
	public static int f2() {
		int res = 0;
		do {
			res = f1();
		} while (res == 5);
		return (res == 0 || res == 1) ? 0 : 1;
	}

	// 0~n等概率发生器
	public static int g(int n) {
		int needBit = 1;
		while ((1 << needBit) - 1 < n) {
			needBit++;
		}
		int res = 0;
		do {
			res = 0;
			for (int i = 0; i < needBit; i++) {
				res += (f2() << i);
			}
		} while (res > n);
		return res;

	}
}
