package Test;

/*
Given two strings string1 and string2 (named large and small), find the smallest substring in string1 containing all characters of string2 in O(n). You need to return the output substring.
Note : The characters of string2 need not to be present in same order in string1. That is, we need a substring which contains all characters of string2 irrespective of the order.
Return null if no substring with all characters is present.
*/

public class Smallest_Sub_String {
	
	 public static String findMinSubstringContainingString(String large, String small){
	        /* Your class should be named solution
	         * Don't write main().
	         * Don't read input, it is passed as function argument.
	         * Return output and don't print it.
	         * Taking input and printing output is handled automatically.
	         */
		 
	        int len1 = large.length();
	        int len2 = small.length();
	        
	        if(len1 < len2){
	            return null;
	        }
	        
	        int small_pattern[] = new int[256];
	        int large_string[] = new int[256];
	        
	        
	        // record characters in small string to be matched with large string
	        for(int i=0; i<len2; i++){
	            small_pattern[small.charAt(i)]++;
	        }
	        
	        
	        
	        int start = 0;
	        int start_index = -1;
	        int min_len = Integer.MAX_VALUE;
	        int count = 0;
	        
	        // traverse each character to find out the length sequentially
	        
	        for(int j=0; j< len1; j++){
	            
	        	// track the latest character
	            large_string[large.charAt(j)]++;
	            
	            // latest character in large matches with small and within the limit of small string requirement
	            if(small_pattern[large.charAt(j)] != 0 && large_string[large.charAt(j)] <= small_pattern[large.charAt(j)]){
	                count++;
	            }
	            
	            // count of large characters matching the small is equal
	            if(count == len2){
	                
	            	// begining of window to be adjusted to most relevant length by removing unnecessary characters at the beginning
	            	// check non relevant characters in long string a) more than current requirement || not required
	    while((large_string[large.charAt(start)] > small_pattern[large.charAt(start)]) || small_pattern[large.charAt(start)] == 0){
	                    
	    				
	    				// If more than current requirement, then adjust the occurrence data
	                    if(large_string[large.charAt(start)] > small_pattern[large.charAt(start)]){
	                        large_string[large.charAt(start)]--;
	                    }
	                    
	                    //increment beginning of new window by removing non important characters
	                    start++;
	                    
	                }
	                
	                int length = j-start+1;
	                
	                // update start index
	                if(min_len > length){
	                    min_len = length;
	                    start_index = start;
	                }
	                
	                
	            }

	            
	        }
	        
	        
	        if(start_index == -1){
	            return null;
	        }
	        
	        return large.substring(start_index,start_index + min_len);
	        
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
