package queues;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class QueueLL {
	
	 private Node front;
	    private Node rear;
	    private int size;

		public QueueLL() {
			//Implement the Constructor
	        front = null;
	        rear = null;
	        size = 0;
		}
		


		/*----------------- Public Functions of Stack -----------------*/


		public int getSize() { 
			//Implement the getSize() function
	        return size;
	    }


	    public boolean isEmpty() { 
	    	//Implement the isEmpty() function
	        return (size == 0);
	    }


	    public void enqueue(int data) {
	    	//Implement the enqueue(element) function
	        Node newNode = new Node(data);
	        if(front == null){
	            front = newNode;
	            rear = newNode;
	        }else{
	           rear.next = newNode;
	            rear = rear.next;
	        }
	        size++; // forgot to update size variable
	    }


	    public int dequeue() throws QueueEmptyException {
	    	//Implement the dequeue() function
	        if(front == null){
	            throw new QueueEmptyException();
	        }
	        int temp = front.data;
	        front = front.next;
	        size--; // forgot to update size variable
	        if(size == 0) {
	        	rear = null;  // forgot to update rear
	        }
	        return temp;
	    }


	    public int front() throws QueueEmptyException {
	    	//Implement the front() function
	        if(front == null){
	            throw new QueueEmptyException();
	        }
	        return front.data;
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
