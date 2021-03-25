package Recursion;


// Write a recursive function that returns the sum of the digits of a given integer.


public class Sum_Of_Digits {
	
	public static int sumOfDigits(int input){
		// Write your code here
        
        if(input/10 == 0){
            return input;
        }
        
        int digit = input%10;
        
        int smallAns = sumOfDigits(input/10);
        
        return digit + smallAns;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sumOfDigits(192348));

	}

}
