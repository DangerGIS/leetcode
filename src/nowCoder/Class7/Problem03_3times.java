package nowCoder.Class7;

public class Problem03_3times {
	public static int getNum(int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; i++) {
			long tmp = (long) (i) * (long) (i + 1) / 2L;// 等差数列和
			if (tmp % 3 == 0) {
				sum++;
			}
		}
		return sum;
	}
}
