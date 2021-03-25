package Recursion;

// Given a string S, remove consecutive duplicates from it recursively.


public class Remove_String_Duplicates {
	
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here

        if(s.length() < 2){
            return s;
        }
        
        String smallAns = removeConsecutiveDuplicates(s.substring(1));
        
        char current = s.charAt(0);
        
        if(current == smallAns.charAt(0)){
            return smallAns;
        }
        
        return current + smallAns;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaaaaaa";
		System.out.println(removeConsecutiveDuplicates(str));

	}

}
