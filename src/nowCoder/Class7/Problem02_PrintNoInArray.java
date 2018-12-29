package nowCoder.Class7;

public class Problem02_PrintNoInArray {
	public static void printNumberNoInArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			modify(arr[i], arr);
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				System.out.println(i + 1);
			}
		}

	}

	public static void modify(int value, int[] arr) {
		while (arr[value - 1] != value) {
			int tmp = arr[value - 1];
			arr[value - 1] = value;
			value = tmp;
		}
	}

	public static void main(String[] args) {
		int[] test = { 1, 3, 4, 3 };
		printNumberNoInArray(test);
	}
}
