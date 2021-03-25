package HashMap;
import java.util.HashMap;

// Given an array, find and return the length of longest subarray containing equal number of 0s and 1s.
		
		
public class Longest_Subset_0_1 {
	
	public static int max(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        int max_length = 0;
        int sum = 0;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum == 0){
				max_length = i+1;
            }
             
            if(hashMap.size() > 0 && hashMap.containsKey(sum)){
                   int index = hashMap.get(sum); 
                   int length = i-index; 
                   if(length > max_length){
                       max_length = length;
                   }
                    
            }else{
            hashMap.put(sum,i);
            }
    
	}
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                arr[i] = 0;
            }
        }
        
        return max_length;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 0, 0};
		max(arr);
	}

}
