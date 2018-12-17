package iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		Arrays.sort(arr);
		int count = 1;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				count++;
			}
		}
		System.out.println(count);

	}

}
