package nowCoder.Class6;

import java.util.HashMap;

public class Problem04_PreAndInArrayToPosArray {
	public static int[] getPosArray(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		int len = pre.length;
		int[] pos = new int[len];
		// ��map��¼�������������Ԫ�ص�λ�ã��Ӷ�ֱ�ӵõ�ǰ������е�ͷ�������λ��
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		// ���������ǴӺ���ǰ��䣬�ʴ�len-1��λ�ÿ�ʼ
		setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
		return pos;

	}

	// ÿ�η��ص���si��������ɵ�λ��
	public static int setPos(int[] pre, int pi, int pj, int[] in, int ni, int nj, int[] s, int si,
			HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return si;
		}
		s[si--] = pre[pi];
		// ǰ���ͷ�������λ��
		int i = map.get(pre[pi]);
		si = setPos(pre, pj - nj + i + 1, pj, in, i + 1, nj, s, si, map);// �ȸ��ұ�
		return setPos(pre, pi + 1, pi + i - ni, in, ni, i - 1, s, si, map);// �ٸ����

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
