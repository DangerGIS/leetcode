package leetcode.Q15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class threeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		Arrays.sort(nums);
		// �������������飬����ע�ⲻ�Ǳ��������һ��ֹͣ�����ǵ������������Ϳ�����
		for (int k = 0; k < nums.length - 2; k++) {
			// �����һ��Ҫfix�������������ˣ���ô��������־Ͷ�������������Զ������ֺ�Ϊ0�����
			if (nums[k] > 0)
				break;
			// �ظ�������
			if (k > 0 && nums[k] == nums[k - 1])
				continue;
			int target = 0 - nums[k];
			int i = k + 1;
			int j = nums.length - 1;
			while (i < j) {
				if (nums[i] + nums[j] == target) {
					res.add(Arrays.asList(nums[k], nums[i], nums[j]));
					// �ظ�������
					while (i < j && nums[i] == nums[i + 1])
						i++;
					while (i < j && nums[j] == nums[j - 1])
						j--;
					i++;
					j--;
				} else if (nums[i] + nums[j] < target) {
					// �������֮��С��target�������ǽ�����Ǹ�ָ��i����һλ��ʹ��ָ�����������һЩ
					i++;
				} else// �������֮�ʹ���target�������ǽ��ұ��Ǹ�ָ��j����һλ��ʹ��ָ������ּ�СһЩ
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
