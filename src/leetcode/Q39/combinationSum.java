package leetcode.Q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);// 先排序
		backtrack(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	// list保存所有已经得到的解
	// templist为一个解
	// candidates表示原来的数组
	// remain表示 余下的值
	// start表示数组中的下标
	private static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] candidates, int remain,
			int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			// 需要使用list.add（new ArrayList <>（tempList））; 但不是list.add（tempList）;
			// 由于tempList将在以下代码中修改，因此使用list.add（tempList）添加到列表的内容也将更改。
			list.add(new ArrayList<>(templist));
		else {
			for (int i = start; i < candidates.length; i++) {
				templist.add(candidates[i]);
				backtrack(list, templist, candidates, remain - candidates[i], i);// 不是i+1，因为可以使用重复值
				templist.remove(templist.size() - 1);// 删除列表中的最后一个元素...最近添加的元素
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 2, 3, 6, 7 };
		List<List<Integer>> res = combinationSum(nums, 7);
		for (List l : res) {
			System.out.println(l.toString());
		}
	}

}
