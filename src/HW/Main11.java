package HW;

public class Main11 {
	public static void main(String[] args) {
		String str = "BACCAAHEFGHFF";
		str = new StringBuffer(str).reverse().toString();

		String c = "";
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(0, i) + str.substring(i + 1);
			int idx = temp.indexOf(str.charAt(i));
			if (idx == -1) {// ʣ�µ��ַ�����û�У�����Ψһ��
				c = String.valueOf(str.charAt(i));
				break;
			}

		}
		System.out.println(c);

	}

}
