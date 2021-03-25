package graph;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/*
Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. Some pairs of islands are connected to each other by Bidirectional bridges running over water.
Monk hates to cross these bridges as they require a lot of efforts. He is standing at Island #1 and wants to reach the Island #N. Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.
*/

public class monk_and_islands {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
        while(testCases > 0){
        int vertices;
        int edges;
        vertices = sc.nextInt();
        edges = sc.nextInt();
        boolean[][] graph = new boolean[vertices][vertices];
        for(int i = 0;i < edges;i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            graph[fv-1][sv-1] = graph[sv-1][fv-1] = true;
        }
        boolean visited[] = new boolean[vertices];
        int start = 0;
        boolean found = false;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        int level = 0;
        while(!queue.isEmpty() && start != vertices - 1 && !found){
            int size = queue.size();
            level++;
            for(int i = 0;i < size;i++){
                int front = queue.poll();
                for(int j = 0;j < vertices;j++){
                    if(graph[front][j] && !visited[j]){
                        queue.add(j);
                        if(j == vertices - 1){
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
            System.out.println(level);
            testCases--;
        }
	}



}
