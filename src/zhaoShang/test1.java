package zhaoShang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		List<List<Integer>> result = findNum(new int[] { 1, 3, 5, 6 }, 8);
		for (List res : result) {
			System.out.println(res.toString());
		}
	}

	// 求集合中和为target的子集
	public static List<List<Integer>> findNum(int[] input, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		findNumHelper(input, 0, temp, result, target);
		return result;
	}

	public static void findNumHelper(int[] input, int pos, List<Integer> temp, List<List<Integer>> result, int target) {

		for (int i = pos; i < input.length; i++) {
			if (target == input[i]) {
				temp.add(input[i]);
				result.add(new ArrayList<Integer>(temp));
				temp.remove(temp.size() - 1);
				return;
			} else if (target > input[i]) {
				temp.add(input[i]);
				findNumHelper(input, i, temp, result, target - input[i]);
				temp.remove(temp.size() - 1);
			} else {
				return;
			}
		}
	}

}
