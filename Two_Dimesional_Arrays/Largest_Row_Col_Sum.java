package Two_Dimesional_Arrays;

// For a given two-dimensional integer array/list of size (N x M), you need to find out which row or column has the largest sum(sum of all the elements in a row/column) amongst all the rows and columns.

public class Largest_Row_Col_Sum {
	
	public static void findLargest(int mat[][]){
		//Your code goes here
        
        if(mat.length == 0 || mat[0].length == 0){
            System.out.println("row" + " " + "0" + " " +"-2147483648");
            return;
        }
        
        int rows = mat.length;
        int columns = mat[0].length;
        int max = -2147483648;
        int position = -1;
        String direction = "row";
        
        for(int i=0; i<rows;i++){
            int sum = 0;
            for(int j=0; j<columns; j++){
                sum += mat[i][j];
            }
            if(sum > max){
                max = sum;
                position = i;
            }
            
        }
        
        for(int i=0; i<columns; i++){
            int sum = 0;
            
            for(int j=0; j<rows;j++){
                sum += mat[j][i];
            }
            
            if( sum > max){
                max  = sum;
                position = i;
                direction = "column";
            }
        }
        
        if(max != -2147483648){
            System.out.println(direction + " " + position + " " + max);
        }else {
            System.out.println("row" + " " + "0" + max);
        }
        
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array2D[][] = {{1,3,4,5},{2,4,3,5},{5,6,2,7},{9,2,2,4}};
		
		findLargest(array2D);
		
	}

}
