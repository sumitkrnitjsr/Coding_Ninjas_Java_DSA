package Recursion;

// Given an integer N, count and return the number of zeros that are present in the given integer using recursion.
		

public class Count_Zeroes {
	
	
	
	
	public static int countZerosRec(int input){
		// Write your code here
        
        if(input/10 == 0){
            if(input == 0){
                return 1;
            }
            return 0;
        }
        
        int remainder = input%10;
        int zeroes = countZerosRec(input/10);

        if(remainder == 0){
            return zeroes + 1 ;
        }
        
        return zeroes;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countZerosRec(708000));
	}

}
