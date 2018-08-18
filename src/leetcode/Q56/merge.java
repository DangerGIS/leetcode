package leetcode.Q56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class merge {

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1 || intervals == null)
			return intervals;
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
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Interval> input = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Interval temp = new Interval(x, y);
			input.add(temp);

		}
		List<Interval> output = merge(input);
		for (Interval i : output) {
			System.out.println(i.start + " " + i.end);
		}

	}

}
