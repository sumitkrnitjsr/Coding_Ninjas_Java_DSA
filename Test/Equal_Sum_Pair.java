package Test;
import java.util.*;

/*
Given an integer array of size N, determine whether 4 elements exist such that a+b = c+d. Return true or false accordingly.
Perform this in O(n^2).
Note : (a+b) and (c+d) is unique. For eg, array(10, 10, 8, 9) Pair(10(at index 0),8) and Pair(10(at index 1),8) are different pairs but Pair(10(index 0),10(index 1)) and Pair(10(index 1),10(index0)) are same.
*/

class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Equal_Sum_Pair {
	
	

	public static boolean findPairs(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return the desired output and don't print anything.
         * Taking input and printing output is handled automatically.
         */
        
        if(arr == null || arr.length < 1){
            return false;
        }
        
        HashMap<Integer, Node> map = new HashMap<>();
        
        for( int i=0; i<arr.length; i++){
            
            for(int j=i+1; j<arr.length; j++){
                
                int sum = arr[i] + arr[j];
                int i1 = 0;
                int j1 = 0;
                boolean i_b = false;
                boolean j_b = false;
                
                if(map.size() > 0 && map.containsKey(sum)){
                    
                    Node paired = map.get(sum);
                    i1 = paired.x;
                    j1 = paired.y;

                    if(i1 != i && i1 != j){
                        i_b = true;
                    }
                    
                    if(j1 != i && j1 != j){
                        j_b = true;
                    }
                }
                if(i_b && j_b){
                    return true;
                }
                
                Node node = new Node(i,j);
                map.put(sum,node);
                
            }

        }
        
        return false;
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
