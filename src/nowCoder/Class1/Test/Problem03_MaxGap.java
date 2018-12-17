package nowCoder.Class1.Test;

public class Problem03_MaxGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 7, 3, 1, 1 };
		int n = 5;
		System.out.println(findMaxGap(A, n));
	}

	// �������K���ƶ�����������ּ��˵����������һ�֡���A[0]��������У�
	// ���ڶ��֡���A[n-1]��ǰ�����С����������κ������һ�������������������һ��С��Ϊʲô��
	// �Ե�һ�־�������������k���ƣ������A[0]A[1]��������У���ô��߲��ֵ����ֵ�Ϳ��ܻ���
	// �ұ߲��ֵ����ֵ�Ϳ��ܱ�С���Ӷ����Ĳ�ֵ��С���Դ����ơ����Դ���Ľ�ֻ����������������������
	public static int findMaxGap(int[] A, int n) {
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		int min = Math.min(A[0], A[n - 1]);
		return max - min;
	}

}
