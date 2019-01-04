package nowCoder.Class6;

import java.util.HashMap;

public class Problem04_PreAndInArrayToPosArray {
	public static int[] getPosArray(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		int len = pre.length;
		int[] pos = new int[len];
		// 用map记录中序遍历数组中元素的位置，从而直接得到前序遍历中的头在中序的位置
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		// 后序数组是从后往前填充，故从len-1的位置开始
		setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
		return pos;

	}

	// 每次返回的是si，后序完成的位置
	public static int setPos(int[] pre, int pi, int pj, int[] in, int ni, int nj, int[] s, int si,
			HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return si;
		}
		s[si--] = pre[pi];
		// 前序的头在中序的位置
		int i = map.get(pre[pi]);
		si = setPos(pre, pj - nj + i + 1, pj, in, i + 1, nj, s, si, map);// 先搞右边
		return setPos(pre, pi + 1, pi + i - ni, in, ni, i - 1, s, si, map);// 再搞左边

	}

	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		int[] in = { 4, 2, 5, 1, 6, 3, 7 };
		int[] pos = getPosArray(pre, in);
		printArray(pos);

	}
}
