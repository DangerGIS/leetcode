package nowCoder.Class1;

public class Problem04_MaxOneBorderSize {

	public static void main(String[] args) {
		int[][] matrix = generate01Matrix(7, 8);
		printMatrix(matrix);
		System.out.println(maxMatrix(matrix));

	}

	public static int[][] generate01Matrix(int rowSize, int colSize) {
		int[][] res = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				res[i][j] = (int) (Math.random() * 2);
			}
		}
		return res;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 预处理得到辅助矩阵
	public static void setBorderMap(int[][] matrix, int[][] right, int[][] down) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (matrix[row - 1][col - 1] == 1) {
			right[row - 1][col - 1] = 1;
			down[row - 1][col - 1] = 1;
		}
		for (int i = row - 2; i >= 0; i--) {// 两个辅助矩阵的最后一列赋值
			if (matrix[i][col - 1] == 1) {
				right[i][col - 1] = 1;
				down[i][col - 1] = down[i + 1][col - 1] + 1;
			}
		}

		for (int i = col - 2; i >= 0; i--) {// 两个辅助矩阵的最后一行赋值
			if (matrix[row - 1][i] == 1) {
				down[row - 1][i] = 1;
				right[row - 1][i] = right[row - 1][i + 1] + 1;
			}
		}
		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					right[i][j] = right[i][j + 1] + 1;
					down[i][j] = down[i + 1][j] + 1;
				}
			}
		}
	}

	// 求最大正方形
	public static int maxMatrix(int[][] matrix) {
		int[][] right = new int[matrix.length][matrix[0].length];
		int[][] down = new int[matrix.length][matrix[0].length];
		setBorderMap(matrix, right, down);
		// 从大到小去试每一种边长的可能，有的话就返回
		for (int size = Math.min(matrix.length, matrix[0].length); size != 0; size--) {
			if (hasOfBoder(size, right, down)) {
				return size;
			}
		}
		return 0;
	}

	public static boolean hasOfBoder(int size, int[][] right, int[][] down) {
		for (int i = 0; i != right.length - size + 1; i++) {
			for (int j = 0; j != right[0].length - size + 1; j++) {// 左上角的点
				if (right[i][j] >= size && down[i][j] >= size && right[i + size - 1][j] >= size
						&& down[i][j + size - 1] >= size) {
					return true;
				}
			}
		}
		return false;
	}
}
