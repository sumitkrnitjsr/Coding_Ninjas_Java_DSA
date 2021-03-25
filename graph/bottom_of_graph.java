package graph;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
/*
We will use the following (standard) definitions from graph theory. Let V be a non-empty and finite set, its elements being called vertices (or nodes). Let E be a subset of the Cartesian product V×V, its elements being called edges. Then G=(V,E) is called a directed graph.
Let n be a positive integer, and let p=(e1,…,en) be a sequence of length n of edges ei∈E such that ei=(vi,vi+1)for a sequence of vertices (v1,…,vn+1). Then p is called a path from vertex v1 to vertex vn+1 in G and we say that vn+1 is reachable from v1, writing (v1→vn+1).
Here are some new definitions. A node v in a graph G=(V,E) is called a sink, if for every node w in G that is reachable from v, v is also reachable from w. The bottom of a graph is the subset of all nodes that are sinks, i.e., bottom(G)={v∈V∣∀w∈V:(v→w)⇒(w→v)}. You have to calculate the bottom of certain graphs.
*/

public class bottom_of_graph {

    private static ArrayList<Integer> getCC(boolean[][] transpose, int v, boolean[] visited){
        visited[v] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(v);
        for(int i = 0;i < visited.length;i++){
            if(transpose[v][i] && !visited[i]){
            ArrayList<Integer> list = getCC(transpose, i, visited);
            ans.addAll(list);
        	}
        }
        return ans;
    }
    
    private static void fill(boolean[][] graph, int i, boolean[] visited, Stack stack){
        visited[i] = true;
        for(int j = 0;j < visited.length;j++){
            if(graph[i][j] && !visited[j]){
                fill(graph, j, visited, stack);
            }
        }
        stack.push(i);
    }
    private static void printScc(boolean[][] graph){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        for(int i = 0;i < graph.length;i++){
            if(!visited[i]){
                fill(graph, i,visited,stack);
            }
        }
        boolean[][] transpose = new boolean[graph.length][graph.length];
        for(int i = 0;i < visited.length;i++){
            for(int j = 0;j < visited.length;j++){
                if(graph[i][j]){
                    transpose[j][i] = true;
                }
            }
        }
        for(int i = 0;i < visited.length;i++){
            visited[i] = false;
        }
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        while(!stack.isEmpty()){
            Integer vp = stack.pop();
            int v = (vp == null)?0:vp;
            if(!visited[v]){
                ArrayList<Integer> list = getCC(transpose, v, visited);
                all.add(list);
            }
        }
        ArrayList<Integer> final_answer = new ArrayList<>();
        for(int k = 0;k < all.size();k++){
            boolean bottom = true;
            ArrayList<Integer> list = all.get(k); 
            for(Integer vertex:list){
                for(int i = 0;i < visited.length;i++){
                    if(graph[vertex][i] && !list.contains(i)){
                        bottom = false;
                        break;
                    }
                }
            }
            if(bottom){
                for(Integer itr:list){
                    final_answer.add(itr + 1);
                }
            }
        }
        Collections.sort(final_answer);
        for(Integer itr:final_answer){
            System.out.print(itr + " ");
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        while(v != 0){
            int e = sc.nextInt();
            boolean[][] graph = new boolean[v][v];
            for(int i = 0;i < e;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                x--;
                y--;
                graph[x][y] = true;
            }
            printScc(graph);
            v = sc.nextInt();
            System.out.println();
        }

	}

}