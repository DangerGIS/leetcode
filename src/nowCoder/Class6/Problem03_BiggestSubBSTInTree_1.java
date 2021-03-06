package nowCoder.Class6;

public class Problem03_BiggestSubBSTInTree_1 {
	// 求最大搜索二叉树的头节点
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static class returnType {
		public Node maxBSTNode;
		public int maxBSTSize;
		public int max;
		public int min;

		public returnType(Node maxBSTNode, int maxBSTSize, int min, int max) {
			this.maxBSTNode = maxBSTNode;
			this.maxBSTSize = maxBSTSize;
			this.min = min;
			this.max = max;

		}
	}

	public static returnType process(Node x) {
		// base case : 如果子树是空树
		// 最小值为系统最大
		// 最大值为系统最小
		if (x == null) {
			return new returnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		// 默认直接得到左树全部信息
		returnType lData = process(x.left);
		// 默认直接得到右树全部信息
		returnType rData = process(x.right);
		// 以下过程为信息整合
		// 同时以X为头的子树也做同样的要求，也需要返回如ReturnType描述的全部信息
		// 以X为头的子树的最大值是：左树最大、右树最大、X的值，三者中最大的
		int max = Math.max(x.value, Math.max(lData.max, rData.max));
		// 以X为头的子树的最小值是：左树最小、右树最小、X的值，三者中最小的
		int min = Math.min(x.value, Math.min(lData.min, rData.min));

		int p1 = lData.max;
		int p2 = rData.max;
		// 当前节点的左子树是左边信息中的最大二叉搜索子树

		int p3 = (lData.maxBSTNode == x.left && rData.maxBSTNode == x.right && x.value > lData.max
				&& x.value < rData.min) ? lData.maxBSTSize + rData.maxBSTSize + 1 : 0;

		Node maxBSTNode = null;
		int maxBSTSize = 0;
		if (p3 != 0) {
			maxBSTNode = x;
			maxBSTSize = p3;
		} else {
			maxBSTNode = p1 >= p2 ? lData.maxBSTNode : rData.maxBSTNode;
			maxBSTSize = Math.max(p1, p2);
		}
		return new returnType(maxBSTNode, maxBSTSize, max, min);
	}

	public static Node getMaxBST(Node head) {
		return process(head).maxBSTNode;
	}

	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {

		Node head = new Node(6);
		head.left = new Node(1);
		head.left.left = new Node(0);
		head.left.right = new Node(3);
		head.right = new Node(12);
		head.right.left = new Node(10);
		head.right.left.left = new Node(4);
		head.right.left.left.left = new Node(2);
		head.right.left.left.right = new Node(5);
		head.right.left.right = new Node(14);
		head.right.left.right.left = new Node(11);
		head.right.left.right.right = new Node(15);
		head.right.right = new Node(13);
		head.right.right.left = new Node(20);
		head.right.right.right = new Node(16);

		printTree(head);
		Node bst = getMaxBST(head);
		printTree(bst);

	}

}
