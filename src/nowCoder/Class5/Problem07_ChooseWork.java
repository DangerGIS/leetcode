package nowCoder.Class5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Problem07_ChooseWork {
	public static class Job {
		public int money;
		public int hard;

		public Job(int money, int hard) {
			this.money = money;
			this.hard = hard;
		}
	}

	public static class JobComparator implements Comparator<Job> {
		@Override
		public int compare(Job o1, Job o2) {
			// 难度由低到高排序，相同难度时，报酬由高到低排序
			return o1.hard != o2.hard ? o1.hard - o2.hard : o2.money - o1.money;
		}
	}

	public static int[] getMoneys(Job[] job, int[] ability) {
		// 先排序
		Arrays.sort(job, new JobComparator());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(job[0].hard, job[0].money);
		Job pre = job[0];
		for (int i = 1; i < job.length; i++) {
			// 相同难度时，保留报酬最高的
			// 难度变高时，保留报酬变高的
			if (job[i].hard != pre.hard && job[i].money > pre.money) {
				pre = job[i];
				map.put(job[i].hard, job[i].money);
			}
		}
		int[] res = new int[ability.length];
		for (int i = 0; i < ability.length; i++) {
			res[i] = map.floorKey(ability[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Integer key = map.ceilingKey(5);
		int test1 = key != null ? map.get(key) : 0;
		System.out.println(test1);
	}

}
