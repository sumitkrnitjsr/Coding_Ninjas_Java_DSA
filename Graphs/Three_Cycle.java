package Graphs;

//  Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.

public class Three_Cycle {
	
	public static int solve(boolean[][] graph, int n) {
		int count = 0;
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(graph[i][j]){
                	for(int k = 0;k  < n;k++){
                    	if(graph[j][k] && graph[k][i]){
                            count++;
                        }
                	}
                }
            }
        }
        
        return (int)(count/6);
	}



}
