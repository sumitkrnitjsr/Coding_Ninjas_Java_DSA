package Recursion;

// Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".

public class Replace_Pi {
	
	public static String replace(String input){
		// Write your code here
        if(input.length() < 2){
            return input;
        }
        
        String substr = input.substring(0,2);
        String smallAns = "";
        if(substr.equals("pi")){
            smallAns = "3.14";
            return smallAns + replace(input.substring(2));
        }
        
        return input.charAt(0) + replace(input.substring(1));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(replace("xxxpixpipipi"));

	}

}
