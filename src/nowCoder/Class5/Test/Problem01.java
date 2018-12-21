package nowCoder.Class5.Test;

import java.util.Scanner;

public class Problem01 {
	// ���������ǻ�״����β�����������ȸ����ַ�����Ȼ������ָ�뿪ʼ������
	// ������ָ����������ƶ���ֱ������ABCDE����ַ�֮�󣬸��³��ȣ�
	// Ȼ��ʼ�ƶ���ָ�룬ֱ������ָ��֮�䲻��ȫ����ABCDE����ַ���
	// Ȼ���ƶ���ָ�룬ֱ����ȫ���������³��ȣ�һֱ��ȥ��ֱ����ָ�뵽���ַ������ұ߽�
	public static int getMax(char[] str) {
		// ��������
		int len = str.length / 2;
		// ֻ���ABCDE��ʯ
		int[] book = new int[5];
		int i = 0, j = 0, num = 0;
		int min = len;// ��̰���ABCDE�Ӵ��ĳ���
		while (i < str.length && j < str.length) {
			// ����ָ�뵽���ַ����ұ߽�ʱ��i=s.length()
			// ��ʱnum=5������ѭ��
			while (i < str.length && num < 5) {
				// ������A,��book['A']����Ϊ1,�´��ٱ���A������if
				// num�����Ѿ���������ABCDE�м����ַ�
				if ((str[j] >= 'A' && str[j] <= 'E') && book[str[i] - 'A'] == 0) {
					book[str[i] - 'A']++;
					num++;

				}
				i++; // ��ָ�������ƶ�
			}

			if (num < 5) {
				break;
			}
			min = Math.min(min, i - j);
			// ��ָ�������ƶ���ֱ������ȫ����ABCDE�ַ�
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
