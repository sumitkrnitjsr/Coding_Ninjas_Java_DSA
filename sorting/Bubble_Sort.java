package sorting;

public class Bubble_Sort {
	
	
	
		static void bubble_sort(int[] array, int n) {
			
			int i,j,temp;
			
			for(i=0; i<n-1; i++) {
				
				for(j=0;j<n-i-1;j++) { // Error for(j=i;j<n-1;j++) { forgot to handle sorted indices and start of j
					
					if(array[j] > array[j+1]) {
						temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
					
				}
				
			}
			
		}
	
	
	
		public static void main(String[] args) {
	
		int array_length,i,j,max,min;
		
		min=10;
		max = 100;
		
		for(array_length=min; array_length<=max; array_length=array_length*10) {
		
			int[] array = new int[array_length];
			
			for(i=0;i<array_length;i++) {
				array[i] = array_length-i;
			}
			
			for(j=0;j<array_length;j++) {
				System.out.print(array[j]+" ");
			}
			
			
			long currenttimemillis = System.currentTimeMillis();
			bubble_sort(array,array_length);
			long finaltimemillis = System.currentTimeMillis();
			System.out.println("Time = " + (finaltimemillis-currenttimemillis));
			
			for(j=0;j<array_length;j++) {
				System.out.print(array[j]+" ");
			}
			
			System.out.println();
			
		}	
	}

}
