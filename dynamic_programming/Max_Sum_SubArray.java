package dynamic_programming;


// Given an integer array containing both negative and positive integers. Find and return the sum of contiguous sub-array with maximum sum.


public class Max_Sum_SubArray {
	
	public static int findSum(int arr[],int n){
		
	    int max_sum = arr[0];
	    
	    int current_sum = (arr[0]>0)?arr[0]:0;
	    
	    for(int i = 1;i < arr.length;i++){
	        
	        int with_sum = current_sum + arr[i];
	        int without_sum = arr[i];
	        
	        if(with_sum > 0){
	            current_sum = with_sum;
	            max_sum = (max_sum > current_sum)?max_sum:current_sum;
	        }else{
	            max_sum = (max_sum > without_sum)?max_sum:without_sum;
	            current_sum = 0;
	        }
	        
	    }
	    
	    return max_sum;
	    
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
