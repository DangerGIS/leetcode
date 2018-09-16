package beiKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Interval {
	int start;
	int end;
	int i;

	Interval(int i, int s, int e) {
		this.start = s;
		this.end = e;
		this.i = i;
	}
}

public class Main {
	public static int func(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {// 先将区间排序
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		Interval temp = intervals.get(0);
		for (Interval interval : intervals) {
			if (interval.start <= temp.end) {
				temp.start = Math.min(interval.start, temp.start);
				temp.end = Math.max(interval.end, temp.end);
			} else {
				result.add(temp);
				temp = interval;
			}
		}
		result.add(temp);
		if (result.size() == 1)
			return intervals.size();
		else
			return 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Interval> input = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Interval temp = new Interval(i, x, x + y - 1);
			input.add(temp);
		}
		Collections.sort(input, new Comparator<Interval>() {// 先将区间排序
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		int[] output = new int[n];
		for (int i = 0; i < n; i++) {

		}
		for (int i = 0; i < n; i++) {
			System.out.println(output[i] + " ");
		}
	}

}
