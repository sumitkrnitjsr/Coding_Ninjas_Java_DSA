package Two_Dimesional_Arrays;

public class Spiral_Matrix_Print {
	
	
	static void spiralPrintRecursive(int[][] array, int left, int right, int top, int bottom) {
		
	
		if(left > right || top > bottom) {
			return;
		}
		
		
		for(int i=left; i<= right; i++) {
			System.out.print(array[top][i] + " ");
		}
		
		for( int i=top+1; i<=bottom; i++ ) {
			System.out.print(array[i][right] + " ");
		}
		
		
		if( top != bottom) { // Forgot to check if there is only one row
		for( int i = right-1; i>=left; i--) {
			System.out.print(array[bottom][i] + " ");
		}
		}
		
		if(left != right) { // Forgot to check if there is only one column
		for(int i=bottom-1; i>=top+1; i--) {
			System.out.print(array[i][left] + " ");
		}
		}
		
		spiralPrintRecursive(array, left+1, right-1, top+1, bottom-1);
	}
	
	static void spiralPrint(int[][] array2D) {
		
		int rows = array2D.length;
		int columns = array2D[0].length;
		
		spiralPrintRecursive(array2D, 0, columns-1, 0, rows-1);
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array2D[][] = {{1,3,4,5},{2,4,3,5},{5,6,2,7},{9,2,2,4}};
		int ar[][] = {{9,54},{33,58},{88,45},{57,9},{95,98},{14,53},{46,65},{71,54},{52,2},{77,67}};
		
		spiralPrint(ar);
	}

}
