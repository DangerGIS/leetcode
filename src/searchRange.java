
public class searchRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0)
			return res;
		// ������ֲ���
		// ��һ����������߽磬����ȡmidС��target, ��߽���ں�벿��.
		// ��mid ���� ���� ���� targetʱ��߽綼����ǰ�벿�֡�
		int left1 = 0;
		int right1 = nums.length - 1;
		while (left1 <= right1) {
			int mid = left1 + (right1 - left1) / 2;
			if (nums[mid] < target)
				left1 = mid + 1;
			else
				right1 = mid - 1;
		}
		// �ڶ����������ұ߽磬ԭ����ͬ
		int left2 = 0;
		int right2 = nums.length - 1;
		while (left2 <= right2) {
			int mid = left2 + (right2 - left2) / 2;
			if (nums[mid] <= target)
				left2 = mid + 1;
			else
				right2 = mid - 1;
		}

		// �ж��Ƿ��ҵ���target�أ������ҵ���target, ��ôleft1 ������right2 ���Ҳ�
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
