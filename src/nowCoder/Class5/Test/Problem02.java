package nowCoder.Class5.Test;

import java.util.Scanner;

public class Problem02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] moneny = { 1, 5, 10, 20, 50, 100 };
			long[] dp = new long[n + 1];
			dp[0] = 1;
			for (int i = 0; i < moneny.length; i++) {
				for (int j = moneny[i]; j <= n; j++) {
					dp[j] = dp[j] + dp[j - moneny[i]];// j值取和不取两种情况组合数目之和
				}
			}
			System.out.println(dp[n]);

		}
	}

}
