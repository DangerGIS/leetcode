package byteDance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//�⣺��m���༭�ҳ��Ĵ�������ϲ�
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

public class test2 {
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1 || intervals == null)
			return intervals;
		List<Interval> result = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {// �Ƚ���������
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
		int m = Integer.parseInt(sc.nextLine());// �༭����
		List<Interval> input = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String[] str = sc.nextLine().split(";");
			for (int j = 0; j < str.length; j++) {
				String[] str1 = str[j].split(",");
				int x = Integer.parseInt(str1[0]);
				int y = Integer.parseInt(str1[1]);
				Interval temp = new Interval(x, y);
				input.add(temp);
			}
		}
		List<Interval> output = merge(input);
		String s = "";
		for (Interval i : output) {
			s += i.start + "," + i.end + ";";
		}
		System.out.println(s.substring(0, s.length() - 1));
	}

}
