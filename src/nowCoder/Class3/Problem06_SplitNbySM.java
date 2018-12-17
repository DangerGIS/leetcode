package nowCoder.Class3;

public class Problem06_SplitNbySM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minOps(12));
	}

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		int max = (int) Math.sqrt(n);
		for (int i = 2; i < max; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int[] divsSumAndCount(int n) {
		int sum = 0;
		int count = 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				sum += i;
				count++;
				n = n / i;
			}
		}
		return new int[] { sum, count };
	}

	public static int minOps(int n) {
		if (n < 2) {
			return 0;
		}
		if (isPrime(n))
			return n - 1;
		int[] divsSumAndCount = divsSumAndCount(n);
		return divsSumAndCount[0] - divsSumAndCount[1];
	}

}
