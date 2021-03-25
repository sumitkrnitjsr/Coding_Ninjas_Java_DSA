package String;

public class Palindrome {
	
	
	public static boolean checkPalindrome(String str){
		
        if(str == null){
            return true;
        }
        
		int right = 0;
		int left = str.length() - 1;
		
		while(right < left) {
			char r = str.charAt(right);
			char l = str.charAt(left);
			
			if(r != l) {
				return false;
			}
			
			right++;
			left--;
		}
		
		return true;

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcdcba";
		
		String p = "abccba";
		
		String err = "abcb";
		
		System.out.println(checkPalindrome(s));
		
		System.out.println(checkPalindrome(p));
		
		System.out.println(checkPalindrome(err));
		
	}

}
