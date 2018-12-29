package nowCoder.Class5.Test;

import java.util.Scanner;

public class Problem03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			double n = sc.nextDouble();
			int m = sc.nextInt();
			double sum = 0f;
			for (int i = 0; i < m; i++) {
				sum += n;
				n = Math.sqrt(n);
			}
			System.out.println(String.format("%.2f", sum));
		}
	}
}
