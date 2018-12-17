package nowCoder.Class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem01_SubvalueEqualK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 22, 6, 8, 5, 35, 24, 9 };
		System.out.println(SubvalueEqualK(arr, 1));
	}

	public static List<List<Integer>> SubvalueEqualK(int[] arr, int k) {
		HashSet<Integer> set = new HashSet<>();
		for (Integer i : arr) {
			set.add(i);
		}
		List<List<Integer>> res = new ArrayList<>();
		for (Integer cur : set) {
			if (set.contains(cur + k)) {
				res.add(Arrays.asList(cur, cur + k));
			}
		}
		return res;
	}

}
