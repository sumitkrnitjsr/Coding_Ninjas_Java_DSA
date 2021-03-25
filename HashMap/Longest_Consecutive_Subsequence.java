package HashMap;

import java.util.HashMap;
import java.util.ArrayList;
/*
You are given an array of unique integers that contain numbers in random order. Write a program to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
Best solution takes O(n) time.
If two sequences are of equal length then return the sequence starting with the number whose occurrence is earlier in the array.
*/		
		
		
		
public class Longest_Consecutive_Subsequence {
	
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		//Your Code goes here
        HashMap<Integer, Boolean> track = new HashMap<Integer, Boolean>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(arr == null || arr.length < 1){
            return result;
        }
        
		
        for(int i=0; i<arr.length; i++){
            track.put(arr[i],false);
        }
        
        
        int max_length = 0;
        int begin = -1;
        int position_begin = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++){
            
            int number = arr[i];
            int length_count = 0;
            
            if(track.get(number)){
                continue;
            }
            
            track.put(number,true);
            length_count = 1;
            number++;
            
            while(track.containsKey(number) && !track.get(number)){
                length_count++;
                track.put(number,true); //forgot to mark visited
                number++;
            }
            
            number = arr[i];
            
            number--;
            
            while(track.containsKey(number) && !track.get(number)) {
            	length_count++;
                track.put(number,true);
                number--;
            }
            
            if(length_count > max_length ){
                max_length = length_count;
                begin = number+1;
                int local_begin_position = i;;
                for(int itr=0; itr<arr.length; itr++){
                    if(arr[itr] == number+1){
                        local_begin_position = itr;
                        break;
                    }
                }
                position_begin = local_begin_position;
            }else if(length_count == max_length) {
                int local_begin_position = i;;
                for(int itr=0; itr<arr.length; itr++){
                    if(arr[itr] == number+1){
                        local_begin_position = itr;
                        break;
                    }
                }
                if(local_begin_position < position_begin){
                max_length = length_count;
                begin = number+1;
                position_begin = local_begin_position;
                }
            }
            
        }
        
        
        for(int i = begin; i<begin+max_length; i++){
            result.add(i);
        }
        
        return result;
        
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {11, 13, 14, 5, 4, 12, 6, 8, 10, 7};
		ArrayList<Integer>  result = longestConsecutiveIncreasingSequence(arr);
		for(Integer r : result) {
			System.out.println(r);
		}

	}

}
