package Two_Dimesional_Arrays;

// For a given two-dimensional integer array/list of size (N x M), print the array/list in a sine wave order, i.e, print the first column top to bottom, next column bottom to top and so on.


public class Matrix_Wave_Print {
	
	public static void wavePrint(int mat[][]){
		//Your code goes here
        
        if(mat.length == 0 || mat[0].length == 0){ //Forgot Base Cases
            return;
        }
        
        int rows = mat.length;
        int columns = mat[0].length;
        
        for(int i=0; i<columns; i++){
            boolean toptobottom = (i%2)==0;
            if(toptobottom){
                for(int j=0; j<rows;j++){
                    System.out.print(mat[j][i] + " ");
                }
            }else{
                
                for(int j=rows-1; j>=0; j--){
                    System.out.print(mat[j][i] + " ");
                }
            }
        }
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array2D[][] = {{1,3,4,5},{2,4,3,5},{5,6,2,7},{9,2,2,4}};
		
		
		
		wavePrint(array2D);

	}

}
