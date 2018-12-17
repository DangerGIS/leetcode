package nowCoder.Class1.Test;

import java.util.Scanner;

public class Problem02_MinCutArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int minX = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxY = Integer.MIN_VALUE;
			int n = Integer.parseInt(sc.nextLine());
			// int n = sc.nextInt();
			String[] s;

			for (int i = 0; i < n; i++) {
				s = sc.nextLine().split(" ");
				int curX = Integer.parseInt(s[0]);
				int curY = Integer.parseInt(s[1]);
				if (minX > curX)
					minX = curX;
				if (maxX < curX)
					maxX = curX;
				if (minY > curY)
					minY = curY;
				if (maxY < curY)
					maxY = curY;
			}
			int w = maxX - minX;
			int h = maxY - minY;

			long area = w > h ? (w * w) : (h * h);
			System.out.println(area);
		}
	}

}
