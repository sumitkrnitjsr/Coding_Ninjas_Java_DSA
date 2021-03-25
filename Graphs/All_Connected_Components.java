package Graphs;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
//  Given an undirected graph G(V,E), find and print all the connected components of the given graph G.



public class All_Connected_Components {
    
    private static void connectedComponent(boolean[][] graph,boolean[] visited, int vertex){
        visited[vertex] = true;
        for(int i = 0;i < graph.length;i++){
            if(!visited[i] && graph[vertex][i]){
            	connectedComponent(graph, visited, i);
            } 
        }
     }

    private static ArrayList<ArrayList<Integer>> connectedComponents(boolean[][] graph){
        if(graph.length == 0){
            return null;
        }
        
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        for(int i = 0;i < graph.length;i++){
            boolean[] temp = new boolean[visited.length];
            if(!visited[i]){
               connectedComponent(graph, temp, i);
            	ArrayList<Integer> list = new ArrayList<>();
                for(int j = 0;j < temp.length;j++){
                    if(temp[j]){
                        list.add(j);
                        visited[j] = true;
                    }
                }
                result.add(list);
            }
        }
        return result;
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
        ArrayList<ArrayList<Integer>> list = connectedComponents(graph);
        if(list != null && list.size() > 0){
        for(ArrayList<Integer> l: list){
            Collections.sort(l);
            for(Integer itr:l){
                System.out.print(itr + " ");
            }
            System.out.println();
        	}
        }
	}

}