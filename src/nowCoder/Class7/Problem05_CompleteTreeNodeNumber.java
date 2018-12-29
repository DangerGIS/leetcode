package nowCoder.Class7;

public class Problem05_CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}

	//
	public static int bs(Node node, int left, int h) {
		if (h == left) {
			return 1;
		}
		if (mostLeftLevel(node.right, left + 1) == h) {// 如果右子树的左边界到达最后一层
			return (1 << (h - left)) + bs(node.right, left + 1, h);// 2^(h-left)+?
		} else {
			return (1 << (h - left - 1)) + bs(node.left, left + 1, h);
		}
	}

	// 如果node在level层，求node节点的左子树最深到达的层数(高度)
	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}
}
