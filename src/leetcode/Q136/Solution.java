package leetcode.Q136;

public class Solution {
	// �󵥶������� ����ʱ�临�Ӷ�ΪO(n)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = singleNumber(new int[] { 1, 2, 4, 1, 2 });
		System.out.println(res);
	}

	public static int singleNumber(int[] nums) {
		// ��λ��������������������ͬ��������� ��0
		// ���ʣ�����������ǵ������Ǹ�
		int res = 0;
		for (int num : nums)
			res ^= num;
		return res;
	}
}
