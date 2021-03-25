package HashMap;

import java.util.HashMap;abstract

/*
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
*/



public class Maximum_Frequency_Number {
	
	public static int maxFrequencyNumber(int[] arr){

        
        if(arr == null || arr.length < 1){
            return 0;
        }
        
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        
        int max_number = arr[0]; //Forgot initialization
        int max_occurrence = 1;  //Forgot initialization
        frequency.put(arr[0],1); //Forgot initialization
        
        for(int i=1; i<arr.length;i++){
            
            if(frequency.size() > 0 && frequency.containsKey(arr[i])) { // forgot to check for size
                int value = frequency.get(arr[i]);
                value++;
                frequency.put(arr[i],value);
                if(value > max_occurrence){
                    max_occurrence = value;
                    max_number = arr[i];
                }
                
            }else {
                frequency.put(arr[i],1); // wrote wrong frequency frequency.put(arr[i],0);
            }
            
        }
		return max_number;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6 };
		
		int result = maxFrequencyNumber(arr);
		
		System.out.println(result);
		
	}

}
