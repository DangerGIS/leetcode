package didi;

import java.util.Scanner;

public class Main1 {
	/*
	 * ������������������ʵ����ĿҪ��Ĺ��� ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ ��ʼд����
	 ******************************/
	static int find_cheapest_path(int n, int m, int[][] flights) {
		return 0;
	}

	/****************************** ����д���� ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		int _m;
		_m = Integer.parseInt(in.nextLine().trim());

		int _flights_rows = 0;
		int _flights_cols = 0;
		_flights_rows = Integer.parseInt(in.nextLine().trim());
		_flights_cols = Integer.parseInt(in.nextLine().trim());

		int[][] _flights = new int[_flights_rows][_flights_cols];
		for (int _flights_i = 0; _flights_i < _flights_rows; _flights_i++) {
			for (int _flights_j = 0; _flights_j < _flights_cols; _flights_j++) {
				_flights[_flights_i][_flights_j] = in.nextInt();

			}
		}

		if (in.hasNextLine()) {
			in.nextLine();
		}

		res = find_cheapest_path(_n, _m, _flights);
		System.out.println(String.valueOf(res));

	}
}
