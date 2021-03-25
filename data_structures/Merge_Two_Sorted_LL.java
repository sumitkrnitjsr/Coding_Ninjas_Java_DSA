	package data_structures;
import data_structures.Palindrome_Linked_List.LinkedListNode;
/*
You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.
*/		
		
public class Merge_Two_Sorted_LL {
	
	 public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
	        
	        if(head1 == null){
	            return head2;
	        }
	        
	        if(head2 == null){
	            return head1;
	        }
	        
	        LinkedListNode<Integer> head = null;
	        LinkedListNode<Integer> t1 = head1;
	        LinkedListNode<Integer> t2 = head2;
	        LinkedListNode<Integer> tail = null;
	        head = tail = (t1.data < t2.data)?t1:t2;
	        t1 = (head == t1)?t1.next:t1;
	        t2 = (head == t2)?t2.next:t2;
	        while(t1 != null && t2 != null){
	            if(t1.data < t2.data){
	            	tail.next = t1;
	            	t1 = t1.next;
	            }else{
	            	tail.next = t2;
	            	t2 = t2.next;
	            }
	            tail = tail.next;
	        }
	        
	        if(t1 == null){
	            tail.next = t2;
	        }else{
	            tail.next = t1;
	        }
	        
	        return head;
	    }


	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
