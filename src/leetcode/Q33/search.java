package leetcode.Q33;

public class search {

	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		if (nums.length == 0)
			return -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < nums[right]) {
				if (nums[mid] < target && nums[right] >= target)
					left = mid + 1;
				else
					right = mid - 1;
			} else {
				if (nums[mid] > target && nums[left] <= target)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����������ת���֣�����м����С�����ұߵ��������Ұ��������ģ����м����������ұ������������������
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(nums, 3));
	}

}
