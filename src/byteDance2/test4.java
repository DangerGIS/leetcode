package byteDance2;

import java.util.Scanner;

public class test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int t = Integer.parseInt(str[1]);
		int[] arr = new int[n * t];
		String[] strs = sc.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < t; k++) {
				arr[i + k * n] = Integer.parseInt(strs[i]);
			}
		}
		lisGet(arr);
	}

	public static void lisGet(int[] arrayList) {

		int[] lisLength = new int[arrayList.length];

		for (int i = 0; i < arrayList.length; i++) {
			lisLength[i] = 1;
		}

		int max = 1;

		for (int i = 1; i < arrayList.length; i++) {
			for (int j = 0; j < i; j++) {

				if (arrayList[j] < arrayList[i] && (lisLength[j] + 1) > lisLength[i]) {
					lisLength[i] = lisLength[j] + 1;
				}

				if (max < lisLength[i]) { // 得到当前最长递增序列的长度以及该子序列的最末元素的位置
					max = lisLength[i];
				}
			}

		}

		System.out.println(max);
	}
}
