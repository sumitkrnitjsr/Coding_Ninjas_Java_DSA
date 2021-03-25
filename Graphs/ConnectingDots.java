package Graphs;

/*
Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:
1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.
*/


public class ConnectingDots {
	
	 boolean findCycle(char[][] graph, int i, int j, boolean[][] visited,int N,int M, char c,int bi,int bj, int steps){
	       
	        if(i < 0 || i >= N || j < 0 || j >= M){
	            return false;
	        }
	        
	       	if(graph[i][j] != c){
	            return false;
	        } 
	        
	        if(visited[i][j]){
	            
	        	if(bi == i && bj == j){
	        		if(steps != 0 && steps < 4){
	                	return false;
	            	}else if(steps > 3){
	                	return true;
	            }
	        }else{
	            return false;
	        }
	            
	        }

	        visited[i][j] = true;
	        char current = graph[i][j];
	        boolean result = false;
	        if(c == current){
	            
	            steps++;
	            result = result || findCycle(graph,i-1,j,visited,N,M,c,bi,bj,steps);
	            result = result || findCycle(graph,i,j+1,visited,N,M,c,bi,bj, steps);
	            result = result || findCycle(graph,i+1,j,visited,N,M,c,bi,bj, steps);
	            result = result || findCycle(graph, i, j-1, visited,N,M,c,bi,bj, steps);
	        }else{
	            return false;
	        }
	        visited[i][j] = false;
	        return result;
	    }
	    
	    int solve(String[] Graph , int N, int M) {
	        boolean[][] visited = new boolean[N][M];
	        char[][] g = new char[N][M];
	        for(int i = 0;i < N;i++){
	        	String str = Graph[i];
	            for(int j = 0;j < M;j++){
	                g[i][j] = str.charAt(j);
	            }
	        }
	        for(int i = 0;i < N;i++){
	            for(int j = 0;j < M;j++){
	                    boolean check = findCycle(g, i,j,visited,N,M,g[i][j],i,j,0);
	                    if(check){
	                        return 1;
	                    }
	            }
	        }
			return 0;
			
		}

}
