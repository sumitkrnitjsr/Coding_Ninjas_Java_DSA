package dynamic_programming_2;


// A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weighs wi and is of value vi. Considering the constraints of maximum weight that knapsack can carry, you have to find and return the maximum value that thief can generate by stealing items.
		
		
public class Knapsack_0_1 {
	
	 static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
	        
	        if( maxWeight == 0 || n == 0){
	            return 0;
	        }
	        
	        if(weight[n-1] > maxWeight){
	            return knapsack(weight, value, n-1, maxWeight);
	        }
	        
	        
	        return Math.max(value[n-1] + knapsack(weight, value, n-1, maxWeight - weight[n-1]), knapsack(weight, value,n-1, maxWeight )); 

	  }
	 
	 
	 
     static int knapsack(int[] weight, int[] value, int n, int maxWeight,int[][] storage) {
         
    	if( maxWeight == 0 || n == 0){
            storage[n][maxWeight] = 0;
            return storage[n][maxWeight];
        }
        
         if(storage[n][maxWeight] != -1){
             return storage[n][maxWeight];
         }
         
         
        if(weight[n-1] > maxWeight){
            return knapsack(weight, value, n-1, maxWeight, storage);
        }
        
        
        int ans =  Math.max(value[n-1] + knapsack(weight, value, n-1, maxWeight - weight[n-1], storage), knapsack(weight, value,n-1, maxWeight,storage)); 

        storage[n][maxWeight] = ans;
        return storage[n][maxWeight];
 
     }
     
     
     static int knapsackDP(int[] weight, int[] value, int n,int maxWeight){
         
         int[][] storage = new int[n][maxWeight + 1];
         
         for(int j = 1;j <= maxWeight;j++){
             
             if(weight[0] > j){
                 storage[0][j] = 0;
             }else{
                 storage[0][j] = value[0];
             }
         }
         
         for(int i = 1;i < n;i++){
             
             for(int j = 1;j <= maxWeight;j++){
                 
                 if(weight[i] > j){
                     storage[i][j] = storage[i-1][j];
                 }else{
                     storage[i][j] = Math.max(storage[i-1][j], value[i] + storage[i-1][j - weight[i]]); // Wrong code storage[i][j] = Math.max(storage[i-1][j], value[i] + storage[i-1][maxWeight - weight[i]]);
                 }
                 
             }
         }
         
         return storage[n-1][maxWeight];
 		
     }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
