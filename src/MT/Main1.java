package MT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str1 = sc.nextLine().split(" ");
		int n = Integer.parseInt(str1[0]);
		int X = Integer.parseInt(str1[1]);

		String[] str2 = sc.nextLine().split(" ");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(str1[i]);
		}

	}

	// public int[] sum(ArrayList<ArrayList<Integer>> res) {
	// int[] sumArr = new int[res.size()];
	// for (int i = 0; i < res.size(); i++) {
	//
	// }
	// }

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(new ArrayList<Integer>());
		dfs(S, 0, list, res);
		return res;
	}

	public static void dfs(int[] S, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
		for (int i = start; i < S.length; i++) {
			list.add(S[i]);
			res.add(new ArrayList<Integer>(list));
			dfs(S, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}

}
