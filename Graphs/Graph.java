package Graphs;
import java.util.Scanner;

public class Graph {

	private static void DFS(int edges[][],int sv,boolean[] visited) {
	
		System.out.println(sv);
		visited[sv] = true;
		for(int i = 0;i < edges.length;i++) {
			if(!visited[i] && edges[sv][i] == 1) {
				DFS(edges, i, visited);
			}
		}
	}
	
	public static void DFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		for(int i = 0;i < edges.length;i++) {
			if(!visited[i]) {
				DFS(edges, i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		int n;
		int e;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		e = s.nextInt();
		int edges[][] = new int[n][n];
		for(int i = 0;i < e;i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		DFS(edges);
	}

}
