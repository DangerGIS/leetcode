package leetcode.Q10;

public class isMatch {
	public static boolean isMatch(String s, String p) {
		// ��pΪ�գ���sҲΪ�գ�����true����֮����false
		if (p.isEmpty())
			return s.isEmpty();
		// ��p�ĵڶ����ַ�Ϊ*��ʱ������*��ǰ����ַ��ĸ����������⣬����Ϊ0��
		// ��ô�������õݹ�������Ϊ0�����������ֱ�Ӱ��������ַ�ȥ���ٱȽϣ�
		// ���ߵ�s��Ϊ�գ��ҵ�һ���ַ���p�ĵ�һ���ַ���ͬʱ�������ٶ�ȥ�����ַ���s��p���õݹ飬ע��p����ȥ�����ַ�����Ϊ*��ǰ����ַ����������޸�
		if (p.length() > 1 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
					&& isMatch(s.substring(1), p));
		} else {// ����ڶ����ַ���Ϊ*�ţ���ô���Ǿ�����ʵʵ�ıȽϵ�һ���ַ���Ȼ��Ժ�����ַ������õݹ�
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
