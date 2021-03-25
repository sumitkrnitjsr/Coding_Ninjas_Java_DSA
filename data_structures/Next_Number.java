package data_structures;

import data_structures.Palindrome_Linked_List.LinkedListNode;

// Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).


public class Next_Number {
	
	 public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
	    	if(head == null || head.next == null){
	            return head;
	        }    
	        
	        LinkedListNode<Integer> prev = null;
	        LinkedListNode<Integer> current = head;
	        LinkedListNode<Integer> next = current.next;
	        
	        while(current != null){
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        return prev;
	    }
	    
	    
		public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {

	        LinkedListNode<Integer> rev = reverse(head);
	        LinkedListNode<Integer> prev = null;
	        int carry = 1;
	        LinkedListNode<Integer> store = rev; // forgot to store value
	        while(rev != null && carry == 1){
	            int data = rev.data;
	            carry = (data == 9)?1:0;
	            rev.data = (carry == 1)?0:(data+1);
	            prev = rev;
	            rev = rev.next;
	        }
	        
	        if(carry == 1){
	        	Integer d = new Integer(1);
	        	// Uncomment to remove error in code
	            // LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(d);
	           // prev.next = newNode;
	        }
	        
	        return reverse(store);
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
