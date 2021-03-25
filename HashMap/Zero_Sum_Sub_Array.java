package HashMap;
import java.util.HashMap;

/*
You are given with an array (of size N) consisting of positive and negative integers that contain numbers in random order.
Write a program to return true if there exists a sub-array whose sum is zero else, return false.
*/


public class Zero_Sum_Sub_Array {
	
	 public static boolean subarraySumTo0(int[] input) {
	        
	        HashMap<Integer, Boolean> sum = new HashMap<Integer, Boolean>();
	        
	        if(input == null || input.length < 1){
	            return false;
	        }
	        

	        int sum_local = 0;
	        sum.put(sum_local, true);
	        for(int i=0; i<input.length; i++){
	        	sum_local += input[i];
	            
	            if(sum.containsKey(sum_local)){
	                return true;
	            }
	            
	            sum.put(sum_local,true);
	        }
	        
	        return false;
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {7, 1, 3, -4, 5, 1};
		System.out.print(subarraySumTo0(arr));

	}

}
