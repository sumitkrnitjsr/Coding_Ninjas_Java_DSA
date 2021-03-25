package Recursion;

// Check whether a given String S is a palindrome using recursion. Return true or false.

public class Check_Palindrome {
	
	 static boolean isStringPalindrome(String input, int startIndex, int endIndex){
	        
	        if(startIndex >= endIndex){
	            return true;
	        }
	        
	        if(input.charAt(startIndex) != input.charAt(endIndex)){
	            return false;
	        }
	        
	        return isStringPalindrome(input, startIndex+1, endIndex-1);
	        
	    }

		public static boolean isStringPalindrome(String input) {
			// Write your code here
			return isStringPalindrome(input,0,input.length()-1);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isStringPalindrome("abba"));

	}

}
