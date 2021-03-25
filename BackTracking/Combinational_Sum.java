package BackTracking;

import java.util.*;

/*
Given an array of integers A and an integer B. Find and return all unique combinations in A where the sum of elements is equal to B.
Elements of input array can be repeated any number of times.
One combination should be saved in increasing order. Order of different combinations doesn't matter.
*/

public class Combinational_Sum {
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int sum) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        
        Arrays.sort(arr);
        
        // Forgot to remove duplicates
        
        int duplicates = 0;
        for(int i = 0;i < arr.length-1; i++){
            
            if(arr[i] == arr[i+1]){
                duplicates++;
            }
        }
        
        int[] new_arr = new int[arr.length - duplicates];
        
        int k = 1;
        new_arr[0] = arr[0];
        for(int i = 1;i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                new_arr[k] = arr[i];
                k++;
            }
        }
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        return combinationSum(new_arr, sum, 0,list, 0);
		
	}
    
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int sum,int result,ArrayList<Integer> list,int index) {
     
        ArrayList<ArrayList<Integer>> answer = new  ArrayList<ArrayList<Integer>>();
         
        if(result == sum){
          answer.add(list);
          return answer;  
        }
        
        if(result > sum){
            return null;
        }
        
        for(int i = index; i < arr.length; i++) {
           list.add(new Integer(arr[i])); 
           ArrayList<ArrayList<Integer>> temp =  combinationSum(arr, sum, result + arr[i],list,i);
           if(temp != null){
               for(ArrayList<Integer> a : temp){
                   ArrayList<Integer> copy_list = new ArrayList<Integer>();
                   if(a != null){
                       for(Integer it : a)
                       copy_list.add(it);
                   }
                   answer.add(copy_list);
               }
           } 
           list.remove(new Integer(arr[i])); 
        }
        
        return answer;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,2,6,5};
        int sum = 16;
        ArrayList<ArrayList<Integer>> res = combinationSum(arr, sum);
        for(int i = 0; i < res.size(); i++) {
        	ArrayList<Integer> temp = res.get(i);
            for(int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }

	}

}
