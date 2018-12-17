package nowCoder.Class3;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Problem07_TopKTimes {
	static class Node implements Comparable<Node> {
		public String str;
		public int times;

		public Node(String str, int times) {
			this.str = str;
			this.times = times;
		}

		@Override
		public int compareTo(Node node) {
			// return times - node.times;
			return node.times - times;
		}
	}

	public static void main(String[] args) {
		String[] arr1 = { "A", "B", "A", "C", "A", "C", "B", "B", "K", "B" };
		printTopKAndRank(arr1, 2);

	}

	public static void printTopKAndRank(String[] arr, int topK) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 0);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		topK = Math.min(arr.length, topK);
		PriorityQueue<Node> heap = new PriorityQueue<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			Node node = new Node(entry.getKey(), entry.getValue());
			if (heap.size() < topK) {
				heap.add(node);
			} else if (heap.peek().times < node.times) {
				heap.poll();
				heap.add(node);
			}
			// heap.add(node);
		}
		while (!heap.isEmpty()) {
			System.out.println(heap.poll().str);
		}
	}

}
