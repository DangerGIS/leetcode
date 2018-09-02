import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			int n = cin.nextInt(), v = cin.nextInt();

			int[] w = new int[n + 1];
			int[] p = new int[n + 1];
			int totalW = 0, totalP = 0;
			for (int i = 1; i <= n; ++i) {
				w[i] = cin.nextInt();
				p[i] = cin.nextInt();
				totalW += w[i];
				totalP += p[i];
			}

			if (totalW <= v) {
				System.out.println(totalP);
				boolean f = true;
				for (int i = 1; i <= n; ++i) {
					if (f) {
						f = false;
					} else {
						System.out.print(" ");
					}
					System.out.print(i);
				}
				System.out.println();
			} else {

				int[][] dp = new int[n + 1][v + 1];
				int[] c = new int[n + 1];
				int ymin = Math.min(w[1] - 1, v);
				for (int j = 1; j <= ymin; ++j) {
					dp[1][j] = 0;
				}
				for (int j = w[1]; j <= v; ++j) {
					dp[1][j] = p[1];
				}

				for (int i = 2; i <= n; ++i) {
					int min = Math.min(w[i] - 1, v);
					for (int j = 1; j <= min; ++j) {
						dp[i][j] = dp[i - 1][j];
					}
					for (int j = w[i]; j <= v; ++j) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
					}
				}

				if (dp[n][v] == 0) {
					System.out.println(0);
					System.out.println("No");
				} else {
					System.out.println(dp[n][v]);
					for (int i = n, j = v; i > 0; --i) {
						if (dp[i][j] == dp[i - 1][j]) {
							c[i] = 0;
						} else {
							c[i] = 1;
							j -= w[i];
						}
					}
					boolean f = true;
					for (int i = 1; i <= n; ++i) {
						if (c[i] == 1) {
							if (f) {
								f = false;
							} else {
								System.out.printf(" ");
							}
							System.out.print(i);
						}
					}
					System.out.println();
				}
			}
		}
		cin.close();
	}

}
