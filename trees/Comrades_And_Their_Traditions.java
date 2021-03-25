package trees;
import java.util.Stack;
import java.util.Scanner;
import java.util.Arrays;

/*
It's the year 2552, the Humans just won a war against a very powerful alien race that had invaded our solar system. The Human army is in celebration mode!
The army has n soldiers. The soldiers are numbers from 1 to n. The army has a superiority hierarchy. Every soldier has one immediate superior. The superior of a superior of a soldier is also a superior to that soldier. So, a soldier may have one or more superiors but only one immediate superior.
Every soldier has to congratulate every other soldier. For a pair of soldiers if one of them is the superior of the other, they will shake hands. Otherwise, they will bump their fists.
You are given the list of immediate superior of all soldiers, your job is to tell how many handshakes and fist bumps will be there. Print the count of handshakes and fist bumps.
NOTE: Among all soldiers, there is one soldier who does not have any superior. He is the commander of the whole army.
*/

public class Comrades_And_Their_Traditions {

	  public static void main(String args[]){
			
	        Scanner sc = new Scanner(System.in);
	        int testcases = sc.nextInt();
	        while(testcases > 0){
	            int n = sc.nextInt();
	            int[] nodes = new int[n + 1];
	            int[] height = new int[n+1];
	            Arrays.fill(nodes,-1);
	            Arrays.fill(height,-1);
	            for(int i = 0;i < n;i++){
	                int superior = sc.nextInt();
	               if(superior == 0){
	                   height[i] = 0;
	               }
	                nodes[i] = superior - 1;
	            }
	            calculate(height, nodes);
	            testcases--;
	        }
	    }
	    
	    private static void calculate(int[] height, int[] array){
	        long sumOfHeights = 0;
	        int length = height.length - 1;
	        for(int i = 0; i < height.length - 1; i++){
	            sumOfHeights += findHeight(i, height, array);
	        }
	        long fistBumps = ((long)(length) * (length - 1) / 2) - sumOfHeights;
	        System.out.println(sumOfHeights + " " + fistBumps);
	    }
	    
	    private static int findHeight(int i, int[] height, int[] array){
	        Stack<Integer> stack = new Stack<>();
	        int index = i;
	        int h = height[i];
	        while(h == -1){
	            stack.push(i);
	            i = array[i];
	            h = height[i];
	        }
	        
	        while(!stack.isEmpty()){
	            int k = stack.pop();
	            height[k] = ++h;
	        }
	        
	        return height[index];
	    }


}
