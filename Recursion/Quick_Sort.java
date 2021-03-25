package Recursion;

public class Quick_Sort {
	
	   static int partition(int[] input, int startIndex, int endIndex) {
		    
	        int pivot = input[startIndex];
	        int left = startIndex;
	        int right = endIndex;
	        
	        while(left <= right){ // made wrong comparison, used ">" instead of "<"
	            
	            while(left <= endIndex && input[left]  <= pivot){ //forgot boundary checks
	                left++;
	            }
	            
	            while(right >= startIndex && input[right] > pivot){ //forgot boundary checks
	                right--;
	            }
	            
	            if(left < right){ // made wrong comparison, used ">" instead of "<"
	                int temp = input[left];
	                input[left] = input[right];
	                input[right] = temp;
	            }
	            
	            
	        }
	        
	 		int temp = input[left-1]; 
	        input[left-1] = pivot;
	        input[startIndex] = temp;
	        
	        return left-1;
	    }
	    
	    
	    
	    static void quickSort(int[] input, int startIndex, int endIndex) {
	        
	        if(startIndex >= endIndex){
	            return;
	        }
	        
	        int pivot = partition(input, startIndex, endIndex);
	        
	        quickSort(input, startIndex, pivot-1);
	        quickSort(input, pivot+1, endIndex);
	    }
	    
	    
		public static void quickSort(int[] input) {
			/* Your class should be named Solution
			 * Don't write main().
			 * Don't read input, it is passed as function argument.
			 * No need to print or return the output.
			 * Taking input and printing output is handled automatically.
			 */
	        
	        quickSort(input, 0, input.length-1);
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {8,7,5,4,3};
		quickSort(input);
		for(int i=0; i<input.length;i++) {
			System.out.println(input[i]);
		}

	}

}
