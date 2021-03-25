package stacks;

public class StackArray {
	
	private int[] data;
	private int top;
	
	public StackArray(){
		data = new int[10];
		top = -1;
	}
	
	public StackArray(int capacity){
		data = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public int size() {
		return (top + 1);
	}
	
	public int top() throws StackEmptyException{
		
		if(size() == 0) {
			StackEmptyException ex = new StackEmptyException();
			throw ex;
		}
		
		return data[top];
	}
	
	public void push(int elem) throws StackFullException {
		
		if(size() == data.length) {
			// doubleCapacity();
			StackFullException ex = new StackFullException();
			throw ex;	
		}
		
		top++;
		data[top] = elem;
	}
	
	private void doubleCapacity() {
		
		int[] temp = data;
		data = new int[2 * temp.length];
		
		for(int i = 0;i <= top;i++) {
			data[i] = temp[i];
		}
		
	}
	
	public int pop() throws StackEmptyException{
		
		if(size() == 0) {
			StackEmptyException ex = new StackEmptyException();
			throw ex;
		}
		
		int temp = data[top];
		top--;
		
		return temp;
	}

}
