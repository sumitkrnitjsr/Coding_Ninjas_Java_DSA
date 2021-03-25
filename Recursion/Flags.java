package Recursion;

/*
A flag can consists of only three different colors of stripes, White(W), Blue(B) and Red(R). Given an integer N, find and return the number of ways to create such flags having N stripes consisting of these three color stripes only with the following constraints -
1. Stripes of the same color cannot be placed next to each other.
2. A blue stripe must always be placed between a white and a red or between a red and a white one. Hence blue stripe cannot be placed at starting or at ending.
3. Its not necessary to use all three colors.
*/

public class Flags {
	
	 static long find_Ways(int N, String result){
	        
	        if(N < 0){ // if(N < 1){  Wrong base case
	            return 0;
	        }
	        
	        if(N  == 0){ // if(result.length() == N){  Wrong base case
	            return 	1;
	        }
	        
	        char last_flag = ' ';
	        if(result.length() > 0){
	            last_flag = result.charAt(result.length()-1);;
	        }
	        
	        long count = 0;
	        String temp = "";
	        switch(last_flag){
	                
	            case 'W' : 
	                temp = result + "R";
	                count = count + find_Ways(N-1, temp);
	                temp = result + "BR";
	                count = count + find_Ways(N-2, temp);
	                break;
	                
	            case 'R' :
	                temp = result + "W";
	                count = count + find_Ways(N-1, temp);
	                temp = result + "BW";
	                count = count + find_Ways(N-2, temp);
	                break;
	                
	            default :
	                temp = result + "W";
	                count = count + find_Ways(N-1, temp);
	                temp = result + "R";
	                count = count + find_Ways(N-1, temp);
	                break;
	                
	        }
	        
	        return count;
	        
	    }

		public static long find_Ways(int N)
		{
	        /* Your class should be named Solution
			 * Don't write main().
			 * Don't read input, it is passed as function argument.
			 * Return output and don't print it.
		 	 * Taking input and printing output is handled automatically.
			 */
			return find_Ways(N,"");
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(find_Ways(3));

	}

}
