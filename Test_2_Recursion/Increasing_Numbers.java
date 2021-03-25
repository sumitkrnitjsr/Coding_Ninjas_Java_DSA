package Test_2_Recursion;

/*
Given an integer n, print all n digit increasing numbers in increasing order in one line.
Numbers you need to print should be in increasing order and only those numbers should be printed which have digits in increasing order.
*/

public class Increasing_Numbers {
	
	 static void printIncreasingNumber(int n, String output){
		    
	        if(n == 0){
	            System.out.print(output + " ");
	            return;
	        }
	        
	        int start = (output.length() > 0)?0:1;
	        String c = "0";
	        int value = 0;
	        if(output.length() > 0){
	         int pos = output.length() - 1;
	         c = Character.toString(output.charAt(pos)); // c = Character.toString(output.charAt(0)); put wrong index, not always zero, should be the last digit
	         value = Integer.parseInt(c);
	        }
	        for(; start <= 9; start++){
	            if(start > value){
	                printIncreasingNumber(n-1, output + Integer.toString(start));
	            }
	        }
	        
	    }
	    
	    
		public static void printIncreasingNumber(int n) {
			/* Your class should be named Solution.
			 * Don't write main() function.
		 	* Don't read input, it is passed as function argument.
		 	* Print output as specified in the question
			*/

	        if(n == 0){
	            System.out.println("0");
	        }
	        printIncreasingNumber(n,"");
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printIncreasingNumber(2);

	}

}
