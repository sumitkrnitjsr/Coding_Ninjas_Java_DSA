package BackTracking;


/*
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
*/



public class Print_Subsets_Of_Array {
	
	public static void printSubsets(int input[]) {
		// Write your code here
        int[] visited = new int[input.length];

        printSubsets(input, 0, visited);
	}
    
    
    public static void printSubsets(int[] input, int index, int[] visited){
        
        if(index == input.length){
            for(int i = 0;i < visited.length;i++){
                if(visited[i] == 1){
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        
        visited[index] = 1;
        printSubsets(input,index+1,visited);
        
        visited[index] = 0;
        printSubsets(input,index+1,visited);
        
        
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {15,20,12};
		printSubsets(input);

	}

}
