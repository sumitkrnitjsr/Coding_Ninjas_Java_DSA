package binary_trees;
import java.util.Scanner;
/*
You are given a Binary tree T and an integer K. Input binary Trees T is consisting of N (numbered from 1 to N) nodes rooted at node 1 and each node has a number written on it, where the number written on the ith node is A[i].
Now, Rahul needs to find the number of unordered triplets (i,j,k), such that node i is an ancestor of node j as well as node k, and A[i]+A[j]+A[k]>=K
A node x is considered an ancestor of another node y, if x is parent of y or x is an ancestor of parent of y.
*/

public class Rahul_Counting_Trees {
	
	 public static void main(String args[]){
	        long sum;  // didn't use long variable, had wrong answer
	        int n;
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        sum = sc.nextLong();
	        long[] array = new long[n + 1];
	        long[] parent = new long[n + 1];
	        for(int i = 1;i <= n;i++){
	            array[i] = sc.nextLong();
	        }
	        
	        for(int i = 2;i <= n;i++){
	            parent[i] = sc.nextLong();
	            
	        }
	        
	        boolean ancestor[][] = new boolean[n + 1][n + 1];
	        for(int i = 0;i <= n;i++){
	            for(int j = 0;j <= n;j++){
	                ancestor[i][j] = false;
	            }
	        }
	        
	        long root = 1;
	        for(int i = 2;i <= n;i++){
	            int node = i;
	            while(node != root){
	                node = (int)parent[node];
	                ancestor[node][i] = true;
	            }
	        }
	        
	        long ans = 0;
	        
	        for(int i = 1;i <= n;i++){
	            for(int j = 1;j <= n;j++){
	                for(int k = 1;k <= n;k++){
	                    if(i != j && j != k && i != k && ancestor[i][k] && ancestor[i][j] && (array[i] + array[j] + array[k] >= sum)){
	                        ans++;
	                    }
	                }
	            }
	        }
	        ans = (ans/2l);
	        System.out.print(ans);
	    }
	 

}
