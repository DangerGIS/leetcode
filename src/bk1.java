import java.util.*;
public class bk1 {
    static int n;//要变换的数
    static int m;//要变换成的数
    static int k;//变换的次数
    static boolean found;//查找结果
    static int result[] = new int[100];//最多变换100次

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 0; i<99; i++){
            result[i] = 0;
        }
        System.out.println(n + " " + m);
        compute();
        if(found)
            System.out.println(k);
        else
            System.out.println();
    }

    static void compute(){
        k = 1;
        found = false;
        while (!search(1, n)){
            k++;
            if (k > 100)
                break;
            if (found)
                break;
        }
    }

    static boolean search(int dep, int n){
        if (dep>k){
            return false;
        }
        for (int i = 0; i<2; i++){
            int num = n;
            num = fun(num, i);
            result[dep] = i;
            if (num == m || search(dep + 1, num)){
                found = true;
                return true;
            }
        }
        return false;
    }

    static int fun(int n, int i){
        if (i == 0)
            return n * 2;
        else
            return n - 1;
    }
}
