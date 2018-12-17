package guangLD;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String fun(String str) {
		String[] arr = str.split("D");
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].length() > max)
				max = arr[i].length();
		}
		String res = "";
		switch (max) {
		case 0:
		case 1:
		case 2:
			res = "a Foolish Man";
			break;
		case 3:
			res = "on a Killing Spree";
			break;
		case 4:
			res = "on a Killing Spree";
			break;
		case 5:
			res = "a Mega-Kill";
			break;
		case 6:
			res = "Unstoppable";
			break;
		case 7:
			res = "Wicked Sick";
			break;
		case 8:
			res = "a M-m-m-m....Monster Kill";
			break;
		case 9:
			res = "Godlike";
			break;
		default:
			res = "Beyond Godlike";
			break;
		}
		return res;
	}

}
