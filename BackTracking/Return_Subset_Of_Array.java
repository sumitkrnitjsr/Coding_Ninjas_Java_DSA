package BackTracking;

/*
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
*/


public class Return_Subset_Of_Array {

	 public static int[][] subsets(int[] input){
	        return subsets(input,0);
	    }
	    
	    public static int[][] subsets(int[] input, int index){
	        
	        if(index == input.length-1){
	            int[][] result = new int[1][1];
	            result[0][0] = input[index];
	            return result;
	        }
	        
	        int[][] smallAnswer = subsets(input,index+1);
	        
	        int[][] finalAnswer = new int[(smallAnswer.length*2)+1][];
	        
	        int i;
	        
	        for(i = 0;i < smallAnswer.length;i++){
	            finalAnswer[i] = new int[smallAnswer[i].length];
	            finalAnswer[i+smallAnswer.length] = new int[smallAnswer[i].length+1];
	            
	            for(int j = 0;j < smallAnswer[i].length;j++){
	            finalAnswer[i][j] = finalAnswer[i+smallAnswer.length][j+1] = smallAnswer[i][j];     
	            }
	            finalAnswer[i+smallAnswer.length][0] = input[index]; 
	        }
	        
	        finalAnswer[i+smallAnswer.length] = new int[1];
	        finalAnswer[i+smallAnswer.length][0] = input[index];
	        
	        
	        return finalAnswer;
	    }
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {13,9,3};
		int output[][] = subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}

	}

}
