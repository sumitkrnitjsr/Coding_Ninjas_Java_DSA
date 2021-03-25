package priority_queue;
import java.util.PriorityQueue;

/*
Given an array A of random integers and an integer k, find and return the kth largest element in the array.
Note: Try to do this question in less than O(N * logN) time.
*/


public class Kth_Largest_Element {
	
	public static int kthLargest(int n, int[] input, int k) {
		if(k == 0 || input.length == 0){
            return Integer.MIN_VALUE;
        }
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        
        while(i < k){
            pq.add(input[i]);
            i++;
        }
        
        while(i < input.length){
            if(input[i] > pq.peek()){
                pq.remove();
                pq.add(input[i]);
            }
            i++;
        }
        return pq.remove();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
