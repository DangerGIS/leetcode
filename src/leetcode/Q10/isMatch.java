package leetcode.Q10;

public class isMatch {
	public static boolean isMatch(String s, String p) {
		// 若p为空，若s也为空，返回true，反之返回false
		if (p.isEmpty())
			return s.isEmpty();
		// 当p的第二个字符为*号时，由于*号前面的字符的个数可以任意，可以为0，
		// 那么我们先用递归来调用为0的情况，就是直接把这两个字符去掉再比较，
		// 或者当s不为空，且第一个字符和p的第一个字符相同时，我们再对去掉首字符的s和p调用递归，注意p不能去掉首字符，因为*号前面的字符可以有无限个
		if (p.length() > 1 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
					&& isMatch(s.substring(1), p));
		} else {// 如果第二个字符不为*号，那么我们就老老实实的比较第一个字符，然后对后面的字符串调用递归
			return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
					&& isMatch(s.substring(1), p.substring(1));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		String p = "c*a*b";

		System.out.println(isMatch(s, p));
	}

}
