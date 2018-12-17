package nowCoder.Class3;

public class Problem01_PackingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 0, 5 };
		System.out.println(minOps(arr));
	}

	public static int minOps(int[] arr) {
		int sum = 0;
		for (int a : arr)
			sum += a;
		if (sum % arr.length != 0) {
			return -1;
		}
		int avg = sum / arr.length;
		int leftNum = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int L = i * avg - leftNum;// 正 i的左边需要L件，负 给
			int R = (arr.length - i - 1) * avg - (sum - leftNum - arr[i]);
			if (L > 0 && R > 0) {
				res = Math.max(res, L + R);
			} else {
				res = Math.max(res, Math.max(Math.abs(L), Math.abs(R)));
			}
		}
		return res;
	}

}
