package Two_Dimesional_Arrays;

public class Largest_Col_Sum {

	
	static int getLargestColumnSum(int[][] input) {
	
		int rows = input.length;
		int columns = input[0].length;
		int max = Integer.MIN_VALUE;
		
		for(int i=0 ; i<columns; i++) {
			int sum = 0;
			for(int j=0; j<rows; j++) {
				sum += input[j][i];
			}
			if(sum>max) {
				max = sum;
			}
		}
		
		return max;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array2D[][] = {{1,3,4,5},{2,4,3,5},{5,6,2,7},{9,2,2,4}};
		
		int sum  = getLargestColumnSum(array2D);
		System.out.println(sum);
	}

}
