package Recursion;
import java.lang.Math;


/*
Given k, find the geometric sum i.e.
1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
*/

public class Geometric_Sum {
	
	 public static double findGeometricSum(int k){
	        
	        if( k == 0){
	            return 1.0;
	        }
	        
	        double smallAnswer = findGeometricSum(k-1);
	        
	        double power = 1.0/Math.pow(2,k);
	        
	        double sum = power + smallAnswer;
	        
	        return sum;
	        
	    }
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findGeometricSum(4));

	}

}
