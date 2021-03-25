package Graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	
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
        boolean visited[] = new boolean[vertices];
        for(int i = 0;i < vertices;i++){
            if(!visited[i]){
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int vertex = queue.poll();
                    System.out.print(vertex + " ");
                    // Wrong Placement visited[vertex] = true;
                    for(int j = 0;j < vertices;j++){
                        if(!visited[j] && graph[vertex][j]){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
	}


}
