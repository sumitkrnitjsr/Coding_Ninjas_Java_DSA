package dynamic_programming;

// Given an array with N elements, you need to find the length of the longest subsequence in the given array such that all elements of the subsequence are sorted in strictly increasing order.


public class Longest_Increasing_Subsequence {
	
	 public static int lis(int arr[]) {
	        
	        if(arr.length < 2){
	            return 1;
	        }
	        
	        int[] storage = new int[arr.length];
	        
	        storage[0] = 1;
	        storage[1] = 1;
	        
	        if(arr[1] > arr[0]){
	            storage[1] = 2;
	        }
	        
	        int max = 1;
	        
	        for(int i = 2;i < arr.length; i++){
	            storage[i] = 1;
	            for(int j = i-1;j >= 0;j--) {
	                if(arr[j] < arr[i]){
	                    if(storage[j] >= storage[i] ){
	                        storage[i] = storage[j] + 1;
	                        max = (storage[i] > max)?storage[i]:max;
	                    }
	                }
	            }
	        }
	        
	        return max;

	    }
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
