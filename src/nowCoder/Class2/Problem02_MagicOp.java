package nowCoder.Class2;

import java.util.Arrays;
import java.util.HashSet;

public class Problem02_MagicOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 2, 5 };
		int[] arr2 = { 2, 3, 4, 5, 6 };
		System.out.println(maxOps(arr1, arr2));
	}

	public static int maxOps(int[] A, int[] B) {
		// ���������ϵ�ƽ��ֵ�������ִ�С����
		double sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}
		for (int i = 0; i < B.length; i++) {
			sumB += (double) B[i];
		}
		int[] arrMore = null;
		int[] arrLess = null;
		double sumMore = 0;
		double sumLess = 0;
		// �����������ƽ��ֵ��ȣ����ܲ���
		if (avg(sumA, A.length) == avg(sumB, B.length)) {
			return 0;
		}
		// ���ֳ���С����
		if (avg(sumA, A.length) > avg(sumB, B.length)) {
			arrMore = A;
			sumMore = sumA;
			arrLess = B;
			sumLess = sumB;
		} else {
			arrMore = B;
			sumMore = sumB;
			arrLess = A;
			sumLess = sumA;
		}
		// �󼯺����򣬱��ڴ�С��ʼȡ
		Arrays.sort(arrMore);
		// ��֤����С�������Ա��ּ��ϵ�����
		HashSet<Integer> setLess = new HashSet<>();
		for (Integer num : arrLess)
			setLess.add(num);

		int moreSize = arrMore.length;
		int lessSize = arrLess.length;
		int ops = 0;// ������
		for (int i = 0; i < arrMore.length; i++) {
			double cur = arrMore[i];
			if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize) && !setLess.contains(arrMore[i])) {
				sumMore -= cur;
				moreSize--;
				sumLess += cur;
				lessSize++;
				ops++;
			}
		}
		return ops;

	}

	public static double avg(double sum, int size) {
		return sum / size;
	}

}
