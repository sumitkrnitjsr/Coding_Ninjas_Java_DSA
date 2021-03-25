package dynamic_programming_2;

/*
You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.
*/


public class Magic_Grid {
	
	public static int getMinimumStrength(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] storage = new int[row][col];
        storage[row - 1][col - 1] = 1;
        storage[row - 2][col - 1] = 1;
        storage[row - 1][col - 2] = 1;
        
        for(int i = col - 3; i >= 0; i-- ){
            if(grid[row - 1][i + 1] < 0){
                storage[row - 1][i] = storage[row-1][i+1] - grid[row-1][i+1];
            }else{
                storage[row-1][i] = Math.max(1, storage[row-1][i+1] - grid[row-1][i+1]);
            }
        }
        
        for(int j = row-3;j >=0; j--){
            
            if(grid[j+1][col-1] < 0){
                storage[j][col-1] = grid[j+1][col-1] - grid[j+1][col-1];
            }else{
                storage[j][col-1] = Math.max(1, grid[j+1][col-1] - grid[j+1][col-1]);
            }
            
        }
        
        for(int i = row-2; i>=0; i--){
            for(int j = col-2; j>=0; j--){
                
                int down, right;
                
                if(grid[i+1][j] < 0){
                    down = storage[i+1][j] - grid[i+1][j];
                }else{
                    down = Math.max(1,storage[i+1][j] - grid[i+1][j] );
                }
                
                if(grid[i][j+1] < 0){
                    right = storage[i][j+1] - grid[i][j+1];
                }else{
                    right = Math.max(1,storage[i][j+1] - grid[i][j+1] );
                }
                
                storage[i][j] = Math.min(down, right);
                
            }
        }
        
        return storage[0][0];

}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
