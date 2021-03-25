package graph;
import java.util.Vector;
import java.util.Scanner;

public class count_ways {

	static int dp[] = new int[200005];
	   static int mod = 1000000007;
	   static Vector<Vector<Integer>> adg = new Vector<>();
	    static Vector<Vector<Integer>> g = new Vector<>();
	    
	    static int recurse(int u) {
	    if(dp[u] != -1){
	    	return dp[u];
	    }
	    int sol = 1;
	    for(int i = 0;i< adg.get(u).size();i++) {
	    	sol = (recurse(adg.get(u).get(i)) + sol)%mod;
	    }
	    dp[u] = sol;
	    return sol;
	    }
	    
	    static int solve(int n,int m,int s,Vector<Vector<Integer>> g) {
	    	adg = g;
	    	for(int i = 1;i <=n;i++) {
	    		dp[i] = -1;
	    	}
	    	return recurse(s);
	    }
	    
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        for(int i = 0;i <= n;i++){
	            Vector<Integer> v = new Vector<>();
	            g.add(v);
	        }
	        for(int i = 0;i < m;i++) {
	        	int x,y;
	        	x = in.nextInt();
	        	y = in.nextInt();
	        	g.get(x).add(y);
	        }
	        int s = in.nextInt();
	        System.out.println(solve(n,m,s,g));
	    }
}
