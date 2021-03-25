package priority_queue;
import java.util.ArrayList;

public class PriorityQueue {

	private ArrayList<Integer> heap;
	
	public PriorityQueue(){
		heap = new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return (heap.size() == 0);
	}
	
	public int size() {
		return heap.size();
	}
	
	public int getMin() throws HeapEmptyException{
		if(isEmpty()) {
			throw new HeapEmptyException();
		}
		
		return heap.get(0);
	}
	
	public void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1)/2;
		
		while(childIndex > 0) {
			if(heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex)); // don't use heap.add
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1)/2;
			}else {
				return;
			}
		}
		
	}
	
	public int removeMinSelf() throws HeapEmptyException{
		
        if(isEmpty()){
            throw new HeapEmptyException();
        }
        
        int result = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        int childIndex = (2 * parentIndex) + 1;
        
        while(childIndex < size()){
            int left = childIndex;
            int right = left + 1;
     		int leftChild = heap.get(left);
            int rightChild = (right < size())?heap.get(right):Integer.MAX_VALUE;
            int min = Math.min(heap.get(parentIndex), Math.min(rightChild, leftChild));
            if(min == heap.get(parentIndex)){
                return result;
            }else if(min == heap.get(left)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(left));
                heap.set(childIndex, temp);
                parentIndex = childIndex;
                childIndex = (2 * parentIndex) + 1;
            }else if(min == rightChild && right < size()){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(right));
                heap.set(right, temp);
                parentIndex = childIndex + 1;
                childIndex = (2 * parentIndex) + 1;
            }else{
                return result;
            }
        }
        return result;
	}
	
	private int removeMin() throws HeapEmptyException{
		if(isEmpty()) {
			throw new HeapEmptyException();
		}
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int index = 0;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		while(leftChildIndex < heap.size()) {
		if(heap.get(leftChildIndex) < heap.get(minIndex)) {
			minIndex = leftChildIndex;
		}
		
		if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
			minIndex = rightChildIndex;
		}
		
		if(minIndex == index) {
			break;
		}else {
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				index = minIndex;
				leftChildIndex = (2 * index) + 1;
				rightChildIndex = leftChildIndex + 1;
			}
		}
		
		return temp;
	}
}
