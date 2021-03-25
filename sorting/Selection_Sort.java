package sorting;

public class Selection_Sort {
	
	
	static void selection_sort(int[] array, int length) {
		
		int i,j,min,temp;
		
		for(i=0;i<length-1;i++) {
			
			min = i;
			for(j=i+1;j<length;j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			
			temp = array[min];
			array[min] = array[i];
			array[i] = temp;
			
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
			selection_sort(array,array_length);
			long finaltimemillis = System.currentTimeMillis();
			System.out.println("Time = " + (finaltimemillis-currenttimemillis));
			
			for(j=0;j<array_length;j++) {
				System.out.print(array[j]+" ");
			}
			
			System.out.println();
			
		}
		
		
	}

}
