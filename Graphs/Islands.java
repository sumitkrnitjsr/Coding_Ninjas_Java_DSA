package Graphs;

//  An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.


public class Islands {
	
    private static void traverse(int[][] edges, boolean[] visited, int vertex){
        visited[vertex] = true;
        for(int i = 0;i < visited.length; i++){
            if(!visited[i] && edges[vertex][i] == 1){
                traverse(edges, visited, i);
            }
        }
    }
    
    
    
	public static int numConnected(int[][] edges, int n) {
		boolean visited[] = new boolean[edges.length];
        int count = 0;
        for(int i = 0;i < edges.length;i++){
            if(!visited[i]){
                count++;
                traverse(edges, visited, i);
            }
        }
        return count;
	}



}
