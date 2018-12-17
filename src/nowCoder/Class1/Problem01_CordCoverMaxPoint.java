package nowCoder.Class1;

public class Problem01_CordCoverMaxPoint {
	// ����ΪL��������า�Ǽ����㣬�뱣֤arr����
	public static int maxPoint(int[] arr, int L) {
		int res = 1;
		for (int i = 0; i < arr.length; i++) {
			int nearest = nearestIndex(arr, i, arr[i] - L);
			res = Math.max(res, i - nearest + 1);
		}
		return res;
	}

	// ��arr[0..R]��Χ�ϣ�������>=value������λ��
	public static int nearestIndex(int[] arr, int R, int value) {
		int L = 0;
		int index = R;
		while (L < R) {
			int mid = L + ((R - L) >> 1);
			if (arr[mid] >= value) {
				index = mid;
				R = mid - 1;
			} else
				L = mid + 1;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 13, 24, 35, 46, 57, 60, 72, 87 };
		int L = 6;

		System.out.println(maxPoint(arr, L));

	}
}
