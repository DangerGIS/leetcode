public class test4 {
	public static void main(String[] args) {

	}

	public boolean canJump(int[] nums) {
		int[] dp = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
			if (dp[i] < 0)
				return false;
		}
		return dp[nums.length - 1] >= 0;
	}

}
