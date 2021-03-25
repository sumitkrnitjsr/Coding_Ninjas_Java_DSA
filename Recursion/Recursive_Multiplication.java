package Recursion;

// Given two integers M & N, calculate and return their multiplication using recursion. You can only use subtraction and addition for your calculation. No other operators are allowed.


public class Recursive_Multiplication {
	
	public static int multiplyTwoIntegers(int m, int n){
		// Write your code here
        
        if(m == 1){
            return n;
        }
        
        if(m == 0){
            return 0;
        }
        
        if(m == -1){
            return (0-n);
        }
        
        int smallAns;
        if(m > 0) {
        	smallAns = multiplyTwoIntegers(m-1, n);
        }else {
        	smallAns = multiplyTwoIntegers(m+1, n);
        }
        if(m > 0){
            return (smallAns + n);
        }
        
        return (smallAns + (0-n));
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(multiplyTwoIntegers(-4,-5));
		System.out.println(multiplyTwoIntegers(4,-5));
		System.out.println(multiplyTwoIntegers(-4,5));
	}

}
