package Recursion;

public class Fibonacci_Number {
	
	static int fib(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fib(n-1) + fib(n-2);
		
	}
	
	
	static int wrong_fib(int n) {
		
		if(n == 0) {
			return 0;
		}
		
		return wrong_fib(n-1) + wrong_fib(n-2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 5;
		//int ans = wrong_fib(num);
		int ans = fib(num);
		System.out.print(ans);

	}

}
