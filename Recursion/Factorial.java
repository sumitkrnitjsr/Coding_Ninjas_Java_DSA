package Recursion;

public class Factorial {
	
	static int fact(int n) {
		
		if(n < 2) {
			return 1;
		}
		
		int smallans = fact(n-1);
		return n * smallans;
	}
	
	static int statckoverflow_fact(int n) { 
		
		
		int smallans = statckoverflow_fact(n-1);
		return n * smallans;
	}
	
	static int error_fact(int n) { 
		
		int fact = 1;
		for(int i=2; i>=n; i++) {
			fact = fact*i;
		}
		return fact;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		int fact = 1;
		//int answer = error_fact(n);
		//int ans = statckoverflow_fact(n);
		System.out.println(fact(n));

	}

}
