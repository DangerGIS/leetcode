package mi;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int res;

		int _array_size = 0;
		_array_size = Integer.parseInt(in.nextLine().trim());
		int[] _array = new int[_array_size];
		int _array_item;
		for (int _array_i = 0; _array_i < _array_size; _array_i++) {
			_array_item = Integer.parseInt(in.nextLine().trim());
			_array[_array_i] = _array_item;
		}

		int _m;
		_m = Integer.parseInt(in.nextLine().trim());

		res = findMaxCapacity(_array, _m);
		System.out.println(String.valueOf(res));
	}

	static int findMaxCapacity(int[] array, int m) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			int[] copyarray = new int[array.length];
			System.arraycopy(array, 0, copyarray, 0, 3);
			copyarray[i] = copyarray[i] + 2;
			if (trap(copyarray) > max) {
				max = trap(copyarray);
			}
		}
		return max;
	}

	public static int trap(int[] height) {
		int left = 0, right = height.length - 1;
		int res = 0, maxleft = 0, maxright = 0;
		while (left <= right) {
			if (height[left] <= height[right]) {
				if (height[left] >= maxleft) {
					maxleft = height[left];
				} else {
					res += maxleft - height[left];
				}
				left++;
			} else {
				if (height[right] >= maxright) {
					maxright = height[right];
				} else {
					res += maxright - height[right];
				}
				right--;
			}
		}
		return res;
	}

}
