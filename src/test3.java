import java.util.Arrays;
import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] array = new int[len];
		int[] copy = new int[len];
		for (int i = 0; i < len; i++) {
			array[i] = sc.nextInt();
			copy[i] = array[i];
		}
		Arrays.sort(copy);
		int left = 0, right = len - 1;
		while (left < len && copy[left] == array[left])
			left++;
		while (right >= 0 && copy[right] == array[right])
			right--;

		int i;
		for (i = 0; i <= right - left; i++) {
			if (copy[left + i] != array[right - i]) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");

	}
}
