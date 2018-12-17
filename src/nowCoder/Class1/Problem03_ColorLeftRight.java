package nowCoder.Class1;

public class Problem03_ColorLeftRight {

	public static void main(String[] args) {
		String s = "GGGGGR";
		System.out.println(minPaint(s));

	}

	public static int minPaint(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		char[] chs = s.toCharArray();
		int[] right_R = new int[chs.length];// 记录右边R的个数
		right_R[chs.length - 1] = chs[chs.length - 1] == 'R' ? 1 : 0;
		for (int i = chs.length - 2; i >= 0; i--) {// 从右往左
			right_R[i] = right_R[i + 1] + (chs[i] == 'R' ? 1 : 0);
		}
		int left_G = 0;// 左边G的个数
		int res = right_R[0];
		for (int i = 0; i < chs.length - 1; i++) {
			left_G += chs[i] == 'G' ? 1 : 0;
			res = Math.min(res, left_G + right_R[i + 1]);
		}
		res = Math.min(res, left_G + (chs[chs.length - 1] == 'G' ? 1 : 0));
		return res;
	}

}
