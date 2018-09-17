package HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		char c = '#';
		int flag = 1;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				c = entry.getKey();
		}
		if (c == '#')
			System.out.println("NULL");
		else
			System.out.println(c);
		// ListIterator<Map.Entry<Character, Integer>> i = new
		// ArrayList<Map.Entry<Character,
		// Integer>>(map.entrySet()).listIterator(map.size());
		// while (i.hasPrevious()) {
		// Map.Entry entry = i.previous();
		// // if (entry.getValue() == 1) {
		// //
		// // }
		// if(entry.getValue()==1){
		//
		// }
		// System.out.println("key:" + entry.getKey() + ",value:" +
		// entry.getValue());
		// }

	}

}
