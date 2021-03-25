package BackTracking;

/*
Given an array A and an integer K, print all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
*/

public class Print_Subset_Sum_K {
	
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
        
        int[] visited = new int[input.length];
		
        printSubsetsSumTok(input, k, 0, 0, visited);
	}
    
    
    public static void printSubsetsSumTok(int input[], int k, int sum,int index, int[] visited) {
        
        if(index == input.length){
            
            if(sum == k){
             print(visited,input,k);
            }
            
            return;
        }
        
        printSubsetsSumTok(input, k, sum, index+1, visited);
        
        visited[index] = 1;
        
        printSubsetsSumTok(input, k, sum+input[index], index+1, visited);
        
        visited[index] = 0;
        
    }
    
    public static void print(int[] visited,int[] input,int k){
        
        for(int i = 0;i < visited.length;i++){
            if(visited[i] == 1 && input[i] == k){
                System.out.print(input[i]);
            }else if(visited[i] == 1){
                System.out.print(input[i] + " ");
            }
        }
        
        System.out.println();
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5, 12, 3, 17, 1, 18, 15, 3, 17 };
		int k = 6;
		printSubsetsSumTok(input, k);

	}

}
