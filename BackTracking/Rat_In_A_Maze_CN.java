package BackTracking;

public class Rat_In_A_Maze_CN {
	
	
	static boolean ratInAMaze(int[][] maze) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze(maze,0,0,path);
	}
	
	static boolean solveMaze(int[][] maze,int i,int j, int[][] path) {
		
		int n = maze.length;
		
		//Check for valid index in proper order
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		
		//Include i,j in path
		path[i][j] = 1;
		
		//Check if already reached
		if(i == n-1 && j == n-1) {
			return true;
		}
		
		//explore top
		if(solveMaze(maze,i-1,j,path)) {
			return true;
		}
		
		//explore right
		if(solveMaze(maze,i,j+1,path)) {
			return true;
		}
		
		//explore down
		if(solveMaze(maze,i+1,j,path)) {
			return true;
		}
		
		//explore left
		if(solveMaze(maze,i,j-1,path)) {
			return true;
		}
		
		return false;
		
	}
	
	
	public static void ratInAMazePrint(int maze[][]){
		
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
	        
	        int n = maze.length;
	        int[][] path = new int[n][n];
			
	        solveMazePrint(maze,0,0,path);
		}
	    
	    
	    static void solveMazePrint(int[][] maze,int i,int j,int[][] path) {
	    
	        int n = maze.length;
	        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
	            return;
	        }
	        
	        path[i][j] = 1;
	        
	        if(i == n-1 && j == n-1){
	            for(int r = 0; r < n;r++){
	                for(int c = 0;c < n;c++){
	                    System.out.print(path[r][c] + " ");
	                }
	            }
	            System.out.println();
	            return;
	        }
	        
	        
	        int[][] temp = new int[n][n];
	        
	        restore(temp,path);
	        
	        solveMazePrint(maze,i-1,j,temp);
	        
	        restore(temp,path);
	        
	        solveMazePrint(maze,i,j+1,temp);
	        
	        restore(temp,path);
	        
	        solveMazePrint(maze,i+1,j,temp);
	        
	        restore(temp,path);
	        
	        solveMazePrint(maze,i,j-1,temp);
	        
	        restore(temp,path);
	        
	    }
	    
	    static void restore(int[][] temp,int[][] path){
	        int n = path.length;
	        for(int i = 0;i < n;i++){
	            for(int j = 0;j < n;j++){
	                temp[i][j] = path[i][j];
	            }
	        }
	    }
	    
	    static void solveMazePrintEfficient(int[][] maze,int i,int j,int[][] path) {
		    
	        int n = maze.length;
	        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
	            return;
	        }
	        
	        path[i][j] = 1;
	        
	        if(i == n-1 && j == n-1){
	            for(int r = 0; r < n;r++){
	                for(int c = 0;c < n;c++){
	                    System.out.print(path[r][c] + " ");
	                }
	            }
	            System.out.println();
	            path[i][j] = 0;
	            return;
	        }
	        
	        

	        
	        solveMazePrintEfficient(maze,i-1,j,path);
	        
	
	        
	        solveMazePrintEfficient(maze,i,j+1,path);
	        
	   
	        
	        solveMazePrintEfficient(maze,i+1,j,path);
	        
	   
	        
	        solveMazePrintEfficient(maze,i,j-1,path);
	        
	        path[i][j] = 0;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = {{1,1,0},{1,0,1},{0,1,1}};
		System.out.println(ratInAMaze(maze));

	}

}
