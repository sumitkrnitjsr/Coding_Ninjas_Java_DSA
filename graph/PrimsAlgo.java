package graph;
import java.util.Scanner;

public class PrimsAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] graph = new int[v][v];
		for(int i = 0;i < e;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			graph[start][end] = weight;
			graph[end][start] = weight;
		}

		boolean[] visited = new boolean[v];
		int[] parent = new int[v];
		int[] weight = new int[v];
		parent[0] = -1;
		weight[0] = 0;
		for(int i = 1;i < v;i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0;i < v;i++) {
			int minIndex = -1;
			for(int k = 0;k < v;k++) {
				if(minIndex == -1 || (!visited[k] && weight[k] < weight[minIndex])) { // minIndex != -1 wrong test case
					minIndex = k;
				}
			}
			visited[minIndex] = true; // forgot to mark visited 
			for(int j = 0;j < v;j++) {
				if(!visited[j] && (graph[minIndex][j] != 0 &&  graph[minIndex][j] < weight[j])) {  // forgot to check graph[minIndex][j] != 0 which will filter non existing edges
					weight[j] = graph[minIndex][j];
					parent[j] = minIndex;
				}
			}
		}
		
		for(int i = 1;i < v;i++) {
			
			if(parent[i] < i) {
				System.out.println(parent[i] + " " + i + " " + weight[i]);
			}else {
				System.out.println(i + " " + parent[i] + " " + weight[i]);
			}
		}
	}

}
