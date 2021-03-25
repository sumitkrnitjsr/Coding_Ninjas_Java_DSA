package HashMap;

import java.util.HashMap;


/*
Given a random integer array A of size N. Find and print the pair of elements in the array which sum to 0.
Array A can contain duplicate elements.
While printing a pair, print the smaller element first.
That is, if a valid pair is (6, -6) print "-6 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
*/


public class Pair_Sum_To_Zero {
	
		public static void PairSum(int[] input, int size) {
		
        if(input == null || size < 2){
            return;
        }
        
        HashMap<Integer,Integer> presence = new HashMap<Integer,Integer>();
        
        for(int i=0; i<size;i++){
            
            int number = input[i];
            int reverse = number * -1;
     
        	if(presence.size() > 0 && presence.containsKey(reverse)){
                int value = presence.get(reverse);
                int min = (number>reverse)?reverse:number;
                int max = min * -1;
                while(value > 0){
                    System.out.println(min + " " + max);
                    value--;
                }

            }
       
            if(presence.size() > 0 && presence.containsKey(number)){
                int value = presence.get(number);
                value++;
                presence.put(number,value);
            }else{
                 presence.put(number,1);   
            }
                
        }
        
        
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, -2, 2, -2};
		PairSum(arr,4);

	}

}
