package sorting;

public class Merge_Sort {
	
	
	
	
	static void merge(int[] array, int left, int mid, int right) {
	
		int l1 = mid-left+1;
		int l2 = right-mid;
		int[] array1 = new int[l1];
		int[] array2 = new int[l2];
		
		int index = 0;
		for(int i=left;i<=mid;i++) {
			array1[index] = array[i];
			index++;
		}
		
		index = 0;
		
		for(int i=mid+1;i<=right;i++) {
			array2[index] = array[i];
			index++;
		}
		
		index = left;
		int index1 = 0;
		int index2 = 0;
		while(index1 < l1 && index2<l2) {
			
			if(array1[index1] < array2[index2]) {
				array[index] = array1[index1];
				index1++;
			}else {
				array[index] = array2[index2];
				index2++;
			}
			
			index++;
		}
		
		while(index1 < l1) {
			array[index] = array1[index1];
			index++; index1++;
		}
		
		while(index2 < l2) {
			array[index] = array2[index2];
			index++; index2++;
		}
		
		
	}
	
	
	
	
	static void merge_sort(int[] array, int left, int right) {
		
		if(left<right) {
			
			int mid = (left+right)/2;
			merge_sort(array,left,mid);
			merge_sort(array,mid+1,right);
			merge(array,left,mid,right);
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
			merge_sort(array,0,array_length-1);
			long finaltimemillis = System.currentTimeMillis();
			System.out.println("Time = " + (finaltimemillis-currenttimemillis));
			
			for(j=0;j<array_length;j++) {
				System.out.print(array[j]+" ");
			}
			
			System.out.println();
			boolean arr[] = new boolean[5];
			System.out.print(arr[0]);
			
		}	
	}

}
