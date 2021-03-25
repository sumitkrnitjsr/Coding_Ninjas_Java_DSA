package graph;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
/*
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
*/

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int weight;
    
    public int compareTo(Edge e1){
        return (weight - e1.weight);
    }
}
public class KruskalsAlgo {

    private static int getParent(int[] parent, int index){
        if(parent[index] == index){
            return index;
        }
        int p = getParent(parent, parent[index]);
        parent[index] = p;
        return p;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        Edge[] edge = new Edge[E];
        for(int i = 0;i < E;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            edge[i] = new Edge(); // forgot to initialize object, tried direct assignment
            edge[i].start = Math.min(start,end);
            edge[i].end = Math.max(start,end);
            edge[i].weight = sc.nextInt();
        }
        
        int[] parent = new int[V];
        for(int i = 0;i < V;i++){
            parent[i] = i;
        }
		int count = 0;
        Edge[] result = new Edge[V-1];
        int out_index = 0;
        int in_index = 0;
        Arrays.sort(edge);
        while(count != V-1){
            Edge out = edge[out_index];
            int start = out.start;
            int end = out.end;
            int p_start = getParent(parent, start);
            int p_end = getParent(parent, end);
            if(p_start != p_end){
                result[in_index] = out;
                parent[p_start] = parent[p_end]; // forgot to update parents
                in_index++;
                count++;
            }
            out_index++;
        }
        
        for(int i = 0;i < V-1;i++){
            System.out.println(result[i].start + " " + result[i].end + " " + result[i].weight);
        }
	}
}