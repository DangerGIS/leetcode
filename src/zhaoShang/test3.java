package zhaoShang;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 用等差数列求和公式解决
 * 因为是和为n的连续正整数序列
 * 等差数列求和公式可以求到：和为n的连续序列的第一个数，最后一个数，以及数的个数。
 * s=(a1+an)*n/2   2*s=(a1+an)*n   n=an-a1+1
 */
public class test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> result = FindContinuousSequence(n);
		for (ArrayList res : result) {
			System.out.println(res.toString());
		}
	}

	// 求所有和为n的连续正整数序列
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		if (sum <= 2)
			return list;
		else {
			int a1;
			int an;
			int n;
			int num = sum;

			// 第一个数 ，假如第一个数已经到了num的一半 后面的数初始是第一个数加1，加起来和已经超过num
			// 因此第一个数最大不超过num/2 假如num是奇数 如num=15 15/2=7 ，7仍小于num/2 因此要num/2+1
			for (a1 = 1; a1 < num / 2 + 1; a1++) {
				// 第二个数
				for (an = a1 + 1; an < num; an++) {
					if (a1 + an > num)
						break;
					// 两数之间数字的个数
					n = an - a1 + 1;
					// 满足条件
					if ((a1 + an) * n == 2 * num) {
						// ArrayList中存储的是对象的引用，所以每次都需要创建一个新对象，否则值会被覆盖
						ArrayList<Integer> temp = new ArrayList<>();
						// 将满足条件的数打印
						for (int i = a1; i <= an; i++) {
							temp.add(i);
						}
						// 将所有满足条件的组合放入list中
						list.add(temp);

						break;
					}

				}
			}
			return list;
		}

	}

}
