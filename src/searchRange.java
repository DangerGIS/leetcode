
public class searchRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0)
			return res;
		// 两遍二分查找
		// 第一遍用来找左边界，若是取mid小于target, 左边界会在后半部分.
		// 若mid 大于 或者 等于 target时左边界都会在前半部分。
		int left1 = 0;
		int right1 = nums.length - 1;
		while (left1 <= right1) {
			int mid = left1 + (right1 - left1) / 2;
			if (nums[mid] < target)
				left1 = mid + 1;
			else
				right1 = mid - 1;
		}
		// 第二遍用来找右边界，原理相同
		int left2 = 0;
		int right2 = nums.length - 1;
		while (left2 <= right2) {
			int mid = left2 + (right2 - left2) / 2;
			if (nums[mid] <= target)
				left2 = mid + 1;
			else
				right2 = mid - 1;
		}

		// 判断是否找到过target呢，若是找到了target, 那么left1 不会在right2 的右侧
		if (left1 > right2)
			return res;
		res[0] = left1;
		res[1] = right2;
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 7, 7, 8, 9, 10 };
		int[] res = searchRange(nums, 7);
		System.out.println(res[0] + "," + res[1]);
	}

}
