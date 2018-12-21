package nowCoder.Class4;

import java.util.HashMap;
import java.util.Map.Entry;

public class Problem05_WaterProblem {
	// 暴力解 Min(leftMax,rightMax)-arr[i]
	public static int getWater1(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		// 最左边和最右边不用考虑，肯定接不到水
		for (int i = 1; i < arr.length - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int l = 0; l < i; l++) {
				leftMax = Math.max(leftMax, arr[l]);
			}
			for (int r = i + 1; r < arr.length; r++) {
				rightMax = Math.max(rightMax, arr[r]);
			}
			value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
		}
		return value;
	}

	// 辅助数组
	public static int getWater2(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		int n = arr.length;
		int[] leftMax = new int[n];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}
		int[] rightMax = new int[n];
		rightMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}
		for (int i = 1; i < n - 1; i++) {
			value += Math.max(0, Math.min(leftMax[i], rightMax[i]) - arr[i]);
		}
		return value;

	}

	// 辅助变量
	public static int getWater3(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int value = 0;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];

		int L = 1;
		int R = arr.length - 2;
		while (L <= R) {
			if (leftMax <= rightMax) {
				value += Math.max(0, leftMax - arr[L]);
				leftMax = Math.max(leftMax, arr[L++]);
			} else {
				value += Math.max(0, rightMax - arr[R]);
				rightMax = Math.max(rightMax, arr[R--]);
			}
		}
		return value;
	}

	public static int[] generateRandomArray() {
		int[] arr = new int[(int) (Math.random() * 98) + 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 200) + 2;
		}
		return arr;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int[] arr = generateRandomArray();
			int r1 = getWater1(arr);
			int r2 = getWater2(arr);
			int r3 = getWater3(arr);
			// int r4 = getWater4(arr);
			if (r1 != r2 || r1 != r3) {
				System.out.println(r1 + " " + r2 + " " + r3);
			}
		}

		HashMap<String, String> map = new HashMap<String, String>();

		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}

	}

}
