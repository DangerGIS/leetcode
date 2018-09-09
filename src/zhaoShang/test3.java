package zhaoShang;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * �õȲ�������͹�ʽ���
 * ��Ϊ�Ǻ�Ϊn����������������
 * �Ȳ�������͹�ʽ�����󵽣���Ϊn���������еĵ�һ���������һ�������Լ����ĸ�����
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

	// �����к�Ϊn����������������
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		if (sum <= 2)
			return list;
		else {
			int a1;
			int an;
			int n;
			int num = sum;

			// ��һ���� �������һ�����Ѿ�����num��һ�� ���������ʼ�ǵ�һ������1�����������Ѿ�����num
			// ��˵�һ������󲻳���num/2 ����num������ ��num=15 15/2=7 ��7��С��num/2 ���Ҫnum/2+1
			for (a1 = 1; a1 < num / 2 + 1; a1++) {
				// �ڶ�����
				for (an = a1 + 1; an < num; an++) {
					if (a1 + an > num)
						break;
					// ����֮�����ֵĸ���
					n = an - a1 + 1;
					// ��������
					if ((a1 + an) * n == 2 * num) {
						// ArrayList�д洢���Ƕ�������ã�����ÿ�ζ���Ҫ����һ���¶��󣬷���ֵ�ᱻ����
						ArrayList<Integer> temp = new ArrayList<>();
						// ����������������ӡ
						for (int i = a1; i <= an; i++) {
							temp.add(i);
						}
						// ������������������Ϸ���list��
						list.add(temp);

						break;
					}

				}
			}
			return list;
		}

	}

}
