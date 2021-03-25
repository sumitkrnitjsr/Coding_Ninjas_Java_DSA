package dynamic_programming;
import java.util.Scanner;

public class Num_Codes {

	 public static long numCodes(String number){
	        
	        if(number.length() > 0 && number.charAt(0) == '0'){
	                return 0;
	        }
	        
	        if(number.length() <= 1){
	            return 1;
	        }
	        
	        long total = 0l;
	        
	        int double_digit = Integer.parseInt(number.substring(0,2));
	        
	        long mod = 1000000007;
	        
	        if(double_digit < 27){
	            String sub = "";
	            if(number.length() > 2){
	                sub = number.substring(2);
	            }
	            long value = numCodes(sub);
	            value = value%mod;
	            total = total + value;
	            total = total%mod;
	        }
	        
	        long value = numCodes(number.substring(1));
	        value = value%mod;
	        total = total + value;
	        total = total%mod;
	        
	        return total;

	    }
	    
	    
	    public static long numCodesDP(String number){
	        
	        long[] storage = new long[number.length() + 1];
	        
	        storage[0] = 1;
	        storage[1] = 1;
	        
	        long mod = 1000000007;
	        
	        if(number.charAt(0) == '0'){
	            return 0;
	        }
	        
	        for(int i = 2; i <= number.length(); i++){
	            
	            int double_digit = Integer.parseInt(number.substring(i-2,i));
	            
	            if(number.charAt(i - 1) > '0'){ // Forgot to propagate wrong beginings of digit
	            storage[i] = storage[i-1];
	            }
	            
	            if(number.charAt(i - 2) > '0' && double_digit < 27){
	             storage[i] = (storage[i]  + storage[i-2])%mod;
	            }
	            
	        }
	        
	        return storage[number.length()];
	        
	    }
	    
		
		public static void main(String[] args) {
			// Write your code here
	        
	        Scanner sc = new Scanner(System.in);
	        String num = "";
	        while(true){
	            num = sc.nextLine();
	            if( num.length() == 1 && num.charAt(0)  == '0'){
	                	break;
	            }
	            
	            System.out.println(numCodesDP(num));
	     
	        }

		}

}
