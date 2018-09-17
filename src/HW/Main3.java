package HW;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String res = fun(str1, str2);
		System.out.println(res);

	}

	public static String fun(String str1, String str2) {

		char nums1[] = str1.toCharArray();
		char nums2[] = str2.toCharArray();

		int result[] = new int[nums1.length + nums2.length];
		int n1[] = new int[nums1.length];
		int n2[] = new int[nums2.length];

		for (int i = 0; i < nums1.length; i++)
			n1[i] = nums1[i] - '0';
		for (int i = 0; i < nums2.length; i++)
			n2[i] = nums2[i] - '0';

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				result[i + j] += n1[i] * n2[j];
			}
		}

		for (int i = result.length - 1; i > 0; i--) {
			result[i - 1] += result[i] / 10;
			result[i] = result[i] % 10;
		}

		String res = "";
		for (int i = 0; i < result.length - 1; i++) {
			res += "" + result[i];
		}
		return res;
	}
}
