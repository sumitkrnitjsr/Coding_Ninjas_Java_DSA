package Recursion;

// Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.

public class String_To_Integer {
	
	
	 static int convertStringToInt(String input, int number){
		    
	        if(input.length() < 1){
	            return number;
	        }
	        char digit = input.charAt(0);
	        number = (number*10) + (digit - '0'); // Wrote ('0' - digit ) instead of (digit - '0')
	        return convertStringToInt(input.substring(1),number);
	    }
	    
	    
		public static int convertStringToInt(String input){
			// Write your code here
			boolean  negative  = (input.contains("-"))?true:false;
			if(!negative) {
	        return convertStringToInt(input,0);
			}
			
			return (-1 * convertStringToInt(input.substring(1)));
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(convertStringToInt("-45"));

	}

}
