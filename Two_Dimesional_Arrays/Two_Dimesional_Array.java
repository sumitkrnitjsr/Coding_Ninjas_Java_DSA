package Two_Dimesional_Arrays;

public class Two_Dimesional_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array2D[][] = {{1,3,4,5},{2,4,3,5},{5,6,2,7}};
		
		System.out.println(array2D.length);
		
		System.out.println(array2D[0].length);
		
		System.out.println(array2D);
		for(int i=0; i<array2D.length; i++) {
			System.out.print(array2D[i] + "  ");
		}
		
		System.out.println();
		array2D[1] = new int[20];
		System.out.println(array2D[1]);
		System.out.println(array2D[1].length);
	}

}
