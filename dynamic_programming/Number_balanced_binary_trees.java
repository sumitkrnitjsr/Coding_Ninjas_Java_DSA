package dynamic_programming;

/*
Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
This number can be huge, so, return output modulus 10^9 + 7.
Write a simple recursive solution.
*/

public class Number_balanced_binary_trees {
	
	public static long balancedBTs(long n){

        if(n < 2){
            return 1;
        }
        
        long x = balancedBTs(n-1);
        long y = balancedBTs(n-2);
        long mod = 1000000007;
        long count = (x*x)%mod;
        count = (count + (2*x*y)%mod)%mod;
		return count;
	}
	
	public static int balancedBTsDP(int height){

	    long mod = 1000000007;

	    long[] height_p = new long[height+1];
	    
	    height_p[0] = height_p[1] = 1;
	    
	    for(int i = 2;i <= height; i++){
			height_p[i] = (height_p[i-1] * height_p[i-1])%mod;
	        height_p[i] = (height_p[i] + (2*height_p[i-1]*height_p[i-2])%mod)%mod;
	    }

	    return (int)height_p[height];
	    
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
