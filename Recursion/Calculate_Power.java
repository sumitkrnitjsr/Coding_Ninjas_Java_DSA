package Recursion;

/*
Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
*/		
		
		
public class Calculate_Power {
	
	

	public static int power(int x, int n) {
        
        if( n == 0){
            return 1;
        }
        
        return (x * (power(x,(n-1))));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(power(2,5));

	}

}
