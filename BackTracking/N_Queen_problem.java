package BackTracking;


// You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.


public class N_Queen_problem {
	
	public static void placeNQueens(int n){
		
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */

	    int[][] board = new int[n][n];
	    placeNQueens(board, n, 0);

		}
	    
	public static void placeNQueens(int[][] board, int n,int row){
	 
	    if(row == n){
	        
	        for(int i = 0;i < n;i++){
	            
	            for(int j = 0;j < n;j++){
	                
	                System.out.print(board[i][j] + " ");
	            }
	        }
	        
	        System.out.println();
	        return;
	    }
	    
	    
	  for(int i = 0;i < n;i++){
	      if(safe(board,row,i)){
	          board[row][i] = 1;
	          placeNQueens(board, n, row+1);
	          board[row][i] = 0;
	      }  
	  }  
	      
	}
	    
	    
	public static boolean safe(int[][] board,int row,int col){
	    
	    int n = board.length;
	    //Check vertical
	    for(int i = 0;i < n;i++){
	        if(i != row && board[i][col] == 1){
	            return false;
	        }
	    }
	    
	    //Check Horizontal
	    for(int i = 0;i < n;i++){
	        if(i != col && board[row][i] == 1){
	            return false;
	        }
	    }
	    
	    
	    /* Wrong diagonal check. check both left and right diagonals
	    for(int i = 0;i < n;i++) {    
	        
	        if(i != row && board[i][i] == 1){
	            return false;
	        }
	    }
	    */
	    
	    int left_diagonal_row = row - 1;
	    int left_diagonal_col = col - 1;
	    
	    while(left_diagonal_row >= 0 && left_diagonal_col >= 0){
	        if(board[left_diagonal_row][left_diagonal_col] == 1){
	            return false;
	        }
	        left_diagonal_row--;
	        left_diagonal_col--;
	    }
	    
	    left_diagonal_row = row + 1;
	    left_diagonal_col = col + 1;
	    
	    while(left_diagonal_row < n && left_diagonal_col < n){
	        if(board[left_diagonal_row][left_diagonal_col] == 1){
	            return false;
	        }
	        left_diagonal_row++;
	        left_diagonal_col++;
	    }
	    
	    
	    int right_diagonal_row = row - 1;
	    int right_diagonal_col = col + 1;
	    
	    while(right_diagonal_row >= 0 && right_diagonal_col < n){
	        if(board[right_diagonal_row][right_diagonal_col] == 1){
	            return false;
	        }
	        right_diagonal_row--;
	        right_diagonal_col++;
	    }
	    
	    right_diagonal_row = row + 1;
	    right_diagonal_col = col - 1;
	    
	    while(right_diagonal_row < n && right_diagonal_col >= 0){
	        if(board[right_diagonal_row][right_diagonal_col] == 1){
	            return false;
	        }
	        right_diagonal_row++;
	        right_diagonal_col--;
	    }

	    
	    
	    return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeNQueens(4);
	}

}
