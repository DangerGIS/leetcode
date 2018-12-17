package nowCoder.Class3;

public class Problem04_RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);
	}

	public static void rotate(int[][] matrix) {
		int aR = 0;
		int aC = 0;
		int bR = matrix.length - 1;
		int bC = matrix[0].length - 1;
		while (aR < bR) {
			rotateEdge(matrix, aR++, aC++, bR--, bC--);
		}
	}

	public static void rotateEdge(int[][] m, int aR, int aC, int bR, int bC) {
		int tims = bC - aC;
		int tmp;
		for (int i = 0; i != tims; i++) {
			tmp = m[aR][aC + i];
			m[aR][aC + i] = m[bR - i][aC];
			m[bR - i][aC] = m[bR][bC - i];
			m[bR][bC - i] = m[aR + i][bC];
			m[aR + i][bC] = tmp;
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
