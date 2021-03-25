package data_structures;

import data_structures.Palindrome_Linked_List.LinkedListNode;

public class Merge_Sort_LL {
	
	public static LinkedListNode<Integer> break_mid(LinkedListNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        
        while(fast != null && fast.next !=  null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    
    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> first, LinkedListNode<Integer> second){
    
        if(first == null){
        	return second;
    	}
        
        if(second == null){
            return first;
        }
        
        LinkedListNode<Integer> t1 = first;
        LinkedListNode<Integer> t2 = second;
        LinkedListNode<Integer> head = (t1.data > t2.data)?t2:t1;
        t1 = (t1 == head)?t1.next:t1;
        t2 = (t2 == head)?t2.next:t2;
        LinkedListNode<Integer> tail = head;
        
        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                tail.next = t1;
                t1 = t1.next;
            }else{
                tail.next = t2;
                t2 = t2.next;
            }
            tail = tail.next; // forgot to increment tail
        }
        
        if(t1 == null){
            tail.next = t2;
        }
        
        if(t2 == null){
            tail.next = t1;
        }
        
        return head;
    }
    
    
    
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		if(head == null || head.next == null){
            return head;
        }
        
        LinkedListNode<Integer> mid = break_mid(head);
        LinkedListNode<Integer> first = head;
        LinkedListNode<Integer> second = (mid == null)?null:mid.next;
        mid.next = null;
        
        LinkedListNode<Integer> head1 = mergeSort(first);
        LinkedListNode<Integer> head2 = mergeSort(second);
        
        return merge(head1, head2);
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
