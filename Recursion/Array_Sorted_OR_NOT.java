package Recursion;

public class Array_Sorted_OR_NOT {

	
	static boolean checkSorted(int[] input) {
	
		if(input.length <= 1) {
			
			return true;
			
		}
		
		
		int[] smallinput = new int[input.length-1];
		
		for(int i=1; i<input.length; i++) {
			smallinput[i-1] = input[i];
		}
		
		
		boolean smallAns = checkSorted(smallinput);
		
		if(!smallAns) {
			return smallAns;
		}
		
		if(input[0] <= input[1]) {
			return true;
		}else {
			return false;
		}
	
	}
	
	static boolean checkSorted_2(int[] input) {
		
		if(input.length <= 1) {
			
			return true;
			
		}
		
		if(input[0] > input[1]) {
			return false;
		}
		
		int[] smallinput = new int[input.length-1];
		
		for(int i=1; i<input.length; i++) {
			smallinput[i-1] = input[i];
		}
		
		return checkSorted_2(smallinput);
	}
		
	
	static boolean checkSorted_better(int[] input, int index) {
		
		if(index == input.length -1) {
			return true;
		}
		
		if(input[index] > input[index+1]) {
			return false;
		}
		
		return checkSorted_better(input, index+1);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {2, 1, 3, 6, 7};
		int[] array_1 = { 1,2, 3, 6, 7};
		
		checkSorted_better(array,0);
		
		boolean result = checkSorted_better(array,0);
			System.out.println(result);
	}

}
