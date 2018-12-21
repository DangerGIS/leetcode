package nowCoder_model;

public class Main {
	// 生成随机数组
	// 对数器
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static int[] generateRandomArray() {
		int[] arr = new int[(int) (Math.random() * 98) + 2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 200) + 2;
		}
		return arr;
	}
}
