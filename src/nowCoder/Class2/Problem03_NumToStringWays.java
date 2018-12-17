package nowCoder.Class2;

public class Problem03_NumToStringWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12258;
		System.out.println(convertWays(num));
		System.out.println(dpways(num));
	}

	public static int convertWays(int num) {
		if (num < 1) {
			return 0;
		}
		return process(String.valueOf(num).toCharArray(), 0);
	}

	// �����ݹ�
	public static int process(char[] str, int index) {
		// �������ַ�
		if (index == str.length) {
			return 1;
		}
		// �������ַ�
		// ��0��ͷ 0...
		if (str[index] == '0') {
			return 0;
		}
		// �������ַ�����0��ͷ
		int res = process(str, index + 1);
		if (index == str.length - 1) {// ����index��û�б���ַ���
			return res;
		}
		// ����index��,���б���ַ���index��index+1���
		if (((str[index] - '0') * 10 + (str[index + 1] - '0')) < 27) {
			res += process(str, index + 2);
		}
		return res;

	}

	// ��̬�滮
	public static int dpways(int num) {
		if (num < 1) {
			return 0;
		}
		char[] str = String.valueOf(num).toCharArray();
		int[] dp = new int[str.length + 1];// ��Ϊindex���� == str.length
		dp[str.length] = 1;
		dp[str.length - 1] = str[str.length - 1] == '0' ? 0 : 1;
		for (int i = str.length - 2; i >= 0; i--) {
			if (str[i] == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i + 1] + (((str[i] - '0') * 10 + (str[i + 1] - '0')) < 27 ? dp[i + 2] : 0);
			}
		}
		return dp[0];
	}

}
