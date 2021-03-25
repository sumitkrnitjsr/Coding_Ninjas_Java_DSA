package dynamic_programming_2;

// Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.

public class maximum_subsqaure_with_zero {
	
public static int findMaxSquareWithAllZeros(int[][] input){
        
        if(input.length == 0 || input[0].length == 0){
            return 0;
        }
        
        int[][] storage = new int[input.length][input[0].length];
        int max = 0;
        
        for(int i = 0;i < input.length;i++){
            if(input[i][0] == 0){
                storage[i][0] = 1;
                max = 1;
            }else{
                storage[i][0] = 0;
            }
        }
        
        for(int i = 0;i < input[0].length;i++){
            if(input[0][i] == 0){
                storage[0][i] = 1;
                max = 1;
            }else{
                storage[0][i] = 0;
            }
        }
        
        for(int i = 1;i < input.length; i++){
            for(int j = 1;j < input[0].length; j++){
                if(input[i][j] == 1){
                    storage[i][j] = 0;
                    continue;
                }
                storage[i][j] = 1 + Math.min(storage[i-1][j-1], Math.min(storage[i-1][j], storage[i][j-1]));
                max = (storage[i][j] > max)?storage[i][j]:max;                
            }
        }

        return max;
	
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
