package ali;

import java.util.Scanner;

/**
 */
public class Main {

	private static final int MAX_PATH_LENGTH = 65535;

	public static void main(String[] args) {
		// ����
		Scanner scanner = new Scanner(System.in);

		int startX = scanner.nextInt();
		int startY = scanner.nextInt();
		Direction startDirection = Direction.valueOf(scanner.next());

		int endX = scanner.nextInt();
		int endY = scanner.nextInt();
		Direction endDirection = Direction.valueOf(scanner.next());

		int row = scanner.nextInt();
		int column = scanner.nextInt();
		int[][] map = new int[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		// ʵ�ִ˺������� ��ȫ�����Լ��뷨���к�����д
		int pathLength = cal(map, startDirection, startX, startY, endDirection, endX, endY, column);
		// ���
		System.out.print(pathLength);
	}

	private static int cal(int[][] map, Direction startDirection, int startX, int startY, Direction endDirection,
			int endX, int endY, int column) {
		return 0;
	}

	public enum Direction {

		EAST(0), WEST(1), SOUTH(2), NORTH(3), UNKNOWN(4);

		int index;

		public int getIndex() {
			return index;
		}

		Direction(int index) {
			this.index = index;
		}

		static Direction getDirectionByIndex(int index) {
			for (Direction direction : Direction.values()) {
				if (direction.index == index) {
					return direction;
				}
			}
			return UNKNOWN;
		}

	}
}