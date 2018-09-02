package byteDance2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<Integer, List<Integer>> map = new HashMap();

		for (int i = 1; i <= n; i++) {
			String[] str = sc.nextLine().split(" ");
			List<Integer> myList = new ArrayList<Integer>();
			for (int j = 0; j < str.length; j++) {
				String[] str1 = str[j].split(" ");
				for (int k = 0; k < str1.length; k++) {
					myList.add(Integer.parseInt(str1[k]));
				}

			}
			map.put(i, new ArrayList<Integer>(myList));
		}
		int m = 1;

		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (map.get(j).contains(i)) {
					count++;
					break;
				}

			}

			if (count == 0)
				m++;
			if (map.get(i).size() == 1)
				m--;

		}
		System.out.format("%d", m);
	}

}
