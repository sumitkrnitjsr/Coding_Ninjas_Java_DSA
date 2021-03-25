package Two_Dimesional_Arrays;

public class Jagged_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arrayJagged2D = new int[4][];
		
		System.out.println(arrayJagged2D);
		
		System.out.println(arrayJagged2D[0]);
		
		System.out.println( arrayJagged2D.length);
		
		
		
		for(int i=0; i<arrayJagged2D.length; i++) {
			
			arrayJagged2D[i] = new int[i + 1];
			
			System.out.println(arrayJagged2D[i]);
		}
		
		for(int i=0; i<arrayJagged2D.length; i++) {
			
			for(int j=0; j<arrayJagged2D[i].length; j++) {
				
				System.out.print(arrayJagged2D[i][j] + " ");
			}
			
			System.out.println();
		}

	}

}
