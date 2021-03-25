package data_structures;
import data_structures.Palindrome_Linked_List.LinkedListNode;

public class Insertion_Sort_Linked_List {
	
	public static LinkedListNode<Integer> insertionSort(LinkedListNode<Integer> head) {
		if(head == null || head.next == null){
            return head;
        }
        
        LinkedListNode<Integer> itr = head;
        LinkedListNode<Integer> current = head.next;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> prev_current = head;
        while(current != null){
            
            while(itr.data <= current.data && itr != current){
                prev = itr;
                itr = itr.next;
            }
            
            if(itr == current){  // forgot to move prev_current in normal scenarion
                prev_current = itr;
                itr = head;
                prev = null;
                current = current.next;
                continue;
            }
            
            if(prev == null){
                prev_current.next = current.next;
                current.next = head;
                head = current;
                itr = head;
                current = prev_current.next;
                prev = null;
            }else{
                prev_current.next = current.next;
                current.next = itr;
                prev.next = current;
                itr = head;
                current = prev_current.next;
                prev = null;
            }
        }
        
        
        return head;

	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
