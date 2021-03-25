package Two_Dimesional_Arrays;

public class ROW_WISE_SUM {

	public static void rowWiseSum(int[][] mat) {
		//Your code goes here
        
        if(mat.length == 0 || mat[0].length == 0){
            return;
        }
		
        int total_rows = mat.length;
        int total_columns = mat[0].length;
  
 		for(int i=0; i<total_rows; i++){
            int sum = 0;
            for(int j=0; j<total_columns; j++){
                sum += mat[i][j];
            }
            System.out.print(sum + " ");
            
        }
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,2,3},{2,3,4}};
		rowWiseSum(arr);

	}

}
