package Recursion;


// Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to return the list of all possible codes that can be generated from the given string.

public class Return_All_Codes {
	
	 static String[] getCode(String input, String result){
	        
	        if(input.length() < 1){
	            String[] ans = new String[1];
	            ans[0] = "";
	            return ans;
	        }
	        

	        int value = Integer.parseInt(input.substring(0,1));
	        value = 'a' + value - 1;
	        char first_c = (char)value;
	        String[] result_f = getCode(input.substring(1), first_c + result);
	        
	        for(int i = 0; i < result_f.length; i ++){
	            result_f[i] = first_c + result_f[i];
	        }
	        
	        if(input.length() > 1){
	            
	        value = Integer.parseInt(input.substring(0,2));
	        if(value <= 26){  
	        // Forgot to add alphabet test case limit
	        value = 'a' + value - 1;
	        char second_c = (char)value;
	            
	        String[] result_s = getCode(input.substring(2), second_c + result);
	        for(int i = 0; i < result_s.length; i ++){
	            result_s[i] = second_c + result_s[i];
	        } 
	            
	         String[] final_result = new String[result_f.length + result_s.length];
	         int k = 0;
	         for(int i = 0; i < result_f.length; i++,k++ ){
	         final_result[k] = result_f[i];
	         }
	        for(int i = 0; i < result_s.length; i++,k++ ){
	         final_result[k] = result_s[i] ;
	         } 
	            
	        return final_result;
	        }
	        }
	        
	        return result_f;
	        
	    }
	    
	    
	    // Return a string array that contains all possible codes
		public static  String[] getCode(String input){
			// Write your code here
			return getCode(input, "");
		}
		
		 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int value = Integer.parseInt("11");
        value = 'a' + value - 1;
        char first_c = (char)value;
		System.out.println(first_c);

	}

}
