package graph;
import java.util.Scanner;
/*
In DELHI, there are N junctions connected by M bi-directional roads. There is at most one road between any pair of junctions. There is no road connecting a junction to itself. The travel time for a road is the same in both directions.
At every junction there is a single traffic light. Starting from time 0, each light flashes green once every T time units, where the value of T is different for each junction.
A vehicle that is at a junction can start moving along a road only when the light at the current junction flashes green. If a vehicle arrives at a junction between green flashes, it must wait for the next green flash before continuing in any direction. If it arrives at a junction at exactly the same time that the light flashes green, it can immediately proceed along any road originating from that junction.
You are given a city map that shows travel times for all roads. For each junction i, you are given Ti, the time period between green flashes of the light at that junction. The light at junction i flashes green at times 0, Ti, 2Ti, 3Ti, ...
Your task is to find and print the minimum time taken from a given source junction to a given destination junction for a vehicle when the traffic starts. The junctions are identified by integers 1 through N
*/



public class delhi_traffic {

    private static int find(int[] t,boolean[] visited,int n){
        int min = -1;
        for(int i = 0;i < n;i++){
            if(!visited[i] && ((min == -1) || (t[min] > t[i]))){
                min = i;
            }
        }
        return min;
    }
    
    private static void route(int[][] graph, int n,int time[], int src,int dest,int[] t){
        
        boolean[] visited = new boolean[n];
        t[src] = 0;
        for(int i = 0;i < n;i++){
            int min = find(t, visited, n);
            visited[min] = true;
            for(int j = 0;j < n;j++){
                if(graph[min][j] != 0 && !visited[j]){
                    if(j != dest){
                        int current_time = t[min] + graph[min][j];
                        int wait = current_time%time[j];
                        if(wait != 0){
                            wait = time[j] - wait;
                        }
                        current_time += wait;
                        if(current_time < t[j]){
                            t[j] = current_time;
                        }
                    }else{
                        int current_time = t[min] + graph[min][j];
                        if(current_time < t[j]){
                            t[j] = current_time;
                        }
                    }
                }
            }
        }
    
    }
    
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] time = new int[n];
        for(int i = 0;i < n;i++){
            time[i] = in.nextInt();
        }
        int[][] graph = new int[n][n];
        for(int i = 0;i < m;i++){
            int s = in.nextInt();
            int d = in.nextInt();
            int w = in.nextInt();
            s--;
            d--;
            graph[s][d] = graph[d][s] = w;
        }
        int src = in.nextInt();
        src--;
        int dest = in.nextInt();
        dest--;
        int t[] = new int[n];
        for(int i = 0;i < n;i++){
            t[i] = Integer.MAX_VALUE;
        }
        route(graph, n, time, src,dest,t);
        System.out.println(t[dest]);
    }
}

