package Graphs;

//  It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
		
public class Largest_Piece {
	
	 private static int getCount(int[][] g,int i,int j,int n,boolean[][] visited){
	        if(i < 0 || i >= n || j < 0 || j >= n){
	            return 0;
	        }
	        
	        if(g[i][j] == 0){
	            return 0;
	        }
	        
	        visited[i][j] = true;
	        int count = 1;
	        if(i > 0 && !visited[i-1][j]){
	        	count += getCount(g,i-1,j,n,visited);    
	        }
	        if(j < n-1 && !visited[i][j+1]){
	        	count += getCount(g,i,j+1,n,visited);    
	        }
	        if(i < n-1 && !visited[i+1][j]){
	        	count += getCount(g,i+1,j,n,visited);    
	        }
	        if(j > 0 && !visited[i][j-1]){
	        	count += getCount(g,i,j-1,n,visited);    
	        }
	        return count;
	    }
	    
		public static int dfs(String[] edge, int n) {
	        boolean[][] visited = new boolean[n][n];
	        int[][] g = new int[n][n];
	        for(int i = 0;i < n;i++){
	        	String str = edge[i];
	            for(int j = 0;j < n;j++){
	                g[i][j] = str.charAt(j) - '0';
	            }
	        }
	        
	        int max = -1;
	        for(int i = 0;i < n;i++){
	            for(int j = 0;j < n;j++){
	                if(!visited[i][j] && g[i][j] == 1){
	                    int count = getCount(g,i,j,n, visited);
	                    if(max < count){
	                        max = count;
	                    }
	                }
	            }
	        }
	        return max;
		}

}
