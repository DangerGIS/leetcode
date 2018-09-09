package leetcode.Q136;

public class Solution {
	// 求单独的数字 并且时间复杂度为O(n)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = singleNumber(new int[] { 1, 2, 4, 1, 2 });
		System.out.println(res);
	}

	public static int singleNumber(int[] nums) {
		// 用位操作符来做，把两个相同的数字异或 是0
		// 最后剩下来的数就是单独的那个
		int res = 0;
		for (int num : nums)
			res ^= num;
		return res;
	}
}
