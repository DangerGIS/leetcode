package leetcode.Q15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		Arrays.sort(nums);
		// 遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了
		for (int k = 0; k < nums.length - 2; k++) {
			// 如果第一个要fix的数就是正数了，那么后面的数字就都是正数，就永远不会出现和为0的情况
			if (nums[k] > 0)
				break;
			// 重复就跳过
			if (k > 0 && nums[k] == nums[k - 1])
				continue;
			int target = 0 - nums[k];
			int i = k + 1;
			int j = nums.length - 1;
			while (i < j) {
				if (nums[i] + nums[j] == target) {
					res.add(Arrays.asList(nums[k], nums[i], nums[j]));
					// 重复就跳过
					while (i < j && nums[i] == nums[i + 1])
						i++;
					while (i < j && nums[j] == nums[j - 1])
						j--;
					i++;
					j--;
				} else if (nums[i] + nums[j] < target) {
					// 如果两数之和小于target，则我们将左边那个指针i右移一位，使得指向的数字增大一些
					i++;
				} else// 如果两数之和大于target，则我们将右边那个指针j左移一位，使得指向的数字减小一些
					j--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums));
	}
}
