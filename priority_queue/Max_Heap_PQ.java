package priority_queue;
import java.util.ArrayList;


public class Max_Heap_PQ {
	
	// Complete this class
    private ArrayList<Integer> heap;
    
    public Max_Heap_PQ(){
        heap = new ArrayList<>();
    }
    
	boolean isEmpty() {
		// Implement the isEmpty() function here
        return (heap.size()  == 0);
	}

	int getSize() {
		// Implement the getSize() function here
        return heap.size();
	}

	int getMax(){
		// Implement the getMax() function here
        if (isEmpty()) {
			// Throw an exception
			return -1;
		}
        
        return heap.get(0);
	}

	void insert(int element) {
		// Implement the insert() function here
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1)/2;
        while(childIndex > 0){
            
            if(heap.get(parentIndex) < heap.get(childIndex)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            }else{
                return;
            }
        }
	}
    

	int removeMax(){
		// Implement the removeMax() function here
  			if (isEmpty()) {
			// Throw an exception
			return -1;
		}
        
        int result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int parentIndex = 0;
        int leftIndex = (2 * parentIndex) + 1;
        int rightIndex = leftIndex + 1;
        
        while(leftIndex < heap.size()){
            int maxIndex = parentIndex;
            
            if(heap.get(leftIndex) > heap.get(maxIndex)){
                maxIndex = leftIndex;
            }
            
            if(rightIndex < heap.size() && heap.get(maxIndex) < heap.get(rightIndex)){
                maxIndex = rightIndex;
            }
            
            if(maxIndex == parentIndex){
                return result;
            }
            
            int temp = heap.get(maxIndex);
            heap.set(maxIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = maxIndex;
            leftIndex = (2 * parentIndex) + 1;
            rightIndex = leftIndex + 1;
        }
        
        return result;
	}

}
