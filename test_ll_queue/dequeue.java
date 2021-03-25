package test_ll_queue;

/*
You need to implement a class for Dequeue i.e. for double ended queue. In this queue, elements can be inserted and deleted from both the ends.
You don't need to double the capacity.
*/

public class dequeue {

	public class Dequeue {
	    // Complete this class
	    int[] arr;
	    int front;
	    int rear;
	    int size;
	    
	    public Dequeue(int cap){
	        arr = new int[cap];
	        front = -1;
	        rear = 0;
	        size = cap;
	    }
	    
	    public boolean isFull(){
	        return ((front == 0 && rear == size - 1) || (front == rear + 1));
	    }
	    
	    public boolean isEmpty(){
	        return (front == -1);
	    }
	    
	    public void insertFront(int val){
	        if(isFull()){
	            System.out.println("-1");
	            return;
	        }
	        
	        if(front == -1){
	            front = 0;
	            rear = 0;
	        }else if(front == 0){
	            front = size - 1;
	        }else{
	            front--;
	        }
	        
	        arr[front] = val;
	    }
	    
	    public void insertRear(int val){
	        if(isFull()){
	            System.out.println("-1");
	            return;
	        }
	        
	        if(front == -1){
	            front = 0;
	            rear = 0;
	        }else if(rear == size - 1){
	            rear = 0;
	        }else{
	            rear++;
	        }
	        arr[rear] = val;
	    }
	    
	    public void deleteFront(){
	        if(isEmpty()){
	            System.out.println("-1");
	            return;
	        }
	        
	        if(front == rear){
	            front = rear = -1;
	        }else{
	            
	            if(front == size - 1){
	                front = 0;
	            }else{
	                front++;
	            }
	        }
	        
	    }
	    
	    public void deleteRear(){
	         if(isEmpty()){
	            System.out.println("-1");
	            return;
	        }
	        
	        if(front == rear){
	            front = rear = -1;
	        }else{
	            
	            if(rear == 0){
	                rear = size - 1;
	            }else{
	                rear--;
	            }
	        }
	        
	        
	    }
	    
	    public int getFront(){
	        if(isEmpty()){
	           // System.out.println("-1");
	            return -1;
	        }
	        return arr[front];
	    }
	    
	    
	    public int getRear(){
	        if(isEmpty() || rear < 0){
	           // System.out.println("-1");
	            return -1;
	        }
	        return arr[rear];
	    }

	}
	    
}
