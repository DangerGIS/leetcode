package nowCoder.Class5;

public class Problem04_ConvertStringToInteger {
	// �ж��ַ����Ƿ�Ϸ�
	public static boolean isValid(char[] str) {
		if (str[0] != '-' && (str[0] < '0' || str[0] > '9')) {
			return false;
		}
		if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
			return false;
		}
		if (str[0] == '0' && str.length > 1) {
			return false;
		}
		for (int i = 1; i < str.length; i++) {
			if (str[i] < '0' || str[i] > '9') {
				return false;
			}
		}
		return true;
	}

	public static int convert(String s) {
		if (s == null || s.equals("")) {
			throw new RuntimeException("can not convert");
		}
		char[] str = s.toCharArray();
		if (!isValid(str)) {
			throw new RuntimeException("can not convert");
		}
		boolean positive = str[0] == '-' ? false : true;// �ж��Ƿ�������
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		int cur = 0;
		for (int i = positive ? 0 : 1; i < str.length; i++) {
			cur = '0' - str[i];// �����ɸ���������Integer�ĸ�����Χ����
			// ��;ת����ʱ�����
			if ((res < minq) || (res == minq && cur < minr)) {
				throw new RuntimeException("can not convert");
			}
			res = res * 10 + cur;
		}
		// ����ʱ�����ڸ�����Сֵʱ
		if (positive && res == Integer.MIN_VALUE) {
			throw new RuntimeException("can not convert");
		}
		return positive ? -res : res;
	}

	public static void main(String[] args) {
		String test1 = "2147483647"; // max in java
		System.out.println(convert(test1));

		String test2 = "-2147483648"; // min in java
		System.out.println(convert(test2));

		String test3 = "2147483648"; // overflow
		System.out.println(convert(test3));

		String test4 = "-2147483649"; // overflow
		System.out.println(convert(test4));

		String test5 = "-123";
		System.out.println(convert(test5));

	}
}
