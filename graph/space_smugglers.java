package graph;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeSet;
/*
Nathan Reynolds is a famous smuggler and captain of a spaceship "Serenade".He was offered a potentially dangerous job on Ariel, one of the border planets of the 
star system. But to save all the "honest" earnings of the previous adventures, he decided to store them on one of the planets on the way to the border.

Star system is represented by  n planets and m space tunnels between them. Space tunnel is one-way wormhole to travel from one planet to another, requiring an amount of gravitonium to perform the gravity jump. There may be several space tunnels between two planets, but no space tunnel leads to the same planet it starts from.

Your task as a first officer is to find the minimum amount of gravitonium to travel from the base planet to Ariel, visiting some other planet to store the earnings, and return back to base, picking up the earnings on the way back.

Note, that storing the earnings in a base planet or the planet, where the job is taking place, is not allowed. But it's allowed to visit Ariel with the earnings as long as you are not doing a job on this planet.
*/
class Pair implements Comparable<Pair> {
    int id;
    long d;
    Pair(int u, long s) {
        id = u;
        d = s;
    }
    @Override
    public int compareTo(Pair p) {
        if (p.d == d)
            return Integer.compare(id, p.id);
        return Long.compare(d, p.d);
    }
}

class Edge2 {
    int u, v, w;
    Edge2(int x, int y, int z) {
        u = x;
        v = y;
        w = z;
    }
}

public class space_smugglers {
	private static final int BIG = 1_000_000_000; // to control integer overflow in addition
	
    static long[] dijkstra(int start, ArrayList<Edge2>[] edges){
    int n = edges.length;
    TreeSet<Pair> set = new TreeSet<>(); 
    Pair[] d = new Pair[n];
    for(int i = 0;i < n;i++){
        d[i] = new Pair(i, i!= start?BIG:0);
        set.add(d[i]);
    }
    while(!set.isEmpty()){
        Pair p = set.pollFirst();
        (edges[p.id]).stream().filter(e -> d[e.v].d > d[e.u].d + e.w).forEach(e -> {
            set.remove(d[e.v]);
            d[e.v].d = d[e.u].d + e.w;
            set.add(d[e.v]);
        } );
    }
    
    long[] res = new long[n];
    for(int i = 0;i < n;i++){
        res[i] = d[i].d;
    }
    return res;
}

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt();
    int t = sc.nextInt();
    s--;
    t--;
  	ArrayList<Edge2>[] edges = new ArrayList[n];
    ArrayList<Edge2>[] transpose = new ArrayList[n];
    for(int i = 0;i < n;i++){
        edges[i] = new ArrayList<>();
        transpose[i] = new ArrayList<>();
    }
    for(int i = 0;i < m;i++){
        int u = sc.nextInt(); u--;
        int v = sc.nextInt(); v--;
        int w = sc.nextInt();
        edges[u].add(new Edge2(u, v, w));
        transpose[v].add(new Edge2(v,u,w));
    }
    long[] d1 = dijkstra(s, edges);
    long[] d2 = dijkstra(t, transpose);
    long[] d3 = dijkstra(t, edges);
    long[] d4 = dijkstra(s, transpose);
    
    long ans = Long.MAX_VALUE;
    for(int i = 0;i < n;i++){
        if(i != s && i != t){
            if(d1[i] < BIG && d2[i] < BIG && d3[i] < BIG && d4[i] < BIG){ // control int overflow
            ans = Math.min(ans, d1[i] + d2[i] + d3[i] + d4[i]);
            }
        }
    }
    if(ans == Long.MAX_VALUE){
        System.out.println("-1");
    }else{
        System.out.println(ans);
    }
}
	

}
