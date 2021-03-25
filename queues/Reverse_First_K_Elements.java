package queues;
import java.util.Queue;

/*
For a given queue containing all integer data, reverse the first K elements.
You have been required to make the desired change in the input queue itself.
*/


public class Reverse_First_K_Elements {

	 public static void reverseK(Queue<Integer> input, int k){
	        
	        if(k == 0){
	            return;
	        }
	        
	        int elem = input.poll();
	        reverseK(input, k-1);
	        input.add(elem);
	    }

		public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
			//Your code goes here
	        if(k < 0){
	            return input;
	        }
	        
	        if(input == null || k > input.size()){
	            return input;
	        }
	        
	        reverseK(input, k);
	        
	        for(int i = 0;i < input.size() - k; i++){
	            int elem = input.poll();
	            input.add(elem);
	        }
	        
	        return input;
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
