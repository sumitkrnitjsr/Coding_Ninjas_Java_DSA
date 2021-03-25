package HashMap;
import java.util.Arrays;
import java.util.HashMap;
/*
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the first sorted array/list(ARR1).
*/

public class Print_Intersection {
	
	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
        
        if(arr1 == null || arr2 == null || arr1.length < 1 || arr2.length < 1){
            return;
        }
        
        Arrays.sort(arr1);
        
        HashMap<Integer,Integer> presence = new HashMap<Integer, Integer>();
        
        
        for(int i=0; i<arr2.length; i++){
            
            if(presence.size()>0 && presence.containsKey(arr2[i])){
                int value = presence.get(arr2[i]);
                value++;
                presence.put(arr2[i],value);
            }else {
                
                presence.put(arr2[i],1);
            }
            
        }
        
        
        for(int i=0; i<arr1.length; i++){
        	
            if(presence.size() > 0 && presence.containsKey(arr1[i]) && presence.get(arr1[i]) > 0){
                System.out.print(arr1[i] + " ");
                int value = presence.get(arr1[i]);
                value--;
                presence.put(arr1[i],value);
            }
            
            
        }
        
        
        
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[] = {2, 6, 1, 2};
		int arr2[] = {1, 2, 3, 4, 2};
		
		intersection(arr1,arr2);

	}

}
