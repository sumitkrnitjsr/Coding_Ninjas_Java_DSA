package dynamic_programming;

/*
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
*/

public class Minimum_Square_Sum {

	public static int minCount(int n) {
		//Your code goes here
        return minCountDP(n);
	}
    
    
    
    public static int minCountRecur(int n) {
    	
        if(n <= 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        int minSteps = n;
        
        for(int i = 1;i*i <= n; i++ ){
            int steps = 1 + minCountRecur(n - (i*i));
            if(steps < minSteps){
                minSteps = steps;
            }
        }
        
        return minSteps;
        
    }
    
    
       public static int minCountMemoization(int n) {
           int[] storage = new int[n + 1];
           storage[1] = 1;
           
           return minCountMemoization(n, storage);
           
       }
    
        public static int minCountMemoization(int n,int[] storage) {
        	
            if(storage[n] != 0){
                return storage[n];
            }
            
        int minSteps = n;
        
        for(int i = 1;i*i <= n; i++ ){
            
            int steps = 1 + minCountMemoization(n - (i*i), storage);
            if(steps < minSteps){
                minSteps = steps;
            }
        }
            
        storage[n] = minSteps;
        
        return  storage[n];
        
    }
    
    
    public static int minCountDP(int n) {
        	
           int[] storage = new int[n + 1];
           storage[1] = 1;
            
        
        
        for(int i = 2;i <= n; i++ ){
            
            int minSteps = n;
            for(int j = 1;j*j <= n; j++ ){
            if(i - (j*j) < 0){ // Forgot to handle base case
                continue;
            }    
            int steps = 1 + storage[i - (j*j)];
            if(steps < minSteps){
                minSteps = steps;
            }
        }
			storage[i] = minSteps;
            
        }
            
        return  storage[n];
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
