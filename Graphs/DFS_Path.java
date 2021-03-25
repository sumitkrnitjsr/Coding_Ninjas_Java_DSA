package Graphs;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
/*
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using DFS and print the first path that you encountered.
*/

public class DFS_Path {
    

    private static ArrayList<Integer> DFSPath(boolean[][] graph, boolean[] visited, int start, int end){
    
        ArrayList<Integer> result = new ArrayList<>();
        if(start == end){
            result.add(start);
            return result;
        }
        visited[start] = true;
        for(int i = 0;i < graph.length;i++){
        
            if(!visited[i] && graph[start][i]){
                ArrayList<Integer> smallAns = DFSPath(graph, visited, i, end);
                if(smallAns != null){
                    smallAns.add(start);
                    return smallAns;
                }
            }
        }
        return null;
    }
    
    
    private static ArrayList<Integer> DFSPath(boolean[][] graph, int start, int end){
        boolean visited[] = new boolean[graph.length];
        return DFSPath(graph, visited, start,end);
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
        ArrayList<Integer> result = DFSPath(graph,start,end);
        if(result != null){
            for(Integer i : result){
                System.out.print(i + " ");
            }
        }
	}
}