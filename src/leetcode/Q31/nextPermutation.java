package leetcode.Q31;

public class nextPermutation {
	// 1 2 7 4 3 1
	// 下一个排列为：
	// 1 3 1 2 4 7
	public static void nextPermutation(int[] nums) {
		int i, j;
		for (i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] > nums[i]) {// 确定2的位置
				for (j = nums.length - 1; j > i; j--) {// 从后往前找第一个比2大的数
					if (nums[j] > nums[i])
						break;
				}
				swap(nums, i, j);
				reverse(nums, i + 1, nums.length - 1);
				return;
			}
		}
		reverse(nums, 0, nums.length - 1);
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

	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 4, 3, 1 };
		nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}
