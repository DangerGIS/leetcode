package leetcode.Q4;

public class findMedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		if (len % 2 == 0)
			return (findKth(nums1, nums2, 0, nums1.length, 0, nums2.length, len / 2)
					+ findKth(nums1, nums2, 0, nums1.length, 0, nums2.length, len / 2 + 1)) / 2.0f;
		else
			return findKth(nums1, nums2, 0, nums1.length, 0, nums2.length, len / 2 + 1);
	}

	// �ҵ����������е�kС����
	public static double findKth(int[] nums1, int[] nums2, int start1, int len1, int start2, int len2, int k) {
		// ʹ��nums1��Զ�ǳ��Ƚ϶̵�����
		if (len1 > len2)
			return findKth(nums2, nums1, start2, len2, start1, len1, k);
		if (len1 == 0)
			return nums2[start2 + k - 1];
		if (k == 1)
			return Math.min(nums1[start1], nums2[start2]);
		// int p = Math.min(k / 2, len1);// ���ַ�
		// ���p����len1�Ļ����ͻ����Խ����ʵ����⣬���ʱ����Ҫ������п���
		int p = Math.min(Math.max(k / 2, 1), len1);
		int q = k - p;

		if (nums1[start1 + p - 1] == nums2[start2 + q - 1])
			return nums1[start1 + p - 1];
		else if (nums1[start1 + p - 1] > nums2[start2 + q - 1])
			return findKth(nums1, nums2, start1, len1, start2 + q, len2 - q, k - q);
		else if (nums1[start1 + p - 1] < nums2[start2 + q - 1])
			return findKth(nums1, nums2, start1 + p, len1 - p, start2, len2, k - p);
		else
			return nums1[start1 + p - 1];
	}
}
