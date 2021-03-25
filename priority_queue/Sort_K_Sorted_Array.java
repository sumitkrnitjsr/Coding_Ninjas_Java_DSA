package priority_queue;
import java.util.PriorityQueue;

// elements within k distance from their original index in sorted order {2, 1, 4, 8, 6, 9}, k = 2


public class Sort_K_Sorted_Array {
	
	public static void ksorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i;
		for(i = 0;i < k;i++) {
			pq.add(arr[i]);
		}
		
		for(;i < arr.length;i++) {
			arr[i - k] = pq.remove();
			pq.add(arr[i]);
		}
		
		for(int j = arr.length - k;j < arr.length;j++) {
			arr[j] = pq.remove();
		}
	}
	
	
	

	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 8, 6, 9};
		ksorted(arr, 3);
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
