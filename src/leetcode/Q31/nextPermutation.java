package leetcode.Q31;

public class nextPermutation {
	// 1 2 7 4 3 1
	// ��һ������Ϊ��
	// 1 3 1 2 4 7
	public static void nextPermutation(int[] nums) {
		int i, j;
		for (i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] > nums[i]) {// ȷ��2��λ��
				for (j = nums.length - 1; j > i; j--) {// �Ӻ���ǰ�ҵ�һ����2�����
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
