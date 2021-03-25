package dynamic_programming;

public class fibonacci {
	
	
	public static int fib(int n) {
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		
		return fib(n-1) + fib(n-2);
	}
	
	
	public static int fibMemoization(int n) {
		
		int[] storage = new int[n+1];
		
		for(int i = 0;i <= n;i++) {
			storage[i] = -1;
		}
		
		return fibMemoization(n, storage);
	}
	
	public static int fibMemoization(int n,int[] storage) {
		
		if( n == 0 || n == 1) {
			storage[n] = n;
			return storage[n];
		}
		
		if(storage[n] != -1) {
			return storage[n];
		}
		
		storage[n] = fibMemoization(n-1, storage) + fibMemoization(n-2, storage);
		
		return storage[n];
	}
	
	public static int fibDPBU(int n) {
		
		int storage[] = new int[n+1];
		
		storage[0] = 0;
		storage[1] = 1;
		
		for(int i = 2;i <= n;i++) {
			storage[i] = storage[i - 1] + storage[i - 2];
		}
		
		return storage[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(fib(20));
		System.out.println(fibMemoization(20));
		System.out.println(fibDPBU(20));

	}

}
