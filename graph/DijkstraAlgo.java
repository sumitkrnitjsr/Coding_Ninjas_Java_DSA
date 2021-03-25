package graph;
import java.util.Scanner;

public class DijkstraAlgo {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int v = sc.nextInt();
	int edge = sc.nextInt();
	
	int graph[][] = new int[v][v];
	
	for(int i = 0;i < edge;i++) {
		int src = sc.nextInt();
		int dest = sc.nextInt();
		int weight = sc.nextInt();
		graph[src][dest] = graph[dest][src] = weight;
	}
	
	boolean[] visited = new boolean[v];
	int[] distance = new int[v];
	
	for(int i = 1;i < v;i++) {
		distance[i] = Integer.MAX_VALUE;
	}
	distance[0] = 0;
	for(int i = 0;i < v;i++) {
		int minIndex = -1;
		for(int j = 0;j < v;j++) {
			if(!visited[j] && (minIndex == -1 || distance[j] < distance[minIndex])) {
				minIndex = j;
			}
		}
		visited[minIndex] = true;
		
		for(int k = 0;k < v;k++) {
			if(!visited[k] && graph[minIndex][k] != 0 && distance[minIndex] != Integer.MAX_VALUE) {  // forgot distance[minIndex] != Integer.MAX_VALUE
				int dist = distance[minIndex] + graph[minIndex][k];
				if(dist < distance[k]) {
					distance[k] = dist;
				}
			}
		}
		
	}
	
	for(int i = 0;i < v;i++) {
		System.out.println(i + " " + distance[i]);;
	}

}
	
	
}
