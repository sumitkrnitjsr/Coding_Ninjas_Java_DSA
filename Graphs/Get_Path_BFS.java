package Graphs;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/*
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
*/

public class Get_Path_BFS {
	
	public static void main(String[] args)  throws NumberFormatException, IOException{
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
        
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[] = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        if(start == end){
            System.out.println(start);
            return;
        }
        queue.add(start);
        visited[start] = true;
        boolean found = false;
        while(!queue.isEmpty() && !found){
            int front = queue.poll();
            if(front ==  end){
                found = true;
                break;
            }
            for(int i = 0;i < graph.length;i++){ // i == 0 is wrong initialization
                if(!visited[i] && graph[front][i]){
                    map.put(i, front); // map.put(front, i); is wrong
                    queue.add(i);
                    visited[i] = true; // fogot visited
                }
            }
        }
        
        if(found){
            Integer temp = end;
            while(temp != null && temp.intValue() != start){
                System.out.print(temp + " ");
                temp = map.get(temp);
            }
            System.out.print(start);
        }
	}
}