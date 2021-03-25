package queues;
import java.util.Queue;
import java.util.LinkedList;

// Implement a Stack Data Structure specifically to store integer data using two Queues. You have to implement it in such a way that the push operation is done in O(1) time and the pop and top operations are done in O(N) time.

public class QueueCollections {

	private Queue<Integer> data;
    private Queue<Integer> temp;
    private int size;

    public QueueCollections() {
        //Implement the Constructor
        data = new LinkedList<>();
        temp = new LinkedList<>();
        size = 0;
    }

    public int getSize() { 
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void push(int element) {
        data.add(element);
        size++;
    }

    public int pop() {
        
        if(data.isEmpty()){
            return -1;
        }
        
        while(data.size() != 1){
            temp.add(data.poll());
        }
        
        int elem = data.poll();
        
        Queue<Integer> temp_queue = data;
        data = temp;
        temp = temp_queue;
        
        size--;
        return elem;
    }

    public int top() {
        
        if(data.isEmpty()){
        	return -1;    
        }
        
         while(data.size() != 1){
            temp.add(data.poll());
        }
        
        int elem = data.poll();
        
        Queue<Integer> temp_queue = data;
        data = temp;
        temp = temp_queue;
        data.add(elem);
        
        return elem;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
