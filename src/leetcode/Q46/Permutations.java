package leetcode.Q46;

import java.util.ArrayList;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		DFS(result, new ArrayList<>(), nums);
		return result;
	}

	public static void DFS(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue;// 跳过用过的数
				tempList.add(nums[i]);
				DFS(result, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = permute(nums);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}

}
