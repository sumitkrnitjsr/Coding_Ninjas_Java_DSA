package data_structures;
import data_structures.Palindrome_Linked_List.LinkedListNode;

public class Bubble_Sort_Linked_List {
	
	 public static int findlength(LinkedListNode<Integer> head){
	        if(head == null){
	            return 0;
	        }
	        
	        if(head.next == null){
	            return 1;
	        }
	        
	        int length = 1;
	        while(head != null){
	            head = head.next;
	            length++;
	        }
	        
	        return length;
	    }
	    
		public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
			if(head == null || head.next == null){
	            return head;
	        }
	        
	        LinkedListNode<Integer> prev = head;
	        LinkedListNode<Integer> current = head;
	        LinkedListNode<Integer> next = current.next;
	        int length = findlength(head);
	        for(int i = 0;i < length;i++){
	            current = head;
	            next = current.next;
	            prev = null;
	            while(current != null && next != null){ // forgot next null check
	                if(current.data <= next.data){
	                 prev = current;
	                 current = next;
	                 next = current.next;   
	                }else{
							if(head == current){
	                       		head = next;
	                        }
	                       current.next = next.next;
	                       next.next = current;
	                    	if(prev != null){  // forgot updating the previous node
	                            prev.next = next;
	                        }
	                       prev = next;
	                       next = current.next; 
	                }
	            }
	        }
	    
	        return head;
		}


		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
