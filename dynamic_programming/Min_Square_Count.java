package dynamic_programming;


// Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.


public class Min_Square_Count {
	
	public static int minCount(int n) {
        
        if(n < 4){
            return n;
        }
		//Your code goes here
        int[] count = new int[n + 1];
        count[1] = 1;
        count[2] = 2;
        count[3] = 3;
        count[4] = 1;
        
        for(int i = 5;i <= n;i++){
            
            int min = i;
            for(int j = 1;j*j <= i; j++){
                int num = 1 + count[i - (j*j)];
                if(num < min){
                    min = num;
                }
            }
            count[i] = min;
        }
        
        return count[n];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
