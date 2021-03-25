package sorting;

public class Quick_Sort {
	
	
	static int part(int[] array, int left, int right) {
		
		int pivot = array[left];
		int low = left+1;
		int high = right;
		
		while(low <= high) {
			
			while(low<=high && array[low] <= pivot) low++;
			while(low<=high && array[high] > pivot ) high--;
			
			if(low < high) {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high--;
			}
		}
		
		array[left] = array[low-1];
		array[low-1] = pivot;
		
		return low-1;
	}
	
	
	static void quick_sort(int array[],int left,int right) {
	
		if(left<right) {
			
			int partition = part(array,left,right);
			
			quick_sort(array,left,partition-1);
			quick_sort(array,partition+1,right);
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
			quick_sort(array,0,array_length-1);
			long finaltimemillis = System.currentTimeMillis();
			System.out.println("Time = " + (finaltimemillis-currenttimemillis));
			
			for(j=0;j<array_length;j++) {
				System.out.print(array[j]+" ");
			}
			
			System.out.println();
			
		}	
	}

}
