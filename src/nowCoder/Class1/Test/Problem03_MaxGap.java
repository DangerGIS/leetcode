package nowCoder.Class1.Test;

public class Problem03_MaxGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 7, 3, 1, 1 };
		int n = 5;
		System.out.println(findMaxGap(A, n));
	}

	// 就是这个K的移动情况会有两种极端的情况，【第一种】：A[0]与后面所有；
	// 【第二种】：A[n-1]与前面所有。而其他的任何情况都一定会比他们俩的最大的那一个小，为什么？
	// 以第一种举例，假设现在k右移，变成了A[0]A[1]与后面所有，那么左边部分的最大值就可能会变大，
	// 右边部分的最大值就可能变小，从而最后的差值变小，以此类推。所以此题的解只会在这两种情况里面产生。
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
