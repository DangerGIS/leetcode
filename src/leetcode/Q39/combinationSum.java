package leetcode.Q39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);// ������
		backtrack(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	// list���������Ѿ��õ��Ľ�
	// templistΪһ����
	// candidates��ʾԭ��������
	// remain��ʾ ���µ�ֵ
	// start��ʾ�����е��±�
	private static void backtrack(List<List<Integer>> list, List<Integer> templist, int[] candidates, int remain,
			int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			// ��Ҫʹ��list.add��new ArrayList <>��tempList����; ������list.add��tempList��;
			// ����tempList�������´������޸ģ����ʹ��list.add��tempList����ӵ��б������Ҳ�����ġ�
			list.add(new ArrayList<>(templist));
		else {
			for (int i = start; i < candidates.length; i++) {
				templist.add(candidates[i]);
				backtrack(list, templist, candidates, remain - candidates[i], i);// ����i+1����Ϊ����ʹ���ظ�ֵ
				templist.remove(templist.size() - 1);// ɾ���б��е����һ��Ԫ��...�����ӵ�Ԫ��
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
