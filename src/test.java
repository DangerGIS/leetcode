import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
	static int m, n;
	static int[][] book = new int[1000][1000];
	static int[][] a = new int[1000][1000];
	static int num = 0;// �����
	// static int count;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] nums = s.split(",");
		m = Integer.parseInt(nums[0]);
		n = Integer.parseInt(nums[1]);
		a = new int[m][n];
		book = new int[m][n];
		for (int i = 0; i < m; i++) {
			String s1 = sc.next();
			String[] nums1 = s1.split(",");
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(nums1[j]);
			}
		}
		// ��ÿһ������1��Ⱦɫ
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					num--;
					book[i][j] = 1;

					dfs(i, j, num, 1);
				}
			}
		}
		int max = 0;
		// for (int i = 0; i < sum.length; i++) {
		// if (max < sum[i])
		// max = sum[i];
		// }
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.format("%3d", a[i][j]);
			}
			System.out.println();
		}
		System.out.format("%d,%d", -num, max);
		System.out.println(list.toString());
	}

	public static void dfs(int x, int y, int color, int count) {
		// ���巽������
		// ��������
		int[][] next = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int tx, ty;
		a[x][y] = color;

		for (int k = 0; k <= 3; k++) {
			// ��һ������
			tx = x + next[k][0];
			ty = y + next[k][1];
			// �Ƿ�Խ��
			if (tx < 0 || tx > m - 1 || ty < 0 || ty > n - 1) {
				continue;
			}
			// �ж��Ƿ�������
			if (a[tx][ty] == 1 && book[tx][ty] == 0) {

				book[tx][ty] = 1;
				dfs(tx, ty, color, count + 1);

			}
		}

		System.out.format("%d %d", color, count);
		System.out.println();
		list.add(count);

		return;
	}

}
