package dynamic_programming_2;

// For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.



public class Ways_Coin_Changes {
	
	
	public static int countWaysToMakeChange(int denominations[], int value){        
        return countWaysToMakeChange(denominations, value,0);
	}
    
    public static int countWaysToMakeChange(int denominations[], int value,int index){
        // Write your code here
        
        if(value == 0){
            return 1;
        }
        
        if(value < 0){
            return 0;
        }
        
        int sum = 0;
        for(int i = index;i < denominations.length;i++){
            if(denominations[i] <= value){
                sum += countWaysToMakeChange(denominations, value - denominations[i],i);
            }
        }
        return sum;
	}
    
	public static int countWaysToMakeChangeMemoization(int denominations[], int value){        
        int[][] storage = new int[denominations.length + 1][value + 1];
        
        for(int i = 0;i <= denominations.length; i++){
            for(int j = 0;j <= value; j++){
                storage[i][j] = -1;
            }
        }
        
        return countWaysToMakeChangeMemoization(denominations, value, storage, 0);
	}
    
	
    public static int countWaysToMakeChangeMemoization(int denominations[], int value,int[][] storage,int index){
        
        if(value == 0){
            storage[index][value] = 1;
            return storage[index][value];
        }
        
        if(storage[index][value] != -1){
            return storage[index][value];
        }
        
        if(value < 0){
            storage[index][value] = 0;
            return storage[index][value];
        }
        
        int sum = 0;
        for(int i = index;i < denominations.length;i++){
            if(denominations[i] <= value){
                sum += countWaysToMakeChangeMemoization(denominations, value - denominations[i],storage, i);
            }
        }
        
        storage[index][value] = sum;
        return storage[index][value] ;
        
	}
    
    
    public int change(int amount, int[] coins) {
        
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;
        for(int i = 0;i < coins.length;i++){
            
            for(int j = 1;j <= amount;j++){
                
                if(coins[i] <= j){
                    combinations[j] += combinations[j - coins[i]]; 
                }
                
            }
            
        }
        
        return combinations[amount];
    }
 
    
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
