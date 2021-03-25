package Recursion;

public class Remove_X_Character_String {
	
	
	public static String removeX(String str) {
		
		if(str.length() == 0) {
			return "";
		}
		
		String ans = "";
		if(str.charAt(0) != 'x') {
			ans = ans + str.charAt(0);
		}
		
		String smallAns = removeX(str.substring(1));
		
		return ans + smallAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "axdxxxx";
		System.out.println(removeX(str));

	}

}
