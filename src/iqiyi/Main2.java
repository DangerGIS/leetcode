package iqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int count = 0;
		List<List<Integer>> result = new ArrayList<List<Integer>>();

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>(); // 每个集合都有的 空子集
		res.add(subset);

		for (int i = 0; i < nums.length; i++) {
			int length = res.size();
			for (int j = 0; j < length; j++) {
				List<Integer> newSubset = new ArrayList<>(res.get(j));
				newSubset.add(nums[i]);
				res.add(newSubset);
			}
		}
		return res;
	}
}
