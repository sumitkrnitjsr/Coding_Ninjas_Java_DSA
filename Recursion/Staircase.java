package Recursion;


// A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return number of possible ways W.

public class Staircase {

	 public static int staircase(int n){
			
			/* Your class should be named Solution.
			 * Don't write main() function.
			 * Don't read input, it is passed as function argument.
			 * Return output and don't print it.
			 * Taking input and printing output is handled automatically.
			 */

		      if(n < 0){
		          return 0;
		      }  
		    
		         if(n == 0){  // Could not predict this. Tricky base case
		             return 1;
		         }
		         
		         if( n < 3){
		             return n;
		         }
		         
		        int smallAns = 0;
		         
		         smallAns += staircase(n-1);
		         smallAns += staircase(n-2);
		         smallAns += staircase(n-3);
		         
		         return smallAns;
			}
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(staircase(2));

	}

}
