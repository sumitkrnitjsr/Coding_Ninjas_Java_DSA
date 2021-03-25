package priority_queue;

public class In_Place_Heap_Sort {
	

    private static void insertIntoHeap(int[] arr, int index){
        int childIndex = index;
        int parentIndex = (childIndex - 1)/2;
        
        while(childIndex > 0){
            if(arr[childIndex] > arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            }else{
                return;
            }
        }
    }
    
    private static int removeFromHeap(int[] arr,int size){
    	int temp = arr[0];
        arr[0] = arr[size - 1];
        int parentIndex = 0;
        int left = (2 * parentIndex) + 1;
        int right = left + 1;
        while(left < size){
            int maxIndex = parentIndex;
            if(arr[left] > arr[maxIndex]){
                maxIndex = left;
            }
            if(right < size && arr[right] > arr[maxIndex]){
                maxIndex = right;
            }
            if(maxIndex == parentIndex){
                return temp;
            }
            int temp2 = arr[maxIndex];
            arr[maxIndex] = arr[parentIndex];
            arr[parentIndex] = temp2;
            parentIndex = maxIndex;
            left = (2 * parentIndex) + 1;
            right = left + 1;
        }
        return temp;
    }
    
    
    
	public static void inplaceHeapSort(int arr[]) {
		if(arr.length < 2){
            return;
        }
		
        for(int i = 0;i < arr.length;i++){
            insertIntoHeap(arr, i);
        }
        
        for(int i = 0;i < arr.length - 1;i++){
            arr[arr.length - i - 1] = removeFromHeap(arr, arr.length - i);
        }
        
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
