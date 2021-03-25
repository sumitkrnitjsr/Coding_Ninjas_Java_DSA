package Recursion;


// Given an integer N, find and return the count of minimum numbers, sum of whose squares is equal to N.

public class Minimum_Count {
	
public static int minCount(int n){
		
        /* Your class should be named Solution
	 	 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		*/
        
        if(n == 0){  // Forgot this base case
            return 0;
        }
        
        if(n < 2){
            return 1;
        }
        
        int i = 1;
        int min = Integer.MAX_VALUE;
        while( (i*i) <= n){
         	int count = 1 + minCount(n - (i*i));
            if(count < min){
                min  = count;
            }
            
            i++;
        }
		
        return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCount(6));
	}

}
