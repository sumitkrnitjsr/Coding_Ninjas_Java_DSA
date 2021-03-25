package data_structures;
import data_structures.Palindrome_Linked_List.LinkedListNode;

// Given a singly linked list of integers, reverse it using recursion and return the head to the modified list. You have to do this in O(N) time complexity where N is the size of the linked list.
		

public class reverse_ll_recursive {
	
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
        if(head == null){
            return head;
        }
        return reverseLinkedListRec(null, head);
	}
    
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> prev, LinkedListNode<Integer> current) {

        if(current.next == null){
            current.next = prev;
            return current;
        }
        
        LinkedListNode<Integer> next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        
        return reverseLinkedListRec(prev,current);
	}
	
	public static LinkedListNode<Integer> reverseR(LinkedListNode<Integer> head){
		
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> finalHead = reverseR(head.next);
		LinkedListNode<Integer> temp = finalHead;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = head;
		head.next = null;
		
		return finalHead;
		
	}
	
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
		
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> finalHead = reverse(head.next);
		LinkedListNode<Integer> temp = finalHead;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = head;
		head.next = null;
		return finalHead;
	}
	
	public static DoubleNode reverseBetter(LinkedListNode<Integer> head) {
		
		DoubleNode ans = new DoubleNode();
		if(head == null || head.next == null) {
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		
		DoubleNode smallAns = reverseBetter(head.next);
		
		smallAns.tail.next = head;
		head.next = null;
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}
	
	public static LinkedListNode<Integer> reverseBest(LinkedListNode<Integer> head){
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> tail = head.next;
		LinkedListNode<Integer> final_head = reverseBest(head.next);
		
		tail.next = head;
		head.next = null;
		
		return final_head;
	}
	
	
	public static LinkedListNode<Integer> reverseLLR(LinkedListNode<Integer> head){
		
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode<Integer> tail = head.next;
		LinkedListNode<Integer> final_head = reverseLLR(head.next);
		
		tail.next = head;
		head.next = null;
		
		return final_head;
		
	}
	
	public static LinkedListNode<Integer> reverse_Iterative(LinkedListNode<Integer> head){
        
        if(head == null || head.next == null){
            return head;
        }
        
		LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> temp = current.next;
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
