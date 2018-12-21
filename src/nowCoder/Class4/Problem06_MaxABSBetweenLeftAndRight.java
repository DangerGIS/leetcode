package nowCoder.Class4;

public class Problem06_MaxABSBetweenLeftAndRight {

	public static int maxABS1(int[] arr) {
		int n = arr.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		leftMax[0] = arr[0];
		rightMax[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}
		int max = 0;
		for (int i = 0; i < n - 1; i++) {
			max = Math.max(max, Math.abs(leftMax[i] - rightMax[i + 1]));
		}
		return max;
	}

	public static int maxABS2(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max - Math.min(arr[0], arr[arr.length - 1]);
	}

	public static int[] generateRandomArray() {
		int[] arr = new int[(int) (Math.random() * 98) + 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 200) + 2;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			int[] arr = generateRandomArray();
			if (maxABS1(arr) != maxABS2(arr)) {
				System.out.println("error");
			}
		}
	}

}
