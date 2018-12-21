package nowCoder.Class5;

public class Problem03_NearMultiple4Times {
	public static boolean nearMultiple4Times(int[] arr) {
		int fourTimes = 0; // ��4�ı��������ж��ٸ�
		int evenExpFourTimes = 0; // ��ż��������4�ı��������ж��ٸ�
		int odd = 0; // �����ж��ٸ�
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) != 0) {
				odd++;
			} else {
				if (arr[i] % 4 == 0) {
					fourTimes++;
				} else {
					evenExpFourTimes++;
				}
			}
		}
		return evenExpFourTimes == 0 ? (odd == 1 ? fourTimes > 0 : fourTimes + 1 >= odd) : (evenExpFourTimes >= odd);
	}

}
