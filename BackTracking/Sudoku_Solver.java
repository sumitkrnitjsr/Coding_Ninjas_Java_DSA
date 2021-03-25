package BackTracking;


// Given a 9*9 sudoku board, in which some entries are filled and others are 0 (0 indicates that the cell is empty), you need to find out whether the Sudoku puzzle can be solved or not i.e. return true or false.

public class Sudoku_Solver {

	public static boolean sudokuSolver(int board[][]){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Don't print output and return output as specified in the question.
	 */
        
	return sudokuSolver(board, 0, 0);
	
    }

    
	public static boolean sudokuSolver(int board[][],int row, int col){  
        
    if( row == board.length && col == 0){
        return true;
    }   

    if(board[row][col] != 0){
        if(col == board.length-1){
            return sudokuSolver(board, row + 1, 0);
        }
        return sudokuSolver(board, row , col + 1);
    }
        
    int next_row = row;
    int next_col = col + 1;
        
    if(next_col == board.length){
        next_row++;
        next_col = 0;
    }
    

        
    int[] list = getCandidates(board, row, col);
    
    if(list.length < 1){
        return false;
    }
        
    boolean result = false;
    for(int i = 0;i < list.length;i++){
        board[row][col] = list[i];
        result = (result || sudokuSolver(board, next_row, next_col));
        board[row][col] = 0;
    }
    
    return result;    
        
    }
    
    
    public static int[] getCandidates(int[][] board,int row,int col) {
        
        int[] candidates = new int[10];

        
        for(int i = 0;i < board.length;i++){
            candidates[board[i][col]]++;
        }
        
        for(int i = 0;i < board.length;i++){
            candidates[board[row][i]]++;
        }
        
        int begin_cube_row = (int)(row/3);
        int begin_cube_col = (int)(col/3);
        begin_cube_row *= 3; 
        begin_cube_col *= 3;
        
        for(int i = begin_cube_row;i < begin_cube_row + 3; i++){
         for(int j = begin_cube_col;j < begin_cube_col + 3; j++){
             candidates[board[i][j]]++;
         }   
        }

        
        
        int size = 0;
        
        for(int i = 1;i < 10;i++){
            if(candidates[i] == 0){
                size++;
            } 
        }
        
        int[] list = new int[size];
        int k = 0;
        for(int i = 0;i < 10;i++){
            if(candidates[i] == 0){
                list[k] = i;
                k++;
            }
            
        }
        
        return list;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
