package ali;

public class aaa {
	// ÌøÌ¨½×
	public static int JumpFloorII(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else {
			return 2 * JumpFloorII(target - 1);
		}
	}

	public static void main(String[] args) {
		int n = JumpFloorII(9);
		System.out.println(n);
	}
}
