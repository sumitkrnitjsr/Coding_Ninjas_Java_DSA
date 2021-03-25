package queues;

public class QueueArray {
	
	private int[] data;
	private int size;
	private int front;
	private int rear;
	
	public QueueArray() {
		data = new int[10];
		size = 0;
		front = -1;
		rear = -1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public int front() throws QueueEmptyException{
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		
		return data[front];
	}
	
	
	public void enqueue(int elem) throws QueueFullException{
		if(size() == data.length) {
			throw new QueueFullException();
			// doubleCapacity();
		}
		
		front = (size == 0)?0:front;  // forgot to update front
		rear = (rear + 1)%data.length;
		data[rear] = elem;
		size++;
		
	}
	
	public void doubleCapacity() {
		int[] temp = data;
		data = new int[2 * temp.length];
		int index = 0;
		
		for(int i = front;i < temp.length;i++) {
			data[index] = temp[i];
			index++;
		}
		
		for(int i = 0;i <= front - 1;i++) {
			data[index] = temp[i];
			index++;
		}
		
		front = 0;
		rear = temp.length - 1;
	}
	
	
	public int dequeue() throws QueueEmptyException{
		
		if(size() == 0) {
			throw new QueueEmptyException();
		}
		
		int temp = data[front];
		size--; // forgot to update size
		if(size == 0) {
			front = -1;
			rear = -1;
		}else {
			front = (front+1)%data.length;
		}
		
		return temp;
	}

}
