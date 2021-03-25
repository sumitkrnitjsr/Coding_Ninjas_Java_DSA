package dynamic_programming_2;

/*
An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
*/

public class Minimum_Cost_Path {
	
	public static int minCostPath(int[][] input) {
		//Your code goes here
        int row = input.length;
        int col = input[0].length;
		return minCostPath(input, 0, 0,row,col);
	}
    
    
    public static int minCostPath(int[][] input,int row, int col,int r, int c) {
		//Your code goes here
        
        if(row == r-1 && col == c-1){
            return input[row][col];
        }
        
        int row_below = row + 1;
        int col_next = col + 1;
        
        int min_cost = Integer.MAX_VALUE;
        int value = input[row][col];
        
        if(col_next < c){
            int cost = value + minCostPath(input, row, col_next,r,c); // forgot to include recursive calls
            min_cost = (min_cost > cost)?cost:min_cost;
        }
        
        if(row_below < r){
            // int cost = minCostPath(input, row_below, col,r,c); wrong call didn't add current value
            int cost = value + minCostPath(input, row_below, col,r,c);
            min_cost = (min_cost > cost)?cost:min_cost;
        }
        
        if(col_next < c && row_below < r){
            int cost = value + minCostPath(input, row_below, col_next,r,c);
            min_cost = (min_cost > cost)?cost:min_cost;
        }
        
       //  input[row][col] += min_cost; wrong to store values 
        
        return min_cost;
		
	}
    
    public static int minCostPathMemoize(int[][] array){
        int row = array.length;
        int col = array[0].length;
        int[][] cost = new int[row][col];
        return minCostPathMemoize(array, cost, 0, 0, row, col);
    }
    
    
    public static int minCostPathMemoize(int[][] input,int cost[][],int row,int col,int r,int c){
        
        if(row == r - 1 && col == c - 1){
            return input[row][col];
        }
        
        if(cost[row][col] != 0){
            return cost[row][col];
        } 
        
        int row_below = row + 1;
        int col_next = col + 1;
        
        int min_cost = Integer.MAX_VALUE;
        int value = input[row][col];
        
        if(col_next < c){
            int cost_t = value + minCostPathMemoize(input, cost, row, col_next,r,c); // forgot to include recursive calls
            min_cost = (min_cost > cost_t)?cost_t:min_cost;
        }
        
        if(row_below < r){
            // int cost = minCostPath(input, row_below, col,r,c); wrong call didn't add current value
            int cost_t = value + minCostPathMemoize(input, cost, row_below, col,r,c);
            min_cost = (min_cost > cost_t)?cost_t:min_cost;
        }
        
        if(col_next < c && row_below < r){
            int cost_t = value + minCostPathMemoize(input, cost, row_below, col_next,r,c);
            min_cost = (min_cost > cost_t)?cost_t:min_cost;
        }
        
        cost[row][col] = min_cost;
        
        return min_cost;
        
    }
    
    
    public static int minCostPathDP(int[][] input) {

        int row = input.length;
        int col = input[0].length;
        
        for(int i = row - 1;i >= 0;i--){
            
            for(int j = col - 1;j >= 0;j--){
                
                int op1 = (j + 1 < col && i < row)?(input[i][j + 1]):Integer.MAX_VALUE;
            	int op2 = (j + 1 < col && i < row)?(input[i + 1][j + 1]):Integer.MAX_VALUE;
                int op3 = (j + 1 < col && i < row)?(input[i + 1][j]):Integer.MAX_VALUE;
                input[i][j] = Math.min(op1, Math.min(op2,op3));
            }
        }
        
        return input[0][0];
    }

}
