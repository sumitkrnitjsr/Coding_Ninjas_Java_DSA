package data_structures;
import data_structures.Palindrome_Linked_List.LinkedListNode;

class Result{
LinkedListNode<Integer> head;
LinkedListNode<Integer> tail;
}


public class kReverseLinkedList {
	
	  public static LinkedListNode<Integer> kthNode(LinkedListNode<Integer> head, int k){
	        if(k == 0){
	            return head;
	        }
	        
	        while(head != null && k > 0){
	            head = head.next;
	            k--;
	        }
	        
	        if(head == null){
	            return head;
	        }
	        
	        return head.next;
	    }

	    public static Result reverse(LinkedListNode<Integer> head){
	    	
	        if(head == null){
	        return null;
	    	}
	        Result result = new Result();
	        result.tail = head;
	        LinkedListNode<Integer> prev = null;
	        LinkedListNode<Integer> current = head;
	        LinkedListNode<Integer> next = head.next;
	        while(current != null){
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        result.head = prev;
	        return result;
	    }
	    
	    
	    
	    
		public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
			
	        if(k < 2 || head == null){
	            return head;
	        }
	        
	        LinkedListNode<Integer> h1 = head;
	        LinkedListNode<Integer> t1 = head;
	        LinkedListNode<Integer> n1 = head;
	        LinkedListNode<Integer> t2 = null;
	        LinkedListNode<Integer> final_head = null;
	        while(h1 != null){
	            
	            int i = 1;
	            
	            while( t1 != null && i < k){
	                t1 = t1.next;
	                i++;
	            }
	            
	            final_head = (final_head == null)?t1:final_head;
	            
	            n1 = (t1 != null)?t1.next:null;
	            
	            if(t1 != null){
	            	t1.next = null;
	            }
	            
	            Result result = reverse(h1);
	            result.tail.next = n1;
	            if(t2 != null){
	              t2.next = result.head;  
	            } 
	            
	            h1 = n1;
	            t1 = n1;
	            t2 = result.tail;
	        }

	        
	        return final_head;
	        
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
