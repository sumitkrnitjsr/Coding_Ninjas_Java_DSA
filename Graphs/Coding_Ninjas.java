package Graphs;

public class Coding_Ninjas {
	
    boolean findString(char[][] graph, int i, int j, boolean[][] visited, int index,int N,int M){
        String str = "CODINGNINJA";
        if(index == str.length()){
            return true;
        }
        
        if(i < 0 || i >= N || j < 0 || j >= M || visited[i][j]){
            return false;
        }
        
        char current = str.charAt(index);
        boolean result = false;
        if(graph[i][j] == current){
            visited[i][j] = true;
            result = result || findString(graph,i-1, j-1, visited, index+1,N,M);
            result = result || findString(graph,i-1,j,visited, index+1,N,M);
            result = result || findString(graph,i-1,j+1,visited,index+1,N,M);
            result = result || findString(graph,i,j+1,visited,index+1,N,M);
            result = result || findString(graph, i+1,j+1,visited,index+1,N,M);
            result = result || findString(graph,i+1,j,visited,index+1,N,M);
            result = result || findString(graph,i+1,j-1,visited,index+1,N,M);
            result = result || findString(graph, i, j-1, visited, index+1,N,M);
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
                    boolean check = findString(g, i,j, visited,0,N,M);
                    if(check){
                        return 1;
                    }
            }
        }
		return 0;
	}
	
	
}