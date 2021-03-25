package data_structures;
import java.util.LinkedList;

public class java_collections_ll {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>(); // Doubly Linked List
		list.add(10);
		list.add(100);
		list.addFirst(20);
		System.out.println(list.get(0));
		list.addLast(30);
		list.add(50);
		
		list.set(0, 0);
		System.out.println(list.size());
		for(int elem:list) {
			System.out.print(elem + " ");
		}
		
		
	}

}
