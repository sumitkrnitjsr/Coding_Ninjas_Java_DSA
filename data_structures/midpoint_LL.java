package data_structures;

import data_structures.Palindrome_Linked_List.LinkedListNode;

public class midpoint_LL {
	
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        
        while(fast != null && fast.next != null && fast.next.next != null){ // forgot fast.next.next check
        	slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
