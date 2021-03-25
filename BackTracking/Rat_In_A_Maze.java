package BackTracking;

/*
You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
*/


public class Rat_In_A_Maze {
	
	
	 static boolean validTop(int maze[][],int track[][],int x,int y){
	        
	        int row = maze.length;
	        if(x-1 >= 0 && maze[x-1][y] == 1 && track[x-1][y] == 0){
	            track[x-1][y] = 1;
	            return true;
	        }
	        
	        return false;
	    }
	    
	    static boolean validRight(int maze[][],int track[][],int x,int y){
	        
	        int row = maze.length;
	        if(y+1 <= row-1 && maze[x][y+1] == 1 && track[x][y+1] == 0){
	            track[x][y+1] = 1;
	            return true;
	        }
	        
	        return false;
	    }
	    
	    static boolean validBottom(int maze[][],int track[][],int x,int y){
	        
	        int row = maze.length;
	        if(x+1 <= row-1 && maze[x+1][y] == 1 && track[x+1][y] == 0){
	            track[x+1][y] = 1;
	            return true;
	        }
	        
	        return false;
	    }
	    
	    static boolean validLeft(int maze[][],int track[][],int x,int y){
	        
	        int row = maze.length;
	        if(y-1 >= 0 && maze[x][y-1] == 1 && track[x][y-1] == 0){
	            track[x][y-1] = 1;
	            return true;
	        }
	        
	        return false;
	    }
	    
	    static void restore(int track[][],int position, int x, int y){
	        
	        switch(position){
	                
	            case 1:
	                track[x-1][y] = 0;
	                break;
	                
	            case 2:
	                track[x][y+1] = 0;
	                break;
	                
	            case 3:
	                track[x+1][y] = 0;
	                break;
	                
	            case 4:
	                track[x][y-1] = 0;
	                break;
	        }
	        
	    }
	    

	    public static boolean ratInAMaze(int maze[][],int track[][],int x,int y){
	     
	        int row = maze.length;
	        
	        
	    	if(x == row-1 && y == row-1){
	            return true;
	        }
	        
	        boolean result;
	        if(validTop(maze,track,x,y)){
	            result = ratInAMaze(maze,track,x-1,y);
	            if(result){
	                return result;
	            }
	            restore(track,1,x,y);
	        }
	        
	        if(validRight(maze,track,x,y)){
	            result = ratInAMaze(maze,track,x,y+1);
	            if(result){
	                return result;
	            }
	            restore(track,2,x,y);
	        }
	        
	        if(validBottom(maze,track,x,y)){
	            result = ratInAMaze(maze,track,x+1,y);
	            if(result){
	                return result;
	            }
	            restore(track,3,x,y);
	        }
	        
	        if(validLeft(maze,track,x,y)){
	            result = ratInAMaze(maze,track,x,y-1);
	            if(result){
	                return result;
	            }
	            restore(track,4,x,y);
	        }
	            
	        return false;
	    }

		public static boolean ratInAMaze(int maze[][]){


	        int row = maze.length;
	        int track[][] = new int[row][row];
	        
	        for(int i = 0;i < row; i++){
	            
	            for(int j = 0;j < row;j++){
	                track[i][j] = 0;
	            }
	        }
	        
	        track[0][0] = 1;
	        
	        return ratInAMaze(maze, track,0,0);

		}
		

}
