package graph;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
//  You want to plan a trip to a country with N cities and M bidirectional roads. But there is a special city called capital C, where you will land. But there is a restriction, you can only visit cities which are at most k distance from the capital. Can you count the number of cities that you can visit during your trip (including capital) ?
		

class Node implements Comparable<Node>{
    int vertex;
    int weight;
    public Node(){
        
    }
    public Node(int x, int y){
        vertex = x;
        weight = y;
    }
    
    public int compareTo(Node temp){
        return weight - temp.weight;
    }
}
public class Trip_to_cities {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        int k = in.nextInt();
        c--;
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(n);
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<Node>());
        }
        boolean[] visited = new boolean[n];
        for(int i = 0; i < m; i++) {
        	int x = in.nextInt();
        	int y = in.nextInt();
            int z = in.nextInt();
            if(z > k){
                continue;
            }
            graph.get(x-1).add(new Node(y-1, z));
      		graph.get(y-1).add(new Node(x-1, z));
        }
        

        int[] distance = new int[n];
        for(int i = 0;i < n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[c] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n);	
        pq.add(new Node(c, 0));
        int count = 0;
        int cnt_v = 0;
        while(!pq.isEmpty() && cnt_v < n){   // important cnt_v < n
            Node top = pq.poll();
            int minIndex = top.vertex; 
            if(distance[top.vertex] > k){
                break;
            }
            if(!visited[minIndex]){
                visited[minIndex] = true;
                count++;
                cnt_v++;
            }else{
                continue;  // important
            }
            
            ArrayList<Node> nbr = graph.get(minIndex);
            for(Node temp : nbr){
            if(!visited[temp.vertex]){
                int dist = Integer.MAX_VALUE;
                if(distance[minIndex] != Integer.MAX_VALUE){
                	dist = distance[minIndex] + temp.weight;
                }
                if(dist < distance[temp.vertex]){
                    distance[temp.vertex] = dist;
                }
                pq.add(new Node(temp.vertex, distance[temp.vertex]));
            	}
            }
        }
        
        System.out.println(count);
    }
}