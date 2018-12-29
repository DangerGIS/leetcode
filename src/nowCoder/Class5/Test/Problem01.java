package nowCoder.Class5.Test;

import java.util.Scanner;

public class Problem01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			System.out.println(getMax(s));
		}

	}

	public static int getMax(String s) {
		int num = s.length();// 宝石数
		s += s;// 用两个一样的字符串组成循坏的现象
		char[] str = s.toCharArray();
		// 存放ABCDE的下标
		int[] indexArr = { -1, -1, -1, -1, -1 };
		int max = 0;// 最多拿到的宝石
		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 'A' && str[i] <= 'E') {
				indexArr[str[i] - 'A'] = i;// 放入对应值的索引下标
				if (fullIndex(indexArr)) {
					max = Math.max(max, num - Handin(indexArr));
				}
			}
		}
		return max;
	}

	// 上交的宝石
	public static int Handin(int[] indexArr) {
		int max = indexArr[0];
		int min = indexArr[0];
		for (int i = 1; i < indexArr.length; i++) {
			max = Math.max(max, indexArr[i]);
			min = Math.min(min, indexArr[i]);
		}
		return max - min + 1;
	}

	public static boolean fullIndex(int[] indexArr) {
		// 判断indexArr中是否都是非-1
		for (int i = 0; i < indexArr.length; i++) {
			if (indexArr[i] == -1) {
				return false;
			}
		}
		return true;
	}
}
