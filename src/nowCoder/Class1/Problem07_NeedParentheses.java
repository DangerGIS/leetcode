package nowCoder.Class1;

public class Problem07_NeedParentheses {

	public static void main(String[] args) {
		System.out.println(needParentheses(")())(()"));

	}

	public static int needParentheses(String s) {
		int left = 0;// ������
		int right = 0;// ������
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				left++;
			} else {// ����������ʱ
				if (left == 0) {
					right++;
				} else {
					left--;
				}
			}
		}
		return left + right;
	}

}
