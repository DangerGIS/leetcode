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
		int num = s.length();// ��ʯ��
		s += s;// ������һ�����ַ������ѭ��������
		char[] str = s.toCharArray();
		// ���ABCDE���±�
		int[] indexArr = { -1, -1, -1, -1, -1 };
		int max = 0;// ����õ��ı�ʯ
		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 'A' && str[i] <= 'E') {
				indexArr[str[i] - 'A'] = i;// �����Ӧֵ�������±�
				if (fullIndex(indexArr)) {
					max = Math.max(max, num - Handin(indexArr));
				}
			}
		}
		return max;
	}

	// �Ͻ��ı�ʯ
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
		// �ж�indexArr���Ƿ��Ƿ�-1
		for (int i = 0; i < indexArr.length; i++) {
			if (indexArr[i] == -1) {
				return false;
			}
		}
		return true;
	}
}
