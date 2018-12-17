package MT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nums = in.nextInt();
		int threshold = in.nextInt();
		int[] prices = new int[nums];
		for (int i = 0; i < nums; i++) {
			prices[i] = in.nextInt();
		}
		Arrays.sort(prices);

		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[nums];
		backTrack(prices, visited, 0, 0, threshold, lists);// 求和为sum的所有组合数

		int res = Integer.MAX_VALUE;

		for (ArrayList<Integer> list : lists) {
			int temp = 0;
			for (Integer l : list) {

				temp += l;
			}
			if (temp < res) {
				res = temp;
			}
		}
		System.out.println(res);

	}

	public static void backTrack(int[] input, boolean[] visited, int n, int sum, int key,
			ArrayList<ArrayList<Integer>> lists) {

		if (sum >= key) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j <= n; j++) {
				if (visited[j]) {
					list.add(input[j]);
				}
			}
			lists.add(list);
			return;
		}
		if (n >= input.length)
			return;
		for (int i = n; i < input.length - 1; i++) {
			if (!visited[i]) {
				sum += input[i];
				visited[i] = true;
				backTrack(input, visited, i + 1, sum, key, lists);
				visited[i] = false;
				sum -= input[i];
				while (i < input.length - 1 && input[i] == input[i + 1])
					i++;
			}
		}
	}

	public static int maxFighting(ArrayList<ArrayList<Integer>> lists) {
		int size = lists.size();
		if (lists == null || size == 0)
			return -1;
		int maxMultipy = Integer.MIN_VALUE;
		int multipy = 1;
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> list = lists.get(i);
			for (int j = 0; j < list.size(); j++) {
				multipy *= list.get(j);
			}
			if (multipy > maxMultipy) {
				maxMultipy = multipy;
			}
			multipy = 1;
		}
		return maxMultipy;
	}

}
