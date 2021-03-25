package dynamic_programming;

/*
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
*/



public class MIN_STEPS_TO_ONE {

	
	public static int countMinStepsToOne(int n) {
		//Your code goes here
        return countMinStepsToOne(n, 0);
	}
    
    public static int countMinStepsToOne(int n, int steps) {
		//Your code goes here
        
        if(n == 1){
            return steps;
        }
        
        int count_2, count_3;
        
        count_2 = count_3 = Integer.MAX_VALUE;
        
        int count_1 = countMinStepsToOne(n-1, steps+1);
        
        if(n%2 == 0){ 
            
        count_2 = countMinStepsToOne(n/2, steps+1);
            
        }
        
        if(n%3 == 0){
            
        count_3 = countMinStepsToOne(n/3, steps+1);
            
        }
        
        int min  = Math.min(count_1,Math.min(count_2, count_3));
        
        return min;
	}
    
    
    public static int countMinStepsToOneDP(int n) {
		//Your code goes here
        
        int size = (n > 3)?n:3; // Forgot to check n<3, arrayindexoutofbounderror
        
        int[] storage = new int[size+1];
        
        storage[1] = 0; // wrong base case storage[1] = 1
        
        storage[2] = storage[3] = 1;
        
        for(int i = 4;i <= n;i++) {
            
            int step_1 = storage[i-1] + 1;
            int step_2, step_3;
            
            step_2 = step_3 = Integer.MAX_VALUE;
            if(i%2 == 0){
                step_2 = storage[i/2] + 1;
            }
            
            if(i%3 == 0){
                step_3 = storage[i/3] + 1;
            }
            
            storage[i] = Math.min(step_1, Math.min(step_2, step_3));
        }
        
        return storage[n];
	}


    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
