package MT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//        String[] str = sc.nextLine().split(" ");
//        int n,k,t;
//        n = Integer.parseInt(str[0]);
//        k = Integer.parseInt(str[1]);
//        t=Integer.parseInt(str[2]);
//        int[] a=new int[n+1];
//        String[] str1 = sc.nextLine().split(" ");
//        for(int i=1;i<=n;i++){
//        	a[i]=Integer.parseInt(str[i-1]);
//        }
        int[] b=new int[]{3,1,1,1,2};
        int result=0;
        List<List<Integer>> res=subsetsWithDup(b);
        for(List list:res){
        	if(list.size()==3){
        		System.out.println(list.toString());
        		if(count(list,2)==true){
        			result++;
        		}
        	}
        	
        	
        }
        System.out.println(result);
	}
	public static Boolean count(List<Integer> num,int t){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0 ; i<num.size();i++){
		int temp = num.get(i);
		Integer count = map.get(temp);
		
		if(null == count){
		map.put(temp, 1);
		}else{
		map.put(temp, map.get(temp)+1);
		if(map.get(temp)>=2){
			return true;
		}
		}
		}
		return false;
		
	}
	public static List<List<Integer>> subsetsWithDup(int[] num) {
	    //Arrays.sort(num);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		
		
	    
	    int len = num.length;
	    if (len == 0) return ans; 
	    
	    ans.add(new ArrayList<Integer>()); // first, need to add the subset of num[0]
	    ans.add(new ArrayList<Integer>());
	    ans.get(1).add(num[0]);
	    
	    int nprev = 1; // this is the number of lists that the previous number was added in.
	                 // if the current number is same as the prev one, it'll be only added in the 
	                // lists that has the prev number.
	                
	    for (int i = 1; i < len ; ++i){
	        int size = ans.size();
	        if (num[i]!=num[i-1])   // if different
	            nprev = size;        // this means add num[i] to all lists in ans;
	        for (int j = size-nprev; j < size; ++j){
	            List<Integer> l = new ArrayList<Integer>(ans.get(j));
	            l.add(num[i]);
	            ans.add(l);
	        }
	    }
	    return ans;
	}

}
