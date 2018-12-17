package nowCoder.Class2.Test;

import java.util.HashSet;
import java.util.Scanner;

public class Problem01_score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int p = sc.nextInt();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(fun(arr, p));
		}
	}

	public static int fun(int[] arr, int p) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i] % p;
			if (set.contains(key)) {
				return i + 1;
			} else {
				set.add(key);
			}
		}
		return -1;
	}

}
