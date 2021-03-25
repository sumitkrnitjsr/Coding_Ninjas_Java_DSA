package Arrays;
import java.util.Scanner;

public class Maximum_In_Array {
	
	
	
	static int[] takeInput() {
		
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] input = new int[length];
		
		for(int i=0; i<length; i++) {
			input[i] = sc.nextInt();
		}
		
		return input;
	}
	
	static int findmax(int[] input) {
		int max = Integer.MIN_VALUE;
		int position = -1;
		for(int i=0;i<input.length;i++) {
			if(input[i] > max) {
				max = input[i];
				position = i;
			}
		}
		return position;
	}
	
	public static int sum(int[] arr) {
            int sum = 0;
            
            for(int i=0;i<arr.length;i++){
                sum += arr[i];
            }
        
        return sum;
	}
	
	 public static int linearSearch(int arr[], int x) {
			//Your code goes here
	        
	        for(int i=0; i<arr.length;i++){
	            
	            if(arr[i] == x) {
	                return i;
	            }
	        }
	        
	        return -1;
	  }
	 
	 
	 // 1 3 5 6 4 2  ----------  1 3 5 7 9 8 6 4 2
	 public static void arrange(int[] arr, int n) {
	    	//Your code goes here
	        
	        if( n==0 ){
	            return;
	        }
	        
	        int index = 1;
	        
	        int mid = arr.length/2;
	        
	        for(int i=0; i<mid; i++){
	            
	            arr[i] = index;
	            
	            index++;
	            
	            arr[arr.length-1-i] = index;
	            
	            index++;
	        }
	        
	        if(arr.length%2 != 0){
	            arr[mid] = index;
	        }
	        
	    }
	 
	 
	 public static void swapAlternate(int arr[]) {
	    	//Your code goes here
	        
	        for(int i=0; i<arr.length-1; i=i+2){
	            int temp = arr[i];
	            arr[i] = arr[i+1];
	            arr[i+1] = temp;
	            
	        }
	    }
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = takeInput();
		int position = findmax(array);
		
		if(position != -1) {
			System.out.print(array[position]);
		}
	}

}
