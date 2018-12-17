import java.util.ArrayList;
import java.util.Arrays;

public class HasStatic {
	private static int x = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HasStatic hs1 = new HasStatic();
		hs1.x++;
		HasStatic hs2 = new HasStatic();
		hs2.x++;
		hs1 = new HasStatic();
		hs1.x++;
		HasStatic.x--;
		System.out.println("x=" + x);
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		Arrays.sort(input);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
		return list;
	}

}
