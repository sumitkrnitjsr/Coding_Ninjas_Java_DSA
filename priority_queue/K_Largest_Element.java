package priority_queue;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
*/

public class K_Largest_Element {
	
	public static ArrayList<Integer> kLargest(int input[], int k) {
		ArrayList<Integer> result = new ArrayList<>();
        if( k == 0 || input.length == 0){
            return result;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        for(i = 0;i < k;i++){
            pq.add(input[i]);
        }
        
        while(i < input.length){
            if(pq.peek() < input[i]){
                pq.remove();
                pq.add(input[i]);
            }
            i++;
        }
		
        for(i = 0;i < k;i++){
            result.add(pq.remove());
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
