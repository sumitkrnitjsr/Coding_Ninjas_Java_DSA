package Two_Dimesional_Arrays;

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
	        
	        int pattern[] = new int[256];
	        int string[] = new int[256];
	        
	        
	        for(int i=0; i<len2; i++){
	            pattern[small.charAt(i)]++;
	        }
	        
	        int start = 0;
	        int start_index = -1;
	        int min_len = Integer.MAX_VALUE;
	        int count = 0;
	        
	        for(int j=0; j< len1; j++){
	            
	            string[large.charAt(j)]++;
	            
	            if(pattern[large.charAt(j)] != 0 && string[large.charAt(j)] <= pattern[large.charAt(j)]){
	                count++;
	            }
	            
	            if(count == len2){
	                
	                
	    while((string[large.charAt(start)] > pattern[large.charAt(start)]) || pattern[large.charAt(start)] == 0){
	                    
	                    if(string[large.charAt(start)] > pattern[large.charAt(start)]){
	                        string[large.charAt(start)]--;
	                    }
	                    
	                    start++;
	                    
	                }
	                
	                int length = j-start+1;
	                
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
