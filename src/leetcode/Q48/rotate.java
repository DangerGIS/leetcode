package leetcode.Q48;

public class rotate {
	public static void rotate(int[][] matrix) {
		// 先转置再以y轴方向对称交换
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				swap(matrix, i, j);
			}
			reverse(matrix[i], 0, matrix[i].length - 1);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		for (int[] a : matrix) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public static void swap(int[][] nums, int i, int j) {
		int temp = nums[i][j];
		nums[i][j] = nums[j][i];
		nums[j][i] = temp;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
}
