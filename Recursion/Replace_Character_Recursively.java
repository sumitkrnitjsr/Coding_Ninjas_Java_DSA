package Recursion;

// Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.

public class Replace_Character_Recursively {
	
	

	public static String replaceCharacter(String input, char c1, char c2) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
        
        if(input.length() < 1){
            return "";
        }
        
        char c = input.charAt(0);
        String ans = "";
        if(c == c1){
            ans = ans + c2;
        }else{
            ans = ans + c;
        }
        
        String smallAns = replaceCharacter(input.substring(1),c1,c2);
        
        return ans + smallAns;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "bacdefdjdklsldjd";
		String str1 = "d";
		System.out.println(replaceCharacter(str1,'d','z'));

	}

}
