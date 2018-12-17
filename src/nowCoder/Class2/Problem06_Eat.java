package nowCoder.Class2;

public class Problem06_Eat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 50; i++) {
			if (winner1(i) == winner2(i)) {
				System.out.println(i + " true");
			} else {
				System.out.println(i + " false");
			}
		}

	}

	// ������
	public static String winner1(int n) {
		if (n < 5) {
			return (n == 0 || n == 2) ? "����" : "����";
		}
		int base = 1;// �Լ���
		// �Գ�
		while (base <= n) {
			// ������֮���ں��ֵ��ӹ����У��ұ�ɺ���
			if (winner1(n - base).equals("����")) {
				return "����";
			}
			// ��ֹ���
			if (base > n / 4) {
				break;
			}
			base *= 4;
		}
		return "����";
	}

	public static String winner2(int n) {
		if (n % 5 == 0 || n % 5 == 2) {
			return "����";
		}
		return "����";
	}

}
