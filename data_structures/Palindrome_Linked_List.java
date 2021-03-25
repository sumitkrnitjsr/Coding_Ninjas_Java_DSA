package data_structures;

public class Palindrome_Linked_List {
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;
    
    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}
	
	
	 public static LinkedListNode<Integer> breakMid(LinkedListNode<Integer> head){
	        LinkedListNode<Integer> slow = head;
	        LinkedListNode<Integer> fast = head;
	        while(fast != null && fast.next != null){ // NullPointerException
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }

	    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
	        if(head == null || head.next == null){
	            return head;
	        }
	        
	        LinkedListNode<Integer> previous = null; // Wrong initializations
	        LinkedListNode<Integer> current = head;
	        LinkedListNode<Integer> next = null; // Wrong initializations
	        while(current != null){
	            next = current.next; // Wrong orders
	            current.next = previous;
	            previous = current;
	            current = next;
	        }
	        head = previous;
	        return head;
	    }
	    
	    public static boolean compare(LinkedListNode<Integer> node1, LinkedListNode<Integer> node2){
	        
	        if(node1 == node2){
	            return true;
	        }
	        
	        while(node1 != null && node2 != null){
	            if(node1.data != node2.data){
	                return false;
	            }
	            node1 = node1.next;
	            node2 = node2.next;
	        }
	        return true;
	        
	    }
	    
	    
		public static boolean isPalindrome(LinkedListNode<Integer> head) {
			//Your code goes here
	        if(head == null || head.next == null){
	            return true;
	        }
	        
	        if(head.next.next == null){
	            if(head.data == head.next.data){
	                return true;
	            }
	            return false;
	        }
	        
	        LinkedListNode<Integer> mid = breakMid(head);
	        LinkedListNode<Integer> last = reverse(mid);
	        boolean answer = compare(head, last);
	        LinkedListNode<Integer> mid_node = reverse(last);
	        mid.next = mid_node;
	        return answer;
		}
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
