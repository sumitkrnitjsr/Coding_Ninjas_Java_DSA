package priority_queue;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are given a stream of N integers. For every i-th integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
*/


public class Running_Median {
	
public static void findMedian(int arr[])  {
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
         int elem = arr[i];   
         int max_elem = (max.size() > 0)?max.peek():Integer.MAX_VALUE;
         if(elem < max_elem){
             max.add(elem);
         }else{
             min.add(elem);
         }
         int dif = Math.abs(max.size() - min.size());    
         if(dif > 1){
             if(max.size() > min.size()){
                 int temp = max.remove();
                 min.add(temp);
             }else{
                 int temp = min.remove();
                 max.add(temp);
             }
         }
         if((i + 1)%2 == 0){
             int value = (int)((min.peek() + max.peek())/2);
             System.out.print(value + " ");
         }else{
             int value = (max.size() > min.size())?max.peek():min.peek();
             System.out.print(value + " ");
         }
            
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
