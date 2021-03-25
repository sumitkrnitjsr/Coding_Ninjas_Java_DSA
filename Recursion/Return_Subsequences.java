package Recursion;

public class Return_Subsequences {
	
	static String[] subsequences(String str) {
		
		if(str.length() < 1) {
			String[] result = {""};
			return result;
		}
		
		String[] smallAns = subsequences(str.substring(1));
		String[] result = new String[2 * smallAns.length];
		int k = 0;
		for(int i = 0; i < smallAns.length; i++,k++) {
			result[k] = smallAns[i];
		}
		
		for(int i = 0; i < smallAns.length; i++,k++) {
			result[k] = str.charAt(0) + smallAns[i];
			
		}
		
		return result;
	}
	
	static void printSubsequences(String str) {
		
		printSubsequence_Top_To_Bottom_Recursion(str, "");
	}
	
	static void printSubsequence_Top_To_Bottom_Recursion(String input, String result) {
		
		if(input.length() == 0) {
			System.out.println(result);
			return;  // Forgot return statement
		}
		
		printSubsequence_Top_To_Bottom_Recursion(input.substring(1),result);
		
		printSubsequence_Top_To_Bottom_Recursion(input.substring(1),result + input.charAt(0) );
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] result = subsequences("xyz");
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		printSubsequences("xyz");
		
	}

}
