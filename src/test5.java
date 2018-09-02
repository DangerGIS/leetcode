import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Interval {
	int id;// 社团编号
	int start;
	int end;

	Interval() {
		id = 0;
		start = 0;
		end = 0;
	}

	Interval(int index, int s, int e) {
		id = index;
		start = s;
		end = e;
	}
}

public class test5 {
	public static void merge(List<Interval> intervals) {
		if (intervals.size() <= 1 || intervals == null)
			System.out.println(0);
		Collections.sort(intervals, new Comparator<Interval>() {// 先将区间排序
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		if (isNotMix(intervals))// 原区间没有重叠，删除任意团都可以
			for (int j = 0; j < intervals.size(); j++) {
				System.out.format("%d ", j + 1);
			}
		int count = 0;
		for (int i = 0; i < intervals.size() - 1; i++) {
			List<Interval> tempIntervals = intervals;
			if (intervals.get(i).start <= intervals.get(i + 1).end) {
				tempIntervals.remove(i);
				if (isNotMix(tempIntervals) == true) {
					count++;
					System.out.format("%d ", tempIntervals.get(i).id);
				}
			}

		}
		if (count == 0)
			System.out.println(0);
	}

	// 判断剩余部分是否 无重叠
	public static boolean isNotMix(List<Interval> intervals) {
		Interval temp = intervals.get(0);
		for (Interval interval : intervals) {
			if (interval.start <= temp.end) {
				return false;
			} else {
				temp = interval;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Interval> input = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			Interval temp = new Interval(i + 1, x, y);
			input.add(temp);

		}

		merge(input);

	}
}
