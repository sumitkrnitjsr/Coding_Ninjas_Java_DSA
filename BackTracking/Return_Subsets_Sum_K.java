package BackTracking;

/*
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
*/

public class Return_Subsets_Sum_K {
	
	// Return a 2D array that contains all the subsets which sum to k
		public static int[][] subsetsSumK(int input[], int k) {
			// Write your code here
	        int[] visited = new int[input.length];
	        return subsetsSumK(input, k, 0, 0,visited);
		}
	    
	    
	    public static int[][] subsetsSumK(int input[],int k, int index,int sum,int[] visited){
	        
	        if(index == input.length){
	            
	            int[][] result = new int[0][0];
	            
	            if(sum == k){
	               result = new int[1][0]; 
	               createResult(visited,result,input);
	            }            
	            return result;
	    
	        }


	     
	        int[][] smallAnswer_1 = subsetsSumK(input, k, index+1, sum, visited);
	        int[][] smallAnswer_2 = new int[1][0];
	        
	        if(input[index] + sum <= k){
	            visited[index] = 1;
	            smallAnswer_2 = subsetsSumK(input, k, index+1, (sum + input[index]), visited);
	            visited[index] = 0;
	        }
	        
	        int total_size = smallAnswer_1.length + smallAnswer_2.length;
	        
	        int[][] final_answer = new int[total_size][];
	        
	        int itr = 0;
	        
	        for(int i = 0;i < smallAnswer_1.length;i++,itr++){
	            final_answer[itr] = new int[smallAnswer_1[i].length];
	            for(int j = 0;j < smallAnswer_1[i].length;j++) {
	                final_answer[itr][j] = smallAnswer_1[i][j];
	            }
	            
	        }
	        
	        for(int i = 0;i < smallAnswer_2.length;i++,itr++){
	            final_answer[itr] = new int[smallAnswer_2[i].length];
	            for(int j = 0;j < smallAnswer_2[i].length;j++) {
	                final_answer[itr][j] = smallAnswer_2[i][j];
	            }
	            
	        }
	        
	        return final_answer;
	    }
	    
	    
	    
	    public static void createResult(int[] visited,int[][] result,int[] input){
	    
	        int count = 0;
	        for(int i = 0;i < visited.length;i++){
	            if(visited[i] == 1){
	                count++;
	            }
	        }
	        
	        result[0] = new int[count];
	        int k = 0;
	        for(int i = 0;i < visited.length;i++){
	            if(visited[i] == 1){
	                result[0][k] = input[i];
	                k++;
	            }
	        }
	    }
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5, 12, 3, 17, 1, 18, 15, 3, 17 };
		int k = 6;
		int output[][] = subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}

	}

}
