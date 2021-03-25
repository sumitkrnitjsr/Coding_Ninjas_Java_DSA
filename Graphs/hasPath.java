package Graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

//  Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.

public class hasPath {

    private static boolean isPath(boolean[][] graph, boolean[] visited, int start, int end){
    	if(start == end){
            return true;
        }
        visited[start] = true;
        boolean result =false;
        for(int i = 0;i < graph.length;i++){
            if(!visited[i] && graph[start][i]){
                result = result || isPath(graph, visited, i, end);
            }
        }
        return result;
    }
    
    private static boolean isPath(boolean[][] graph,int start, int end){
    	boolean visited[] = new boolean[graph.length];    
        return isPath(graph, visited, start, end);
    }	
    
    public static void main(String[] args) throws NumberFormatException, IOException {
         int vertices;
        int edges;
        Scanner sc = new Scanner(System.in);
        vertices = sc.nextInt();
        edges = sc.nextInt();
        boolean[][] graph = new boolean[vertices][vertices];
        for(int i = 0;i < edges;i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            graph[fv][sv] = graph[sv][fv] = true;
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(isPath(graph,start,end));
	}

}