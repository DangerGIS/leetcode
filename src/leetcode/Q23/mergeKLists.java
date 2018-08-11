package leetcode.Q23;

public class mergeKLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		// 分而治之的思想 两两合并

		int n = lists.length;

		while (n > 1) {
			int k = (n + 1) / 2;
			for (int i = 0; i < n / 2; i++) {
				lists[i] = mergeTwoList(lists[i], lists[i + k]);
			}
			n = k;
		}
		return lists[0];

	}

	public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null)
			cur.next = l1;
		if (l2 != null)
			cur.next = l2;
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
