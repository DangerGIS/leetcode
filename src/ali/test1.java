package ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		List<List<Integer>> list=subsetsWithDup(a);
		int count=0;
		int flag1=1;//判断从小到大排列
		int flag2=1;//标识等比或等差
		for(List li:list){
			
        	if(li.size()>=3){
        		System.out.println(li.toString());
        		//判断是否从小到大排列
        		for(int i=0;i<li.size()-1;i++){
        			if(a[i+1]<a[i]){
        				flag1=0;
        				continue;
        			}
        				
        		}
        		
        		if(flag1==1){
        			//判断等比
            		flag2=1;
            		for(int i=0;i<=li.size()-3;i++){
            			if((int)li.get(i+1)/(int)li.get(i)!=(int)li.get(i+2)/(int)li.get(i+1)){
            				
            				flag2=0;
            				continue;
            			}
            		}
            		
            		//判断等差
            		flag2=1;
            		for(int i=0;i<=li.size()-3;i++){
            			if((int)li.get(i+1)-(int)li.get(i)!=(int)li.get(i+2)-(int)li.get(i+1)){
            				
            				flag2=0;
            				continue;
            			}
            		}
        		}
        		
        		
        		if(flag2==1){
        			System.out.println("ok");
    				System.out.println(li.toString());
        			count++;
        		}
        		continue;
        	}
        	
        	
        }
		System.out.println(count);
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
