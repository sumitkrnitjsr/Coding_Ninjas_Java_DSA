package test_ll_queue;

/*
Given a Linked List, which has nodes in alternating ascending and descending orders. Sort the list efficiently and space complexity should be O(1).
You just need to return the head of sorted linked list, don't print the elements.
*/


public class sort_alternate_ll {
	
	  public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
	        
	        LinkedListNode<Integer> current = head;
	        LinkedListNode<Integer> prev = null;
	        LinkedListNode<Integer> next;
	        
	        while(current != null){
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        
	        head = prev;
	        
	        return head;
	    }
	    
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

	    

		public static LinkedListNode<Integer> sort(LinkedListNode<Integer> head) {
			//Your code goes here
	        if(head == null || head.next == null){
	            return head;
	        }
	        
	        LinkedListNode<Integer> asc = new LinkedListNode<Integer>(0);
	        LinkedListNode<Integer> desc = new LinkedListNode<Integer>(0);
	        LinkedListNode<Integer> a = asc;
	        LinkedListNode<Integer> d = desc;
	        LinkedListNode<Integer> current = head;
	        
	        while(current != null){
	            asc.next = current;
	            asc = asc.next;
	            current = current.next;
	            
	            if(current != null){
	                desc.next = current;
	                desc = desc.next;
	                current = current.next;
	            }
	        }
	        
	        asc.next = null;
	        desc.next = null;
	        
	        a = a.next;
	        d = d.next;
	        
	        d = reverse(d);
	        
	        return mergeTwoSortedLinkedLists(a,d);
		}


		

}
