package Arrays;

public class Pass_By_Value_VS_Reference {
	
	static void incrementPrimitive(int i) {
		i++;
	}
	
	static void incrementNonPrimitive(int[] array) {
		
		for(int i=0;i<array.length;i++) {
			array[i]++;
		}
		System.out.println("increment Function array = " + array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 10;
		incrementPrimitive(number);
		System.out.println("after increment primitive = " + number);
		
		int[] array = {1,2,3,4,5};
		incrementNonPrimitive(array);
		
		System.out.println("main array = " + array);
		
		for(int i =0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		boolean[] array_b = {false,true};
		char[] array_c = {'a','b'};
		float[] array_f = new float[10];
		double[] array_d = new double[20];
		
		System.out.print(array_b + " " + array_c + " " + array_f + " " + array_d) ;

	}

}
