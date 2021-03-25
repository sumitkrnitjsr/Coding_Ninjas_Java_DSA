package Graphs;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

//  Given an undirected graph G(V,E), check if the graph G is connected graph or not.


public class isConnectedGraph {

    private static void isConnected(boolean[][] graph, boolean[] visited,int vertex){
        
        visited[vertex] = true;
        for(int i = 0;i < graph.length;i++){
            if(!visited[i] && graph[vertex][i]){
                isConnected(graph, visited, i);
            }
        }
    }
    
    private static boolean isConnected(boolean[][] graph){
        	if(graph.length == 0){
                return true;
            }
        
    		boolean[] visited = new boolean[graph.length];
        	isConnected(graph, visited, 0);
    		for(int i = 0;i < graph.length;i++){
                if(!visited[i]){
                    return false;
                }
            }
    		return true;
    }
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
       	int v;
        int e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        boolean[][] graph = new boolean[v][v];
        for(int  i = 0;i < e;i++){
            int fs = sc.nextInt();
            int ss = sc.nextInt();
            graph[fs][ss] = graph[ss][fs] = true;
        }
        System.out.println(isConnected(graph));
	}

}
