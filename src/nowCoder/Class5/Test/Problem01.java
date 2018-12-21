package nowCoder.Class5.Test;

import java.util.Scanner;

public class Problem01 {
	// 由于项链是环状，首尾相连，所以先复制字符串，然后左右指针开始遍历，
	// 先是右指针持续往右移动，直到包含ABCDE五个字符之后，更新长度，
	// 然后开始移动左指针，直到左右指针之间不完全包含ABCDE五个字符，
	// 然后移动右指针，直到完全包含，更新长度，一直下去，直到右指针到了字符串的右边界
	public static int getMax(char[] str) {
		// 项链长度
		int len = str.length / 2;
		// 只存放ABCDE宝石
		int[] book = new int[5];
		int i = 0, j = 0, num = 0;
		int min = len;// 最短包含ABCDE子串的长度
		while (i < str.length && j < str.length) {
			// 当右指针到达字符串右边界时，i=s.length()
			// 此时num=5，跳出循环
			while (i < str.length && num < 5) {
				// 遍历到A,则book['A']自增为1,下次再遍历A则不满足if
				// num代表已经遍历到的ABCDE中几个字符
				if ((str[j] >= 'A' && str[j] <= 'E') && book[str[i] - 'A'] == 0) {
					book[str[i] - 'A']++;
					num++;

				}
				i++; // 右指针向右移动
			}

			if (num < 5) {
				break;
			}
			min = Math.min(min, i - j);
			// 左指针向右移动，直到不完全包含ABCDE字符
			if ((str[j] >= 'A' && str[j] <= 'E') && book[str[j] - 'A'] == 1) {
				book[str[j] - 'A']--;
				num--;
			}
			j++;
		}
		return len - min;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			s += s;
			char[] str = s.toCharArray();
			System.out.println(getMax(str));
		}

	}
}
