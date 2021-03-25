package Arrays_Strings_Assignment;

public class Leaders_In_Array {

	
	
	
	static void leaders(int[] array) {
		
		if(array == null || array.length == 0) {
		
			return;
		}

		int[] maximum = new int[array.length];
		
		int max = maximum[array.length-1] = array[array.length-1];
		
		for(int i = array.length-2; i>=0; i--) {
		
			if(array[i] >= max) {
				max = array[i];
			}
			
			maximum[i] = max;
		}
		
		for(int i=0; i<array.length; i++) {
			
			if(array[i] == maximum[i]) {
				System.out.print(array[i] + " ");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {3, 12, 34, 2, 0, -1};
		
		leaders(array);

	}

}
