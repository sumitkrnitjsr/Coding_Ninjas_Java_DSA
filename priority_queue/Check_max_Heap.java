package priority_queue;

// Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.

public class Check_max_Heap {
	
	public static boolean checkMaxHeap(int arr[]) {
		if(arr.length < 2){
            return true;
        }
        
        return checkMaxHeap(arr, 0, arr.length);
	}
    
    private static boolean checkMaxHeap(int arr[], int index, int n){
        if(index >= n){
            return true;
        }
        
        int current = arr[index];
        int left = (((2 * index) + 1) < n)?arr[(2 * index) + 1]:Integer.MIN_VALUE;
        int right = (((2 * index) + 2) < n)?arr[(2 * index) + 2]:Integer.MIN_VALUE;
        if( current < left || current < right){
            return false;
        }
        
        return checkMaxHeap(arr, (2 * index) + 1, n) && checkMaxHeap(arr, (2 * index) + 2, n);
    }

}
