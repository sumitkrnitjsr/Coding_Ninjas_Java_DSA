package data_structures;

import data_structures.Palindrome_Linked_List.LinkedListNode;

// You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.


public class delete_every_n_nodes {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {

        if(M == 0){
            return null;
        }
        
        if(N == 0){
            return head;
        }
        
		int count_r = 1;
        int count_d = 0;
        
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> rhead = head;
        LinkedListNode<Integer> rtail = head;
        LinkedListNode<Integer> dhead = null;
        LinkedListNode<Integer> dtail = null;
        
        while(head != null){
            count_r = 1;
            while(head != null && count_r < M){
                count_r++;
                head = head.next;
            }
            
            if(head == null){
                break;
            }
            
            rtail = head;
            dhead = head.next;
            dtail = head.next;
            
            if(dhead == null){
                break;
            }
            
            count_d = 1;
            
            head = head.next;
            while(head != null && count_d < N){
                count_d++;
                head = head.next;
            }
            
            if(head == null){
                rtail.next = null; // Forgot to end list
                break;
            }
            
            dtail = head;
            
            rtail.next = dtail.next;
            
            head = head.next;
            
            rhead = head;
        }
        
        return temp;
	}
	

}
