package Object_Oriented_Programming;

public class DynamicArray {
	
	private int size = 5;
	private int[] array ;
	private int currentIndex;
	
	public DynamicArray() {
		array = new int[size]; 
		currentIndex  = 0;
	}
	
	public void add(int n) {
		
		if(currentIndex == size) {
			restructure();
		}
		
		array[currentIndex] = n;
		currentIndex++;
	}
	
	private void restructure() {
		
		int[] temp = array;
		size *= 2;
		array = new int[size];
		for(int i = 0;i < temp.length; i++) {
			array[i] = temp[i];
		}
		
	}
	
	public int size() {
		return currentIndex;
	}
	
	public void set(int position, int n) {
		if(position < 0 || position > size()) {
			throw new ArithmeticException(" Wrong index");
		}
		
		if(position < currentIndex) {
			array[position] = n;
			return;
		}
		
		add(n);
		
	}
	
	
	public int get(int position) {
		if(position < 0 || position >= currentIndex) {
			throw new ArithmeticException("Wrong Index");
		}
		
		return array[position];
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public int removelast() {
		if(isEmpty()) {
			throw new ArithmeticException(" Already Empty");
		}
		
		int value = array[currentIndex-1];
		array[currentIndex-1] = 0;
		currentIndex--;
		return value;
		
	}

}
